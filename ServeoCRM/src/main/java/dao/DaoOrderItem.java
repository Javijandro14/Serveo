package dao;

import Models.OrderItem;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoOrderItem{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    OrderItem orderItem = new OrderItem();

    
    public Boolean createOrderItem(OrderItem orderItem) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_ORDER_ITEMS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+orderItem.getIdOrder()+","+orderItem.getIdMenuItem()+","+orderItem.getQuantity()+","+orderItem.getUnitPrice()+","+orderItem.getNotes()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public OrderItem findOrderItem(OrderItem orderItem) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderItem;
    }

    
    public List<OrderItem> lstOrderItem() {
        List<OrderItem> listOrderItem = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                orderItem = new OrderItem();
                orderItem.setIdOrderItem(rs.getInt(""));
                orderItem.setIdOrder(rs.getInt(""));
                orderItem.setIdMenuItem(rs.getInt(""));
                orderItem.setQuantity(rs.getInt(""));
                orderItem.setUnitPrice(rs.getDouble(""));
                orderItem.setMenuItem(rs.getString(""));
                orderItem.setNotes(rs.getString(""));
                orderItem.setModDate(rs.getString(""));
                orderItem.setCreateDate(rs.getString(""));
                listOrderItem.add(orderItem);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrderItem;
    }

    
    public Boolean updateOrderItem(OrderItem orderItem) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_ORDER_ITEMS SET QUANTITY="+orderItem.getQuantity()+",UNIT_PRICE="+orderItem.getUnitPrice()+",NOTES="+orderItem.getNotes()+",MOD_DATE=CONVERT(DATE,GETDATE()) WHERE ORDER_ITEM_ID="+orderItem.getIdOrderItem()+" AND ORDER_ID="+orderItem.getIdOrder()+" AND MENU_ITEM_ID="+orderItem.getIdMenuItem());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteOrderItem(OrderItem orderItem) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_ORDER_ITEMS WHERE ORDER_ITEM_ID="+orderItem.getIdOrderItem()+" AND ORDER_ID="+orderItem.getIdOrder()+" AND MENU_ITEM_ID="+orderItem.getIdMenuItem());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}