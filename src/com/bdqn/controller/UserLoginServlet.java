package com.bdqn.controller;

import com.bdqn.dao.NewsUserDao;
import com.bdqn.dao.impl.NewsUserDaoImpl;
import com.bdqn.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
           /* //处理编码
            request.setCharacterEncoding("utf-8");
            //获取参数
            String name = request.getParameter("uname");
            String pwd = request.getParameter("upwd");
            //访问业务层
            UserService userService = new UserServiceImpl();
            User user=userService.getUser(name,pwd);
            if (user == null) {//登录不成功
                request.getSession().setAttribute("info", "用户名或者密码错误!");
                response.sendRedirect("/index.jsp");
            } else {//登录成功
                request.getSession().setAttribute("userss", user);
                request.getRequestDispatcher("/newspages/admin.jsp").forward(request, response);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/index.jsp");
    }
}
