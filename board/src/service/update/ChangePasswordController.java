package service.update;

import service.login.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/changePassword.do")
public class ChangePasswordController extends HttpServlet {

    private final String FROM_VIEW = "/view/update/changePasswordForm.jsp";
    private ChangePasswordService changePasswordService = new ChangePasswordService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processChangePassword(req, resp);
    }

    private void processChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // 세션에서 로그인한 유저의 정보 가져온다.
        User user = (User) session.getAttribute("authUser");
        Map<String, Boolean> errors = new HashMap<>();

        String curPassword = req.getParameter("curPassword");
        String newPassword = req.getParameter("newPassword");

        // 현재 비밀번호란에 아무것도 안치면 map에 put
        if (curPassword == null || curPassword.isEmpty()) {
            errors.put("curPassword", Boolean.TRUE);
        }
        // 새 비밀번호에 아무것도 안치면 map에 put
        if (newPassword == null || newPassword.isEmpty()) {
            errors.put("newPassword", Boolean.TRUE);
        }

        // 에러가있으면 다시 비밀번호 변경 폼
        if (!errors.isEmpty()) {
            forward(req, resp);
        }

        try {
            // 비밀번호 바꾸고 성공적으로 비밀번호 변경했다는 뷰를 리턴
            changePasswordService.changePassword(user.getId(), curPassword, newPassword);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/update/changePasswordSuccess.jsp");
            dispatcher.forward(req, resp);
        } catch (InvalidPasswordException e) {
            errors.put("isNotMatchedCurPassword", Boolean.TRUE);
            forward(req, resp);
            return;
        } catch (MemberNotFoundException e1) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(FROM_VIEW);
        dispatcher.forward(request, response);
    }
}
