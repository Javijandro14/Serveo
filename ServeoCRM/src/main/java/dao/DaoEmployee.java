package dao;

import Models.Employee;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEmployee{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Employee employee = new Employee();

    public Boolean createEmployee(Employee employee) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_EMPLOYEES VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+employee.getIdUser()+","+employee.getFirstName()+","+employee.getLastName()+","+employee.getPosition()+","+employee.getHourRate()+","+employee.getHireDate()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Employee findEmployee(Employee employee) {
        
        try {
            con.open();
            res = con.executeSql("");
            employee.setIdUser(rs.getInt(""));
            employee.setHourRate(rs.getDouble(""));
            employee.setFirstName(rs.getString(""));
            employee.setLastName(rs.getString(""));
            employee.setUser(rs.getString(""));
            employee.setPosition(rs.getString(""));
            employee.setHireDate(rs.getString(""));
            employee.setCreateDate(rs.getString(""));
            employee.setModDate(rs.getString(""));
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    public List<Employee> lstEmployee() {
        List<Employee> listEmployee = new ArrayList<>();
        try {
            con.open(); 
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                employee = new Employee();
                employee.setIdEmployee(rs.getInt(""));
                employee.setIdUser(rs.getInt(""));
                employee.setHourRate(rs.getDouble(""));
                employee.setFirstName(rs.getString(""));
                employee.setLastName(rs.getString(""));
                employee.setUser(rs.getString(""));
                employee.setPosition(rs.getString(""));
                employee.setHireDate(rs.getString(""));
                employee.setCreateDate(rs.getString(""));
                employee.setModDate(rs.getString(""));
                listEmployee.add(employee);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEmployee;
    }

    public Boolean updateEmployee(Employee employee) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_EMPLOYEES SET FIRST_NAME="+employee.getFirstName()+",LAST_NAME="+employee.getLastName()+",POSITION="+employee.getPosition()+",HOURLY_RATE="+employee.getHourRate()+",HIRE_DATE="+employee.getHourRate()+",MOD_DATE=CONVERT(DATE,GETDATE()) WHERE EMPLOYEE_ID="+employee.getIdEmployee()+" AND USER_ID="+employee.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Boolean deleteEmployee(Employee employee) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_EMPLOYEES WHERE EMPLOYEE_ID="+employee.getIdEmployee()+",USER_ID="+employee.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
