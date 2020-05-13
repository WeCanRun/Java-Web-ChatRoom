package com.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import com.vo.User;

/**
 * 监听ServletContext对象创建和销毁
 */
public class MyServletContextListener implements ServletContextListener {
    // ServletContext对象创建 下面这个方法就会执行
    // ServletContextEvent事件对象. 监听器对象---》ServletContext对象.(事件源)
    public void contextInitialized(ServletContextEvent sce) {
        Map<User, HttpSession> userMap = new HashMap<User, HttpSession>();
        sce.getServletContext().setAttribute("userMap", userMap);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }


}
