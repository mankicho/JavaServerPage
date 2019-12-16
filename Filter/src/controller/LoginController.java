package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {
    private HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login(req,resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(session == null){
            // 요청에서 세션을 얻어서
            session = req.getSession();
        }

        RequestDispatcher dispatcher;

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        // 임시로 id 와 pw 가 manki 와 같으면 으로 설정.
        if (id.equals("manki") && pw.equals("manki")) {
            dispatcher = req.getRequestDispatcher("/index.jsp");
            // 아이디 비밀번호가 맞으면 MEMBER라는 속성에 id 값을 저장
            session.setAttribute("MEMBER",id);
        } else {
            dispatcher = req.getRequestDispatcher("/loginForm.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
