package article.service.write;

import article.model.Article;
import article.model.ArticleContent;
import article.model.dao.ArticleContentDAO;
import article.model.dao.ArticleDAO;
import jdbc.ConnectionProvider;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class WriteArticleService {

    private ArticleDAO articleDAO = new ArticleDAO();
    private ArticleContentDAO articleContentDAO = new ArticleContentDAO();

    public Integer write(WriteRequest req) {
        Connection conn = null;

        try {
            // connection production
            conn = ConnectionProvider.getConnection();
            // transaction
            conn.setAutoCommit(false);

            Article article = toArticle(req);
            Article savedArticle = articleDAO.insert(conn, article);
            if (savedArticle == null) {
                throw new RuntimeException("fail to insert article");
            }

            ArticleContent content = new ArticleContent(savedArticle.getNumber(), req.getContent());
            ArticleContent savedContent = articleContentDAO.insert(conn, content);

            if (savedContent == null) {
                throw new RuntimeException("fail to insert articleContent");
            }

            conn.commit();
            return savedArticle.getNumber();
        } catch (SQLException e) {
            JdbcUtil.rollback(conn);
            throw new RuntimeException(e);
        } catch (RuntimeException e1) {
            JdbcUtil.rollback(conn);
            throw e1;
        } finally {
            JdbcUtil.close(conn);
        }
    }

    private Article toArticle(WriteRequest req) {
        Date now = new Date();
        return new Article(null, req.getWriter(), req.getTitle(), now, now, 0);
    }
}
