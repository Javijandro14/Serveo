package dao;

import Models.Permission;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPermission {
    
Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Permission permission = new Permission();

    public Boolean createPermission(Permission permission) {
        try {
            con.open();
            //res = con.executeSql("INSERT INTO TBL_EMPLOYEES VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+permission.getIdUser()+","+permission.getFirstName()+","+permission.getLastName()+","+permission.getPosition()+","+permission.getHourRate()+","+permission.getHireDate()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Permission findPermission(Permission permission) {
        
        try {
            con.open();
            res = con.executeSql("");
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        }
        return permission;
    }

    public List<Permission> lstPermission() {
        List<Permission> listPermission = new ArrayList<>();
        try {
            con.open(); 
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                permission = new Permission();
                
                listPermission.add(permission);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPermission;
    }

    public Boolean updatePermission(Permission permission) {
        try {
            con.open();
            //res = con.executeSql("UPDATE TBL_EMPLOYEES SET FIRST_NAME="+permission.getFirstName()+",LAST_NAME="+permission.getLastName()+",POSITION="+permission.getPosition()+",HOURLY_RATE="+permission.getHourRate()+",HIRE_DATE="+permission.getHourRate()+",MOD_DATE=CONVERT(DATE,GETDATE()) WHERE EMPLOYEE_ID="+permission.getIdPermission()+" AND USER_ID="+permission.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Boolean deletePermission(Permission permission) {
        try {
            con.open();
            //res = con.executeSql("DELETE FROM TBL_EMPLOYEES WHERE EMPLOYEE_ID="+permission.getIdPermission()+",USER_ID="+permission.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}

