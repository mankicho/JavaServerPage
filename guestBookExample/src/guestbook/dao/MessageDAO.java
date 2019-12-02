package guestbook.dao;


import guestbook.model.Message;
import guestbook.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    private static MessageDAO messageDAO;

    public synchronized static MessageDAO getMessageDAO() {
        if (messageDAO == null) {
            messageDAO = new MessageDAO();
        }
        return messageDAO;
    }

    private MessageDAO() {

    }

    public int insert(Connection conn, Message message) throws SQLException {
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("insert into guestbook.guestbook_message (guest_name, password, message) values(?,?,?)");
            pstmt.setString(1, message.getName());
            pstmt.setString(2, message.getPassword());
            pstmt.setString(3, message.getMessage());
            return pstmt.executeUpdate();
        } finally {
            JdbcUtil.close(pstmt);
            JdbcUtil.close(conn);
        }

    }

    public Message select(Connection conn, int messageId) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement("select * from guestbook.guestbook_message where message_id = ?");
            pstmt.setInt(1, messageId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return getMessage(rs);
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    private Message getMessage(ResultSet rs) throws SQLException {
        Message message = new Message();
        message.setId(rs.getInt("message_id"));
        message.setName(rs.getString("guest_name"));
        message.setPassword(rs.getString("password"));
        message.setMessage(rs.getString("message"));
        return message;
    }

    public int selectCount(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select count(*) from guestbook.guestbook_message");
        try {
            rs.next();
            return rs.getInt(1);
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(st);
        }
    }

    public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
        List<Message> messageList = new ArrayList<>();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("select * from guestbook.guestbook_message order by message_id desc limit ?,?");
            pstmt.setInt(1, firstRow - 1);
            pstmt.setInt(2, endRow - firstRow + 1);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                messageList.add(getMessage(rs));
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
        return messageList;
    }

    public int delete(Connection conn, int messageId) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("delete from guestbook.guestbook_message where message_id = ?");
            pstmt.setInt(1, messageId);
            return pstmt.executeUpdate();
        } finally {
            JdbcUtil.close(pstmt);
        }
    }
}
