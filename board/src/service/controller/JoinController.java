package service.controller;


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

@WebServlet(urlPatterns = "/join.do")
public class JoinController extends HttpServlet {

    private final String FROM_VIEW = "/view/joinForm.jsp";
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

        joinRequest.setId(req.getParameter("id"));
        joinRequest.setName(req.getParameter("name"));
        joinRequest.setPassword(req.getParameter("password"));
        joinRequest.setConfirmPassword(req.getParameter("confirmPassword"));

        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);

        joinRequest.validate(errors);

        if (!errors.isEmpty()) {
            dispatcher = req.getRequestDispatcher(FROM_VIEW);
            dispatcher.forward(req, resp);
            return;
        }

        try {
            service.join(joinRequest);
            dispatcher = req.getRequestDispatcher("/view/joinSuccess.jsp");
            dispatcher.forward(req, resp);
        } catch (DuplicateIdException e) {
            errors.put("duplicateId", Boolean.TRUE);
            dispatcher = req.getRequestDispatcher(FROM_VIEW);
            dispatcher.forward(req, resp);
        }
    }
}
