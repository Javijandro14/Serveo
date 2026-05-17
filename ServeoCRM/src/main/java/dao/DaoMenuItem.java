package dao;

import Models.MenuItem;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMenuItem{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    MenuItem menuItem = new MenuItem();
    
    public Boolean createMenuItem(MenuItem menuItem) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_MENU_ITEMS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+menuItem.getIdCategory()+","+menuItem.getName()+","+menuItem.getDescription()+","+menuItem.getPrice()+","+menuItem.getStatus()+",CONVERT(DATE,GETDATE()), CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public MenuItem findMenuItem(MenuItem menuItem) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menuItem;
    }

    
    public List<MenuItem> lstMenuItem() {
        List<MenuItem> listMenuItem = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                menuItem = new MenuItem();
                menuItem.setIdMenuItem(rs.getInt(""));
                menuItem.setIdCategory(rs.getInt(""));
                menuItem.setPrice(rs.getDouble(""));
                menuItem.setName(rs.getString(""));
                menuItem.setDescription(rs.getString(""));
                menuItem.setCategory(rs.getString(""));
                menuItem.setStatus(rs.getString(""));
                menuItem.setModDate(rs.getString(""));
                menuItem.setCreateDate(rs.getString(""));
                listMenuItem.add(menuItem);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMenuItem;
    }

    
    public Boolean updateMenuItem(MenuItem menuItem) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_MENU_ITEMS SET ITEM_NAME="+menuItem.getName()+",ITEM_DESCRIPTION="+menuItem.getDescription()+",PRICE="+menuItem.getPrice()+", ISACTIVE="+menuItem.getStatus()+", MOD_DATE=CONVERT(DATE,GETDATE()) WHERE  MENU_ITEM_ID="+menuItem.getIdMenuItem()+" AND CATEGORY_ID="+ menuItem.getIdCategory());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteMenuItem(MenuItem menuItem) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_MENU_ITEMS WHERE MENU_ITEM_ID="+menuItem.getIdMenuItem()+" AND CATEGORY_ID="+menuItem.getIdCategory());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}