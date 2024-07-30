package com.example.javaweb.events;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class ContextListenerDemo implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("app started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("app is going to stop");

    }
}
