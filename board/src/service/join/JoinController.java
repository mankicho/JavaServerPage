package service.join;


import service.join.DuplicateIdException;
import service.join.JoinRequest;
import service.join.JoinService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 뷰의 요청을 받아서 로직을 처리하기위한 컨트롤러
@WebServlet(urlPatterns = "/join.do")
public class JoinController extends HttpServlet {

    private final String FROM_VIEW = "/view/join/joinForm.jsp";
    private JoinService service = new JoinService();

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

        JoinRequest joinRequest = new JoinRequest();

        // 회원 가입 요청에 관한 정보를 담는 객체.
        joinRequest.setId(req.getParameter("id"));
        joinRequest.setName(req.getParameter("name"));
        joinRequest.setPassword(req.getParameter("password"));
        joinRequest.setConfirmPassword(req.getParameter("confirmPassword"));

        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        // 입력한 값이 맞는지 검사.
        joinRequest.validate(errors);

        // 에러가 하나라도 있으면 회원가입 뷰 다시.
        if (!errors.isEmpty()) {
            dispatcher = req.getRequestDispatcher(FROM_VIEW);
            dispatcher.forward(req, resp);
            return;
        }

        try {
            // 에러 없으면 회원가입 쿼리 실행.
            service.join(joinRequest);
            dispatcher = req.getRequestDispatcher("/view/join/joinSuccess.jsp");
            dispatcher.forward(req, resp);
        } catch (DuplicateIdException e) {
            // 아이디가 같은게 존재하면 회원가입 뷰 다시 보여줌.
            errors.put("duplicateId", Boolean.TRUE);
            dispatcher = req.getRequestDispatcher(FROM_VIEW);
            dispatcher.forward(req, resp);
        }
    }
}
