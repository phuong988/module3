package com.example.quan_ly_user.controller;

import com.example.quan_ly_user.model.User;
import com.example.quan_ly_user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                showUpdateUser(req, resp);
                break;
            case "sort":
                sortUsers(req, resp);
                break;
            case "delete":
                deleteUser(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void showUpdateUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.selectUser(id);
        req.setAttribute("user", user);
        try {
            req.getRequestDispatcher("/view/user/update.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = userService.selectAllUsers();
        req.setAttribute("users", users);
        try {
            req.getRequestDispatcher("/view/user/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private void sortUsers(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = userService.softByUserName();
        req.setAttribute("users", users);
        try {
            req.getRequestDispatcher("/view/user/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUser(id);
        resp.sendRedirect("/user");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                insertUser(req, resp);
                break;
            case "delete":
                deleteUser(req, resp);
                break;
            case "search":
                searchUser(req, resp);
                break;
            case "update":
                updateUser(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }

    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(name, email, country);
        userService.insertUser(user);
        req.getSession().setAttribute("successMessage", "User added successfully!");
        resp.sendRedirect("/user");
    }


    private void searchUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.selectUser(id);
        req.setAttribute("user", user);
        try {
            req.getRequestDispatcher("/view/user/search.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id, name, email, country);
        userService.updateUser(user);
        resp.sendRedirect("/user");
    }
}