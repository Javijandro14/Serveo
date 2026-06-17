package dao;

import Models.Employee;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEmployee {

    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Employee employee = new Employee();

    public Boolean createEmployee(Employee employee) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO public.\"TBL_EMPLOYEES\" VALUES (SELECT MAX(\"EMPLOYEE_ID\")+1 FROM public.\"TBL_EMPLOYEES\", "+employee.getIdUser()+", '"+employee.getFirstName()+"', '"+employee.getLastName()+"', '"+employee.getPosition()+"', "+employee.getHourRate()+", '"+employee.getStatus()+"', '"+employee.getHireDate()+"', CURRENT_DATE, CURRENT_DATE)");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Employee findEmployee(Employee employee) {

        try {
            con.open();
            res = con.executeSql("");
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    public List<Employee> listEmployee() {
        List<Employee> lstEmployee = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT E.\"EMPLOYEE_ID\", U.\"USER_ID\", U.\"USERNAME\", E.\"FIRST_NAME\", E.\"LAST_NAME\", E.\"POSITION\", E.\"HOURLY_RATE\", E.\"STATUS\", E.\"HIRE_DATE\", E.\"CREATE_DATE\", E.\"MOD_DATE\" FROM public.\"TBL_EMPLOYEES\" AS E, public.\"TBL_USERS\" AS U");
            while (rs.next()) {
                employee = new Employee();
                employee.setIdEmployee(rs.getInt("CUSTOMER_ID"));
                employee.setIdUser(rs.getInt("USER_ID"));
                employee.setUser(rs.getString("USERNAME"));
                employee.setFirstName(rs.getString("FIRST_NAME"));
                employee.setLastName(rs.getString("LAST_NAME"));
                employee.setCreateDate(rs.getString("CREATE_DATE"));
                employee.setModDate(rs.getString("MOD_DATE"));
                lstEmployee.add(employee);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return lstEmployee;
    }

    public Boolean updateEmployee(Employee employee) {
        try {
            con.open();
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Boolean deleteEmployee(Employee employee) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_EMPLOYEES WHERE EMPLOYEE_ID=" + employee.getIdEmployee() + ",USER_ID=" + employee.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
