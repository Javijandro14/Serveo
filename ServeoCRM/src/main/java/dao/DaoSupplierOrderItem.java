package dao;

import Models.SupplierOrderItem;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSupplierOrderItem{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    SupplierOrderItem supplierOrderItem = new SupplierOrderItem();
    
    public Boolean createSupplierOrderItem(SupplierOrderItem supplierOrderItem) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_SUPPLIER_ORDER_ITEMS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+supplierOrderItem.getIdSupplierOrder()+","+supplierOrderItem.getIdInventory()+","+supplierOrderItem.getQuantity()+","+supplierOrderItem.getUnitCost()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public SupplierOrderItem findSupplierOrderItem(SupplierOrderItem supplierOrderItem) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplierOrderItem;
    }

    
    public List<SupplierOrderItem> lstSupplierOrderItem() {
        List<SupplierOrderItem> listSupplierOrderItem = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                supplierOrderItem = new SupplierOrderItem();
                supplierOrderItem.setIdSupplierOrderItem(rs.getInt(""));
                supplierOrderItem.setIdSupplierOrder(rs.getInt(""));
                supplierOrderItem.setIdInventory(rs.getInt(""));
                supplierOrderItem.setQuantity(rs.getDouble(""));
                supplierOrderItem.setUnitCost(rs.getDouble(""));
                supplierOrderItem.setCreateDate(rs.getString(""));
                supplierOrderItem.setModDate(rs.getString(""));
                listSupplierOrderItem.add(supplierOrderItem);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSupplierOrderItem;
    }

    
    public Boolean updateSupplierOrderItem(SupplierOrderItem supplierOrderItem) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_SUPPLIER_ORDER_ITEMS SET QUANTITY="+supplierOrderItem.getQuantity()+",UNIT_COST="+supplierOrderItem.getUnitCost()+",MOD_DATE=CONVERT(DATE,GETDATE()) WHERE SUPPLIER_ORDERITEM_ID="+supplierOrderItem.getIdSupplierOrderItem()+" AND SUPPLIER_ORDER_ID="+supplierOrderItem.getIdSupplierOrder()+" AND INVENTORY_ID="+supplierOrderItem.getIdInventory());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteSupplierOrderItem(SupplierOrderItem supplierOrderItem) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_SUPPLIER_ORDER_ITEMS WHERE SUPPLIER_ORDERITEM_ID=0,SUPPLIER_ORDER_ID="+supplierOrderItem.getIdSupplierOrder()+" AND INVENTORY_ID="+ supplierOrderItem.getIdInventory());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}