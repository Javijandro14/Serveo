package dao;

import Models.InventoryItem;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoInventoryItem{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    InventoryItem inventoryItem = new InventoryItem();
    
    public Boolean createInventoryItem(InventoryItem inventoryItem) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_INVENTORY_ITEMS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+inventoryItem.getName()+","+inventoryItem.getCategory()+","+inventoryItem.getUnit()+","+inventoryItem.getCurrentQuantity()+","+inventoryItem.getUnitCost()+","+inventoryItem.getParLevel()+","+inventoryItem.getStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public InventoryItem findInventoryItem(InventoryItem inventoryItem) {
        try {
            con.open();
            res = con.executeSql("");
            inventoryItem = new InventoryItem();
            inventoryItem.setIdInventory(rs.getInt(""));
            inventoryItem.setName(rs.getString(""));
            inventoryItem.setCategory(rs.getString(""));
            inventoryItem.setUnit(rs.getString(""));
            inventoryItem.setStatus(rs.getString(""));
            inventoryItem.setCreateDate(rs.getString(""));
            inventoryItem.setModDate(rs.getString(""));
            inventoryItem.setCurrentQuantity(rs.getDouble(""));
            inventoryItem.setUnitCost(rs.getDouble(""));
            inventoryItem.setParLevel(rs.getDouble(""));
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventoryItem;
    }

    
    public List<InventoryItem> lstInventoryItem() {
        List<InventoryItem> listInventoryItem = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                inventoryItem = new InventoryItem();
                inventoryItem.setIdInventory(rs.getInt(""));
                inventoryItem.setName(rs.getString(""));
                inventoryItem.setCategory(rs.getString(""));
                inventoryItem.setUnit(rs.getString(""));
                inventoryItem.setStatus(rs.getString(""));
                inventoryItem.setCreateDate(rs.getString(""));
                inventoryItem.setModDate(rs.getString(""));
                inventoryItem.setCurrentQuantity(rs.getDouble(""));
                inventoryItem.setUnitCost(rs.getDouble(""));
                inventoryItem.setParLevel(rs.getDouble(""));
                listInventoryItem.add(inventoryItem);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listInventoryItem;
    }

    
    public Boolean updateInventoryItem(InventoryItem inventoryItem) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_INVENTORY_ITEMS SET ITEM_NAME="+inventoryItem.getName()+",CATEGORY="+inventoryItem.getCategory()+",UNIT="+inventoryItem.getUnit()+",CURRENT_QUANTITY="+inventoryItem.getCurrentQuantity()+",UNIT_COST="+inventoryItem.getUnitCost()+",PAR_LEVEL="+inventoryItem.getParLevel()+",ISACTIVE="+inventoryItem.getStatus()+",MOD_DATE=CONVERT(DATE,GETDATE()) WHERE INVENTORY_ID="+inventoryItem.getIdInventory());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteInventoryItem(InventoryItem inventoryItem) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_INVENTORY_ITEMS WHERE INVENTORY_ID="+inventoryItem.getIdInventory());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoInventoryItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}