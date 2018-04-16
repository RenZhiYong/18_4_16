package com.bdqn.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断我应该调用哪个方法
        req.setCharacterEncoding("utf-8");
        System.out.println(this);
        //获取穿过来的方法名
        String methodName = req.getParameter("method");
        if (methodName == "" || methodName == null) {

        }
        //谁请求我就拿谁的字节码
        Class<? extends BaseServlet> clz = this.getClass();
        try {
            Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String url = (String) method.invoke(this, req, resp);
            req.getRequestDispatcher(url).forward(req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
