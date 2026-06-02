package dao;

import Models.User;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    User user = new User();
    
    public Boolean createUser(User user) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_USERS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+user.getIdRole()+","+user.getName()+","+user.getEmail()+","+user.getPhone()+","+user.getPassword()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public User findUser(User user) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    
    public List<User> lstUser() {
        List<User> listUser = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt(""));
                user.setIdRole(rs.getInt(""));
                user.setName(rs.getString(""));
                user.setRole(rs.getString(""));
                user.setEmail(rs.getString(""));
                user.setPhone(rs.getString(""));
                user.setPassword(rs.getString(""));
                user.setCreateDate(rs.getString(""));
                user.setModDate(rs.getString(""));
                listUser.add(user);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;
    }

    
    public Boolean updateUser(User user) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_USERS SET USERNAME="+user.getName()+",EMAIL="+user.getEmail()+",PHONE="+user.getPhone()+",PASSWORD_HASH="+user.getPassword()+", MOD_DATE=CONVERT(DATE,GETDATE()) WHERE USER_ID="+user.getIdUser()+" AND ROLE_ID="+user.getIdRole());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteUser(User user) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_USERS WHERE USER_ID="+user.getIdUser()+",ROLE_ID="+user.getIdRole());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public Boolean login(User user){
        res = false;
        if("123".equals(user.getName()) && "123".equals(user.getPassword())) res = true;
        return res;
    }
}