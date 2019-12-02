package guestbook.service;

import guestbook.dao.MessageDAO;
import guestbook.exception.InvalidPasswordException;
import guestbook.exception.MessageNotFoundException;
import guestbook.exception.ServiceException;
import guestbook.model.Message;
import guestbook.util.JdbcUtil;
import jdbc.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteMessageService {
    private static DeleteMessageService deleteMessageService;

    public synchronized static DeleteMessageService getInstance() {
        if (deleteMessageService == null) {
            deleteMessageService = new DeleteMessageService();
        }
        return deleteMessageService;
    }

    private DeleteMessageService() {

    }

    public void deleteMessage(int messageId, String password) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            // 트랜잭션을 처리하기위해 AutoCommit를 false로 지정
            conn.setAutoCommit(false);

            // Message 테이블에 접근하는 객체
            MessageDAO messageDAO = MessageDAO.getMessageDAO();
            // messageId로 메세지 구한다
            Message message = messageDAO.select(conn, messageId);

            // 메세지가 없으면?
            if (message == null) {
                throw new MessageNotFoundException("메세지 없음");
            }
            // 메세지의 비밀번호가 맞지 않으면?
            if (!message.matchPassword(password)) {
                throw new InvalidPasswordException("비밀번호가 맞지 않습니다.");
            }
            // 메세지 삭제
            messageDAO.delete(conn, messageId);
            // 커밋.
            conn.commit();
        } catch (SQLException e) {
            // 에러 발생시 롤백
            JdbcUtil.rollback(conn);
            throw new ServiceException("메세지 삭제 실패 " + e.getMessage(), e);
        }catch (MessageNotFoundException | InvalidPasswordException e1){
            // 에러 발생시 롤백
            JdbcUtil.rollback(conn);
            throw e1;
        }finally {
            JdbcUtil.close(conn);
        }
    }
}
