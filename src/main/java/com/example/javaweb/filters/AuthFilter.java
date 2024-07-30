package com.example.javaweb.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/hello"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse res= (HttpServletResponse) response;
        HttpSession session=req.getSession(false);
        if(session==null){
            res.sendRedirect("/javaweb");
        }else{
            if(session.getAttribute("user")==null){
                res.sendRedirect("/javaweb");
            }else{
                chain.doFilter(request,response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
