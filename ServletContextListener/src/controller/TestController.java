package controller;

import jdbc.ConnectionProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/test")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        test(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        test(req, resp);
    }

    private void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        RequestDispatcher dispatcher;
        try {
            // DBCPInitListener가 성공적으로 호출되서 커넥션이 생성되면
            conn = ConnectionProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            dispatcher = req.getRequestDispatcher("test.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("fail.jsp");
        }
        dispatcher.forward(req, resp);

    }
}
