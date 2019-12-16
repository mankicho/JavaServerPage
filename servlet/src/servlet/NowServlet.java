package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/")
public class NowServlet extends HttpServlet {

    // req와 resp는 JSP의 request와 response에 해당한다.
    // 톰캣이 서블릿 객체를 생성하고 init() 매서드를 호출하여 서블릿 로딩 과정을 거친다.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        // 응답을 전송하기 위해선 응답의 컨텐츠 타입을 지정해줘야한다.
        PrintWriter out = resp.getWriter();
        // 응답으로 문자열을 출력하기위해 PrintWriter객체를 resp로부터 얻어온다.
        out.println("<html>");
        out.println("<head><title>현재시간</title></head>");
        out.println("<body>");
        out.println("현재 시간은");
        out.println(new Date());
        out.println("입니다");
        out.println("</body></html>");
    }
}
