package service.update;

import jdbc.ConnectionProvider;
import member.Member;
import member.dao.MemberDAO;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ChangePasswordService {
    MemberDAO memberDAO = new MemberDAO();

    public void changePassword(String id, String curPassword, String newPassword) {
        Connection connection = null;
        try {
            connection = ConnectionProvider.getConnection();
            connection.setAutoCommit(false);
            Member member = memberDAO.selectById(connection, id);

            if(member == null){
                throw new MemberNotFoundException();
            }
            if(!member.isMatched(curPassword)){
                throw new InvalidPasswordException();
            }

            member.changePassword(newPassword);
            memberDAO.update(connection,member);
            connection.commit();

        } catch (SQLException e) {
            JdbcUtil.rollback(connection);
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection);
        }
    }

}
