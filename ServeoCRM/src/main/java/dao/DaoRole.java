package dao;

import Models.Role;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoRole{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Role role = new Role();
    
    public Boolean createRole(Role role) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_ROLES VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+role.getName()+","+role.getDescription()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Role findRole(Role role) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

    
    public List<Role> lstRole() {
        List<Role> listRole = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                role = new Role();
                role.setIdRole(rs.getInt(""));
                role.setName(rs.getString(""));
                role.setDescription(rs.getString(""));
                role.setCreateDate(rs.getString(""));
                role.setModDate(rs.getString(""));
                listRole.add(role);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRole;
    }

    
    public Boolean updateRole(Role role) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_ROLES SET ROLE_NAME="+role.getName()+",ROLE_DESCRIPTION="+role.getDescription()+",CONVERT(DATE,GETDATE()) WHERE ROLE_ID="+role.getIdRole());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteRole(Role role) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_ROLES WHERE ROLE_ID="+role.getIdRole());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}