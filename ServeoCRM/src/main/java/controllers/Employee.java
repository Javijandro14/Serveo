/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import Models.User;
import dao.DaoCustomer;
import dao.DaoEmployee;
import dao.DaoIngredient;
import dao.DaoSupplier;
import dao.DaoSupplies;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Employee", urlPatterns = {"/Employee"})
public class Employee extends HttpServlet {

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
        String path = request.getParameter("path"), controller = "Login";
        //processRequest(request, response);
        DaoCustomer daoCustomer = new DaoCustomer();
        DaoEmployee daoEmployee = new DaoEmployee();
        DaoIngredient daoIngredient = new DaoIngredient();
        DaoSupplier daoSupplier = new DaoSupplier();
        DaoSupplies daoSupplies = new DaoSupplies();
        User user = new User();

        switch (item) {
            // CRUD for Customer
            case "customer" -> {
                if (action.equals("create")) {
                }
                if (action.equals("update")) {
                }
                if (action.equals("delete")) {
                }
                path = "Home/Employee/Customers.jsp";
                controller = "Employee";
                request.setAttribute("lstCustomer", daoCustomer.listCustomer());
            }
            
            // CRUD for Employee
            case "employee" -> {
                if (action.equals("create")) {
                }
                if (action.equals("update")) {
                }
                if (action.equals("delete")) {
                }
                path = "Home/Employee/Employees.jsp";
                controller = "Employee";
                request.setAttribute("lstEmployee", daoEmployee.listEmployee());
            }
            
            //CRUD for Ingredient
            case "ingredient" -> {
                if (action.equals("create")) {
                }
                if (action.equals("update")) {
                }
                if (action.equals("delete")) {
                }
                path = "Home/Employee/Ingredients.jsp";
                controller = "Employee";
                request.setAttribute("lstIngredient", daoIngredient.listIngredient());
            }

            //CRUD for Supplier
            case "supplier" -> {
                if (action.equals("create")) {
                }
                if (action.equals("update")) {
                }
                if (action.equals("delete")) {
                }
                path = "Home/Employee/Suppliers.jsp";
                controller = "Employee";
                request.setAttribute("lstSupplier", daoSupplier.listSupplier());
            }

            //CRUD for Supplies
            case "supplies" -> {
                if (action.equals("create")) {
                }
                if (action.equals("update")) {
                }
                if (action.equals("delete")) {
                }
                path = "Home/Employee/Supplies.jsp";
                controller = "Employee";
                request.setAttribute("lstSupplies", daoSupplies.listSupplies());
            }
            default ->
                path = "Home/Employee/EmployeeHome.jsp";
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
