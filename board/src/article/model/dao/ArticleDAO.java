package article.model.dao;

import article.model.Article;
import util.JdbcUtil;

import java.sql.*;
import java.util.Date;

public class ArticleDAO {
    public Article insert(Connection conn, Article article) throws SQLException {
        PreparedStatement pstmt = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // insert 쿼리 수행
            pstmt = conn.prepareStatement("insert into board.article(writer_id,writer_name,title,regdate,moddate,read_cnt) values(?,?,?,?,?,0)");
            pstmt.setString(1, article.getWriter().getId());
            pstmt.setString(2, article.getWriter().getName());
            pstmt.setString(3, article.getTitle());
            pstmt.setTimestamp(4, toTimeStamp(article.getRegDate()));
            pstmt.setTimestamp(5, toTimeStamp(article.getModifiedDate()));
            int insertedCount = pstmt.executeUpdate();

            // 성공적으로 쿼리를 수행하면
            if (insertedCount > 0) {
                st = conn.createStatement();
                // 마지막으로 삽입된 레코드의 기본키 값을 리턴한다.
                rs = st.executeQuery("select last_insert_id() from board.article");
                if (rs.next()) {
                    Integer newNum = rs.getInt(1);
                    // 성공적으로 쿼리 수행시 Article 객체 리턴.
                    return new Article(newNum, article.getWriter(), article.getTitle(), article.getRegDate(), article.getModifiedDate(), 0);
                }
            }
            return null;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(st);
            JdbcUtil.close(pstmt);
        }
    }

    private Timestamp toTimeStamp(Date date) {
        return new Timestamp(date.getTime());
    }

}
