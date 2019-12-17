package service.join;

import jdbc.ConnectionProvider;
import member.Member;
import member.dao.MemberDAO;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class JoinService {
    private MemberDAO memberDAO = new MemberDAO();

    public void join(JoinRequest joinRequest) {
        Connection conn = null;
        try {
            // 커넥션 생성
            conn = ConnectionProvider.getConnection();
            // 트랜잭션 처리를 위한 AutoCommit false 처리
            conn.setAutoCommit(false);
            // Member table에 id가 있는지 조회
            Member member = memberDAO.selectById(conn, joinRequest.getId());
            if (member != null) {
                // id가 존재하면 철회.
                JdbcUtil.rollback(conn);
                throw new DuplicateIdException();
            }

            memberDAO.insert(conn, new Member(joinRequest.getId(), joinRequest.getName(), joinRequest.getPassword(), new Date()));
            conn.commit();
        } catch (SQLException e) {
            JdbcUtil.rollback(conn);
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn);
        }
    }
}
