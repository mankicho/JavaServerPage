package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

    public class NullParameterRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> parameterMap = null;

    public NullParameterRequestWrapper(HttpServletRequest request) {
        super(request);
        parameterMap = new HashMap<>(request.getParameterMap());
    }

    // request가 오면 parameter가 존재하지않으면 공백 문자열로 제공한 후 wrapper 클래스를 다음 필터에 넘김.
    public void checkNull(String[] parameterNames) {
        for (int i = 0; i < parameterNames.length; i++) {
            if (!parameterMap.containsKey(parameterNames[i])) {
                String[] strs = new String[]{""};
                parameterMap.put(parameterNames[i], strs);
                // 파라미터가 존재하지않으면 파라미터 값을 공백 문자열로 제공하는 필터기능
            }
        }
    }

    @Override
    public String getParameter(String name) {
        String[] values = getParameterValues(name);
        if (values != null && values.length > 0) {
            return values[0];
        }
        return null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(parameterMap.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return (String[]) parameterMap.get(name);
    }
}
