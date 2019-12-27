package service.logout;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout.do")
public class LogoutController extends HttpServlet {

    private LogoutService logoutService = new LogoutService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processLogout(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processLogout(req, resp);
    }

    private void processLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            logoutService.logout(req,resp);
            resp.sendRedirect("/auth/view/logout/logoutSuccess.jsp");
        }catch (LogoutFailException e){
            // sendRedirect는 request와 resp가 유지되지않고 새로 생성됨.
            // RequestDispatcher는 request가 유지됨.
            resp.sendRedirect("/auth/view/logout/logoutFail.jsp");
        }
    }
}
