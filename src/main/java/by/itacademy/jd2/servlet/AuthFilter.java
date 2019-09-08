package by.itacademy.jd2.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest rq, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) rq).getCookies();
        Optional<Cookie> user = Arrays.stream(cookies)
                .filter(c -> c.getName().equals("user"))
                .findAny();

        if (user.isPresent()) {
            chain.doFilter(rq, response);
            response.getWriter().write("<h2>user  " + user.get().getValue() + "</h2>");

        } else {
            response.getWriter().write("<h2>Go to Login</h2>");
        }
    }

    @Override
    public void destroy() {

    }
}
