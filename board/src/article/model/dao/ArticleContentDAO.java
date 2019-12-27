package article.model.dao;

import article.model.Article;
import article.model.ArticleContent;
import util.JdbcUtil;

import java.sql.*;
import java.util.Date;

public class ArticleContentDAO {

    public ArticleContent insert(Connection conn, ArticleContent articleContent) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("insert into board.article_content(article_no, content) values (?,?)");
            pstmt.setLong(1, articleContent.getNumber());
            pstmt.setString(2, articleContent.getContent());
            int insertedCount = pstmt.executeUpdate();

            // 성공적으로 쿼리가 이루어지면
            if (insertedCount > 0) {
                return articleContent;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(pstmt);
        }
    }

}
