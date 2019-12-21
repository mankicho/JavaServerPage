package service.login;

import jdbc.ConnectionProvider;
import member.Member;
import member.dao.MemberDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginService {

    private MemberDAO memberDAO = new MemberDAO();

    public User login(String id, String password) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            Member member = memberDAO.selectById(conn, id);
            if (member == null) {
                throw new LoginFailException();
            }

            if (!member.isMatched(password)) {
                throw new LoginFailException();
            }

            return new User(member.getId(), member.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
