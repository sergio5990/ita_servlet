package by.itacademy.jd2.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@javax.servlet.annotation.WebListener
public class StartUpListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest servletRequest = (HttpServletRequest) event.getServletRequest();
        System.out.println("Request received"
                + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
                + servletRequest.getServletPath());
    }
}
