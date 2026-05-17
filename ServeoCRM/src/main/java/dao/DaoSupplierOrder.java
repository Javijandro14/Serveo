package dao;

import Models.SupplierOrder;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSupplierOrder{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    SupplierOrder supplierOrder = new SupplierOrder();
    
    public Boolean createSupplierOrder(SupplierOrder supplierOrder) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_SUPPLIER_ORDER_ITEMS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+supplierOrder.getIdSupplierOrder()+","+supplierOrder.getIdSupplier()+","+supplierOrder.getOrderDate()+","+supplierOrder.getStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public SupplierOrder findSupplierOrder(SupplierOrder supplierOrder) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplierOrder;
    }

    
    public List<SupplierOrder> lstSupplierOrder() {
        List<SupplierOrder> listSupplierOrder = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                supplierOrder = new SupplierOrder();
                supplierOrder.setIdSupplierOrder(rs.getInt(""));
                supplierOrder.setIdSupplier(rs.getInt(""));
                supplierOrder.setSupplier(rs.getString(""));
                supplierOrder.setOrderDate(rs.getString(""));
                supplierOrder.setStatus(rs.getString(""));
                supplierOrder.setCreateDate(rs.getString(""));
                supplierOrder.setModDate(rs.getString(""));
                listSupplierOrder.add(supplierOrder);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSupplierOrder;
    }

    
    public Boolean updateSupplierOrder(SupplierOrder supplierOrder) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_SUPPLIER_ORDERS SET ORDER_DATE="+supplierOrder.getOrderDate()+",ORDER_STATUS="+supplierOrder.getStatus()+",CONVERT(DATE,GETDATE()) WHERE SUPPLIER_ORDER_ID="+supplierOrder.getIdSupplierOrder()+" AND SUPPLIER_ID="+supplierOrder.getIdSupplier());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteSupplierOrder(SupplierOrder supplierOrder) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_SUPPLIER_ORDERS WHERE SUPPLIER_ORDER_ID="+supplierOrder.getIdSupplierOrder()+" AND SUPPLIER_ID="+supplierOrder.getIdSupplier());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}