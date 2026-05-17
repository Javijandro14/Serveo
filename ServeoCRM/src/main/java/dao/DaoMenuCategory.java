package dao;

import Models.MenuCategory;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMenuCategory{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    MenuCategory menuCategory = new MenuCategory();

    
    public Boolean createMenuCategory(MenuCategory menuCategory) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_MENU_CATEGORIES VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+menuCategory.getName()+","+menuCategory.getDescription()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public MenuCategory findMenuCategory(MenuCategory menuCategory) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menuCategory;
    }

    
    public List<MenuCategory> lstMenuCategory() {
        List<MenuCategory> listMenuCategory = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                menuCategory = new MenuCategory();
                menuCategory.setIdCategory(rs.getInt(""));
                menuCategory.setName(rs.getString(""));
                menuCategory.setDescription(rs.getString(""));
                menuCategory.setCreateDate(rs.getString(""));
                menuCategory.setModDate(rs.getString(""));
                listMenuCategory.add(menuCategory);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMenuCategory;
    }

    
    public Boolean updateMenuCategory(MenuCategory menuCategory) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_MENU_CATEGORIES SET MENU_CATEGORY_NAME="+menuCategory.getName()+" ,MENU_CATEGORY_DESCRIPTION="+menuCategory.getDescription()+" , MOD_DATE=CONVERT(DATE,GETDATE()) WHERE CATEGORY_ID="+menuCategory.getIdCategory());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteMenuCategory(MenuCategory menuCategory) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_MENU_CATEGORIES WHERE CATEGORY_ID="+menuCategory.getIdCategory());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}