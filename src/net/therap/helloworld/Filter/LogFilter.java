package net.therap.helloworld.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 1/7/13
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public  class LogFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if(session.getAttribute("username")==null){
            response.sendRedirect("login");
            return;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
