package controllers;

import Models.User;
import dao.DaoUser;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //RequestDispatcher vista = request.getRequestDispatcher("../ServeoCRM");
        //vista.forward(request, response);        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //We Could put conditions if the user had already logged in parameter
        RequestDispatcher vista = request.getRequestDispatcher("/");
        vista.forward(request, response);
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action"), item = request.getParameter("item");
        String path = "/", controller = "Login";
        //processRequest(request, response);
        DaoUser daoUser = new DaoUser();
        User user = new User();

        switch (item) {
            case "customer" -> {
                if (action.equals("login")) {
                    user.setName(request.getParameter("username"));
                    user.setPassword(request.getParameter("password"));
                    if (daoUser.login(user)) {
                        path = "Home/CustomerHome.jsp";
                        controller = "Customer";
                    } else {
                        path = "Home/Login.jsp";
                    }
                }
                if (action.equals("reset")) {
                }

            }
            // Employee Login Code

            case "employee" -> {
                if (action.equals("login")) {
                    user.setName(request.getParameter("username"));
                    user.setPassword(request.getParameter("password"));
                    if (daoUser.login(user)) {
                        path = "Home/EmployeeHome.jsp";
                        // We can add something to change Controller
                        controller = "Employee";
                    } else {
                        path = "Home/Login.jsp";
                    }
                }
                if (action.equals("reset")) {

                }
            }
        }
        request.setAttribute("path", path);
        request.setAttribute("item", item);
        request.setAttribute("controller", controller);
        //Get the RBAC in the controller
        request.setAttribute("user", user);
        //request.setAttribute("role", path);
        RequestDispatcher vista = request.getRequestDispatcher(path);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
