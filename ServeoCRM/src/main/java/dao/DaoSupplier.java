package dao;

import Models.Supplier;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSupplier{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Supplier supplier = new Supplier();

    
    public Boolean createSupplier(Supplier supplier) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_SUPPLIERS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+supplier.getName()+","+supplier.getContactName()+","+supplier.getPhone()+","+supplier.getEmail()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Supplier findSupplier(Supplier supplier) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplier;
    }

    
    public List<Supplier> lstSupplier() {
        List<Supplier> listSupplier = new ArrayList<>();
        try {
            con.open();
            res = con.executeSql("");
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                supplier = new Supplier();
                supplier.setIdSupplier(rs.getInt(""));
                supplier.setName(rs.getString(""));
                supplier.setContactName(rs.getString(""));
                supplier.setPhone(rs.getString(""));
                supplier.setEmail(rs.getString(""));
                supplier.setCreateDate(rs.getString(""));
                supplier.setModDate(rs.getString(""));
                listSupplier.add(supplier);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSupplier;
    }

    
    public Boolean updateSupplier(Supplier supplier) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_SUPPLIERS SET SUPPLIER_NAME="+supplier.getName()+",CONTACT_NAME="+supplier.getContactName()+",PHONE="+supplier.getPhone()+",EMAIL="+supplier.getEmail()+",CONVERT(DATE,GETDATE()) WHERE SUPPLIER_ID="+supplier.getIdSupplier());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteSupplier(Supplier supplier) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_SUPPLIERS WHERE SUPPLIER_ID="+ supplier.getIdSupplier());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}