package guestbook.service;

import guestbook.dao.MessageDAO;
import guestbook.exception.ServiceException;
import guestbook.model.Message;
import guestbook.util.JdbcUtil;
import jdbc.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GetMessageListService {
    private static GetMessageListService getMessageListService;
    private static final int MESSAGE_COUNT_PER_PAGE = 3;

    public synchronized static GetMessageListService getInstance() {
        if (getMessageListService == null) {
            getMessageListService = new GetMessageListService();
        }
        return getMessageListService;
    }

    private GetMessageListService() {

    }

    public MessageListView getMessageList(int pageNumber) {
        Connection conn = null;
        int currentPageNumber = pageNumber;
        try {
            conn = ConnectionProvider.getConnection();
            MessageDAO messageDAO = MessageDAO.getMessageDAO();

            int messageTotalCount = messageDAO.selectCount(conn);

            List<Message> messageList = null;
            int firstRow = 0;
            int endRow = 0;
            if (messageTotalCount > 0) {
                firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
                endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
                messageList = messageDAO.selectList(conn, firstRow, endRow);
            } else {
                currentPageNumber = 0;
                messageList = Collections.EMPTY_LIST;
            }
            return new MessageListView(messageTotalCount, currentPageNumber, messageList, MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
        } catch (SQLException e) {
            throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
        } finally {
            JdbcUtil.close(conn);
        }
    }
}