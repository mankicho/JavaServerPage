package service.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = ("/login.do"))
public class LoginController extends HttpServlet {

    private final String FROM_VIEW = "/view/login/loginForm.jsp";
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processPost(req, resp);
    }


    private void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(FROM_VIEW);
        dispatcher.forward(req, resp);
    }

    private void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);

        if (id == null || id.isEmpty()) {
            errors.put("id", Boolean.TRUE);
        }

        if (password == null || password.isEmpty()) {
            errors.put("password", Boolean.TRUE);
        }

        if (!errors.isEmpty()) {
            dispatcher = req.getRequestDispatcher(FROM_VIEW);
            dispatcher.forward(req, resp);
            return;
        }

        try {
            User user = loginService.login(id, password);
            req.getSession().setAttribute("authUser", user);
            dispatcher = req.getRequestDispatcher("/view/index.jsp");
            dispatcher.forward(req,resp);
        } catch (LoginFailException e) {
            errors.put("idOrPasswordNotMatch", Boolean.TRUE);
            dispatcher = req.getRequestDispatcher(FROM_VIEW);
            dispatcher.forward(req, resp);
        }
    }
}
