package controller.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/board/list.show")
public class BoardListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 요청 분석
        // 2. 모델을 이용한 로직 처리.
        // 3. 결과값을 request 혹은 session에 저장
        // 4. 뷰로 리턴
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/board/list.jsp");
        dispatcher.forward(req,resp);
    }
}
