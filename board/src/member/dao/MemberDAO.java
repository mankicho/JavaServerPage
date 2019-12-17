package member.dao;

import member.Member;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    public Member selectById(Connection conn, String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member = null;

        try {
            pstmt = conn.prepareStatement("select * from member where memberId = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                member = new Member(rs.getString("memberId"), rs.getString("password"), rs.getString("name"), rs.getDate("regdate"));
            }
            return member;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    public void insert(Connection conn, Member member) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("insert into board.member values(?,?,?,?)");
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPassword());
            pstmt.setDate(4, member.getRegDate());

            pstmt.execute();
        }finally {
            JdbcUtil.close(pstmt);
        }
    }


}
