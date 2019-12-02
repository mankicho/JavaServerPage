package guestbook.service;

import guestbook.dao.MessageDAO;
import guestbook.exception.ServiceException;
import guestbook.model.Message;
import guestbook.util.JdbcUtil;
import jdbc.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

public class WriteMessageService {
    private static WriteMessageService writeMessageService;

    public synchronized static WriteMessageService getInstance() {
        if (writeMessageService == null) {
            writeMessageService = new WriteMessageService();
        }
        return writeMessageService;
    }

    private WriteMessageService() {
    }

    public void write(Message message) {
        Connection conn = null;
        MessageDAO messageDAO = MessageDAO.getMessageDAO();
        try {
            conn = ConnectionProvider.getConnection();
            if (message.getName() == null || message.getName().isEmpty()) {
                throw new ServiceException("invalid guest name " + message);
            }
            messageDAO.insert(conn, message);
        } catch (SQLException e) {
            throw new ServiceException("메세지 삽입 실패 " + e.getMessage(), e);
        } finally {
            JdbcUtil.close(conn);
        }
    }
}
