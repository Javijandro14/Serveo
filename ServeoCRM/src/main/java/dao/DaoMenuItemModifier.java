package dao;

import Models.MenuItemModifier;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMenuItemModifier {
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    MenuItemModifier menuItemModifier = new MenuItemModifier();

    
    public Boolean createMenuItemModifier(MenuItemModifier menuItemModifier) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_MENU_ITEMS_MODIFIERS VALUES("+menuItemModifier.getIdMenuItem()+","+menuItemModifier.getIdModifier()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public MenuItemModifier findMenuItemModifier(MenuItemModifier menuItemModifier) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menuItemModifier;
    }

    public List<MenuItemModifier> lstMenuItemModifier() {
        List<MenuItemModifier> listMenuItemModifier = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                menuItemModifier = new MenuItemModifier();
                menuItemModifier.setIdMenuItem(rs.getInt(""));
                menuItemModifier.setIdModifier(rs.getInt(""));
                menuItemModifier.setMenuItem(rs.getString(""));
                menuItemModifier.setModifier(rs.getString(""));
                menuItemModifier.setModDate(rs.getString(""));
                menuItemModifier.setCreateDate(rs.getString(""));
                listMenuItemModifier.add(menuItemModifier);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMenuItemModifier;
    }
    
    public Boolean deleteMenuItemModifier(MenuItemModifier menuItemModifier) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_MENU_ITEMS_MODIFIERS WHERE MENU_ITEM_ID="+menuItemModifier.getIdMenuItem()+" AND MODIFIER_ID="+menuItemModifier.getIdModifier());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}