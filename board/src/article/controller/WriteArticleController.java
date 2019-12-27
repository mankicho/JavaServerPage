package article.controller;

import article.model.Writer;
import article.service.write.WriteArticleService;
import article.service.write.WriteRequest;
import service.login.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/writeArticle.do")
public class WriteArticleController extends HttpServlet {

    private final String FROM_VIEW = "/article/view/write/writeArticleForm.jsp";
    private WriteArticleService writeArticleService = new WriteArticleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(FROM_VIEW);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;

        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);

        User user = (User) req.getSession().getAttribute("authUser");
        WriteRequest writeRequest = createWriteRequest(user, req);
        writeRequest.validate(errors);

        if (!errors.isEmpty()) {
            dispatcher = req.getRequestDispatcher(FROM_VIEW);
            dispatcher.forward(req, resp);
            return;
        }

        int newArticleNo = writeArticleService.write(writeRequest);
        req.setAttribute("newArticleNo", newArticleNo);

        dispatcher = req.getRequestDispatcher("/article/view/write/writeArticleSuccess.jsp");
        dispatcher.forward(req, resp);

    }

    private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
        return new WriteRequest(new Writer(user.getId(), user.getName()), req.getParameter("title"), req.getParameter("content"));
    }
}
