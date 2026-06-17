package dao;

import Models.Customer;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCustomer {

    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Customer customer = new Customer();

    public Boolean createCustomer(Customer customer) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO public.\"TBL_CUSTOMERS\" VALUES ((SELECT MAX(\"CUSTOMER_ID\")+1 FROM public.\"TBL_CUSTOMERS\"), "+customer.getIdUser()+", '"+customer.getFirstName()+"', '"+customer.getLastName()+"', CURRENT_DATE, CURRENT_DATE);");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Customer findCustomer(Customer customer) {

        try {
            con.open();
            res = con.executeSql("");
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public List<Customer> listCustomer() {
        List<Customer> lstCustomer = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT C.\"CUSTOMER_ID\", U.\"USER_ID\", U.\"USERNAME\", C.\"FIRST_NAME\", C.\"LAST_NAME\", C.\"CREATE_DATE\", C.\"MOD_DATE\" FROM public.\"TBL_CUSTOMERS\" AS C, public.\"TBL_USERS\" AS U");
            while (rs.next()) {
                customer = new Customer();
                customer.setIdCustomer(rs.getInt("CUSTOMER_ID"));
                customer.setIdUser(rs.getInt("USER_ID"));
                customer.setUsername(rs.getString("USERNAME"));
                customer.setFirstName(rs.getString("FIRST_NAME"));
                customer.setLastName(rs.getString("LAST_NAME"));
                customer.setCreateDate(rs.getString("CREATE_DATE"));
                customer.setModDate(rs.getString("MOD_DATE"));
                lstCustomer.add(customer);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return lstCustomer;
    }

    public Boolean updateCustomer(Customer customer) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_EMPLOYEES WHERE EMPLOYEE_ID=" + customer.getIdCustomer() + ",USER_ID=" + customer.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Boolean deleteCustomer(Customer customer) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_EMPLOYEES WHERE EMPLOYEE_ID=" + customer.getIdCustomer() + ",USER_ID=" + customer.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
