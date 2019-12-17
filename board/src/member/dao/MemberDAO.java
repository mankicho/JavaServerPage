package member.dao;

import member.Member;
import util.JdbcUtil;

import java.sql.*;
import java.util.Date;

public class MemberDAO {

    public Member selectById(Connection conn, String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member = null;

        try {
            pstmt = conn.prepareStatement("select * from board.member where memberId = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                member = new Member(rs.getString("memberId"), rs.getString("password"),
                        rs.getString("name"), toDate(rs.getTimestamp("regdate")));
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
            pstmt.setTimestamp(4,new Timestamp(member.getRegDate().getTime()));

            pstmt.execute();
        } finally {
            JdbcUtil.close(pstmt);
        }
    }

    private Date toDate(Timestamp date) {
        return date == null ? null : new Date(date.getTime());
    }
}
