package dao;

import Models.Order;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoOrder{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Order order = new Order();

    
    public Boolean createOrder(Order order) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_ORDERS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+order.getIdUser()+","+order.getIdTable()+","+order.getIdReservation()+","+order.getSubtotal()+","+order.getTax()+","+order.getTotal()+","+order.getOrderType()+","+order.getStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Order findOrder(Order order) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    
    public List<Order> lstOrder() {
        List<Order> listOrder = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                order = new Order();
                order.setIdOrder(rs.getInt(""));
                order.setIdUser(rs.getInt(""));
                order.setIdTable(rs.getInt(""));
                order.setIdReservation(rs.getInt(""));
                order.setSubtotal(rs.getDouble(""));
                order.setTax(rs.getDouble(""));
                order.setTotal(rs.getDouble(""));
                order.setOrderType(rs.getString(""));
                order.setStatus(rs.getString(""));
                order.setUser(rs.getString(""));
                order.setTable(rs.getString(""));
                order.setReservation(rs.getString(""));
                order.setCreateDate(rs.getString(""));
                order.setModDate(rs.getString(""));
                listOrder.add(order);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrder;
    }

    
    public Boolean updateOrder(Order order) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_ORDERS SET SUBTOTAL="+order.getSubtotal()+",TAX="+order.getTax()+",TOTAL="+order.getTotal()+",ORDER_TYPE="+order.getOrderType()+",ORDER_STATUS="+order.getStatus()+", MOD_DATE=CONVERT(DATE,GETDATE()) WHERE  ORDER_ID="+order.getIdOrder()+" AND USER_ID="+order.getIdUser()+" AND TABLE_ID="+order.getIdTable()+" AND RESERVATION_ID="+ order.getIdReservation());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteOrder(Order order) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_ORDERS WHERE ORDER_ID="+order.getIdOrder()+",USER_ID="+order.getIdUser()+",TABLE_ID="+order.getIdTable()+",RESERVATION_ID="+order.getIdReservation());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}