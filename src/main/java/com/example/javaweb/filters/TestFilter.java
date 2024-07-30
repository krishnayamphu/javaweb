package com.example.javaweb.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "TestFilter", urlPatterns = {"/test","/demo"})
public class TestFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("test filter invoked");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("test filter");
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
