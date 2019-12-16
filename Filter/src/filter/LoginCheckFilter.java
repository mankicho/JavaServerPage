package filter;

import org.apache.commons.logging.Log;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 요청에서 세션을 얻어온다.
        HttpSession session = httpServletRequest.getSession();
        boolean login = false;

        if (session != null) {
            if (session.getAttribute("MEMBER") != null) {
                // session에 MEMBER라는 속성이 있으면? login 된 상태이다.
                login = true;
            }
        }

        if (login) {
            // 로그인 했으면 정상처리하고
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            // 로그인 안 되있으면 loginForm.jsp로 페이지를 넘긴다.
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/loginForm.jsp");
            dispatcher.forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
