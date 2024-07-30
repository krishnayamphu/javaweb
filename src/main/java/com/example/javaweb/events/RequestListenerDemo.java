package com.example.javaweb.events;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListenerDemo implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request end");;
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request start");
    }
}
