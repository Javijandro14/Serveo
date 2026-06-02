

package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Maintenance", urlPatterns = { "/Maintenance" })
public class Maintenance extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Maintenance</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Maintenance at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher vista = request.getRequestDispatcher("/Serveo/web/app/home.jsp");
        //vista.forward(request, response);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println(this.getServletInfo());
        // DaoMaintenance dm = new DaoMaintenance();
        // DaoProcess dp = new DaoProcess();
        // String function = request.getParameter("action"), item = request.getParameter("item"),path = request.getParameter("path");
        // switch (item) {
        //     case "Area":
        //         Area area = new Area();
        //         if (function.equals("create")) {
        //             area.setDescription(request.getParameter("Description"));
        //             area.setIdBranch(Integer.parseInt(request.getParameter("Branch")));
        //             area.setIdStatus(Integer.parseInt(request.getParameter("Status")));
        //             dm.createArea(area);
        //         }
        //         if (function.equals("update")) {
        //             area.setIdArea(Integer.parseInt(request.getParameter("IdArea")));
        //             area.setDescription(request.getParameter("Description"));
        //             area.setIdBranch(Integer.parseInt(request.getParameter("Branch")));
        //             area.setIdStatus(Integer.parseInt(request.getParameter("Status")));
        //             dm.updateArea(area);
        //         }
        //         if (function.equals("delete")) {
        //             area.setIdArea(Integer.parseInt(request.getParameter("IdArea")));
        //             dm.deleteArea(area);
        //         }
        //         request.setAttribute("listArea", dm.listAreas());
        //         request.setAttribute("listBranch", dm.listBranches());
        //         request.setAttribute("listStatus", dm.listStatus());
        //         break;
        //     case "Branch":
        //         Branch branch = new Branch();
        //         if (function.equals("create")) {
        //             branch.setName(request.getParameter("Name"));
        //             branch.setAddress(request.getParameter("Address"));
        //             branch.setTel(request.getParameter("Tel"));
        //             branch.setBusinessHour(request.getParameter("BusinessHour"));
        //             dm.createBranch(branch);
        //         }
        //         if (function.equals("update")) {
        //             branch.setIdBranch(Integer.parseInt(request.getParameter("IdBranch")));
        //             branch.setName(request.getParameter("Name"));
        //             branch.setAddress(request.getParameter("Address"));
        //             branch.setTel(request.getParameter("Tel"));
        //             branch.setBusinessHour(request.getParameter("BusinessHour"));
        //             dm.updateBranch(branch);
        //         }
        //         if (function.equals("delete")) {
        //             branch.setIdBranch(Integer.parseInt(request.getParameter("IdBranch")));
        //             dm.deleteBranch(branch);
        //         }
        //         request.setAttribute("listBranch", dm.listBranches());
        //         break;
        //     case "Menu":
        //         Menu menu = new Menu();
        //         if (function.equals("create")) {
        //             menu.setName(request.getParameter("Name"));
        //             menu.setDescription(request.getParameter("Description"));
        //             menu.setPrice(Double.parseDouble(request.getParameter("Price")));
        //             menu.setIdCategory(Integer.parseInt(request.getParameter("Category")));
        //             menu.setIdStatus(Integer.parseInt(request.getParameter("Status")));
        //             dm.createMenu(menu);
        //         }
        //         if (function.equals("update")) {
        //             menu.setIdMenu(Integer.parseInt(request.getParameter("IdMenu")));
        //             menu.setName(request.getParameter("Name"));
        //             menu.setDescription(request.getParameter("Description"));
        //             menu.setPrice(Double.parseDouble(request.getParameter("Price")));
        //             menu.setIdCategory(Integer.parseInt(request.getParameter("Category")));
        //             menu.setIdStatus(Integer.parseInt(request.getParameter("Status")));
        //             dm.updateMenu(menu);
        //         }
        //         if (function.equals("delete")) {
        //             menu.setIdMenu(Integer.parseInt(request.getParameter("IdMenu")));
        //             dm.deleteMenu(menu);
        //         }
        //         request.setAttribute("listMenu", dm.listMenus());
        //         request.setAttribute("listCategory", dm.listCategories());
        //         request.setAttribute("listStatus", dm.listStatus());
        //         break;
        //     case "Category":
        //         Category category = new Category();
        //         if (function.equals("create")) {
        //             category.setName(request.getParameter("Name"));
        //             category.setType(request.getParameter("Type"));
        //             dm.createCategory(category);
        //         }
        //         if (function.equals("update")) {
        //             category.setIdCategory(Integer.parseInt(request.getParameter("IdCategory")));
        //             category.setName(request.getParameter("Name"));
        //             category.setType(request.getParameter("Type"));
        //             dm.updateCategory(category);
        //         }
        //         if (function.equals("delete")) {
        //             category.setIdCategory(Integer.parseInt(request.getParameter("IdCategory")));
        //             dm.deleteCategory(category);
        //         }
        //         request.setAttribute("listCategory", dm.listCategories());
        //         break;
        //     case "Product":
        //         Product product = new Product();
        //         if (function.equals("create")) {
        //             product.setName(request.getParameter("Name"));
        //             product.setDescription(request.getParameter("Description"));
        //             product.setMeasure(request.getParameter("Measure"));
        //             product.setIdCategory(Integer.parseInt(request.getParameter("Category")));
        //             product.setIdVendor(Integer.parseInt(request.getParameter("Vendor")));
        //             product.setStock(Integer.parseInt(request.getParameter("Stock")));
        //             dm.createProduct(product);
        //         }
        //         if (function.equals("update")) {
        //             product.setIdProduct(Integer.parseInt(request.getParameter("IdProduct")));
        //             product.setName(request.getParameter("Name"));
        //             product.setDescription(request.getParameter("Description"));
        //             product.setMeasure(request.getParameter("Measure"));
        //             product.setIdCategory(Integer.parseInt(request.getParameter("Category")));
        //             product.setIdVendor(Integer.parseInt(request.getParameter("Vendor")));
        //             product.setStock(Integer.parseInt(request.getParameter("Stock")));
        //             dm.updateProduct(product);
        //         }
        //         if (function.equals("delete")) {
        //             product.setIdProduct(Integer.parseInt(request.getParameter("IdProduct")));
        //             dm.deleteProduct(product);
        //         }
        //         request.setAttribute("listProduct", dm.listProducts());
        //         request.setAttribute("listCategory", dm.listCategories());
        //         request.setAttribute("listVendor", dp.listVendors());
        //         break;
            /*
             * case "Shift":
             * Shift shift = new Shift();
             * if (function.equals("create")){
             * 
             * }
             * if (function.equals("update")){
             * shift.setIdShift(Integer.parseInt(request.getParameter("Shift")));
             * 
             * }
             * if (function.equals("delete")){
             * shift.setIdShift(Integer.parseInt(request.getParameter("Shift")));
             * }
             * request.setAttribute("listShift",dm.listShifts());
             * break;
             */
        //     case "Table":
        //         Table table = new Table();
        //         if (function.equals("create")) {
        //             table.setIdArea(Integer.parseInt(request.getParameter("Area")));
        //             table.setCapacity(Integer.parseInt(request.getParameter("Capacity")));
        //             table.setDescription(request.getParameter("Description"));
        //             table.setIdStatus(Integer.parseInt(request.getParameter("Status")));
        //             dm.createTable(table);
        //         }
        //         if (function.equals("update")) {
        //             table.setIdTable(Integer.parseInt(request.getParameter("IdTable")));
        //             table.setIdArea(Integer.parseInt(request.getParameter("Area")));
        //             table.setCapacity(Integer.parseInt(request.getParameter("Capacity")));
        //             table.setDescription(request.getParameter("Description"));
        //             table.setIdStatus(Integer.parseInt(request.getParameter("Status")));
        //             dm.updateTable(table);
        //         }
        //         if (function.equals("delete")) {
        //             table.setIdTable(Integer.parseInt(request.getParameter("IdTable")));
        //             dm.deleteTable(table);
        //         }
        //         request.setAttribute("listTable", dm.listTables());
        //         request.setAttribute("listArea", dm.listAreas());
        //         request.setAttribute("listStatus", dm.listStatus());
        //         break;
        //     case "Status":
        //         Status status = new Status();
        //         if (function.equals("create")) {
        //             status.setName(request.getParameter("Name"));
        //             status.setType(request.getParameter("Type"));
        //             dm.createStatus(status);
        //         }
        //         if (function.equals("update")) {
        //             status.setIdStatus(Integer.parseInt(request.getParameter("IdStatus")));
        //             status.setName(request.getParameter("Name"));
        //             status.setType(request.getParameter("Type"));
        //             dm.updateStatus(status);
        //         }
        //         if (function.equals("delete")) {
        //             status.setIdStatus(Integer.parseInt(request.getParameter("IdStatus")));
        //             dm.deleteStatus(status);
        //         }
        //         request.setAttribute("listStatus", dm.listStatus());
        //         break;
        // }
        // request.setAttribute("path", path);
        // request.setAttribute("item", item);
        // request.setAttribute("controller", "Maintenance");
        // RequestDispatcher vista = request.getRequestDispatcher(path);
        // vista.forward(request, response);
        processRequest(request, response);
    }
}
