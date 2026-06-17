package dao;

import Models.Supplier;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSupplier {

    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Supplier supplier = new Supplier();

    public Boolean createSupplier(Supplier supplier) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO public.\"TBL_SUPPLIERS\" VALUES (SELECT MAX(\"SUPPLIER_ID\")+1 FROM public.\"TBL_SUPPLIERS\", '"+supplier.getName()+"', '"+supplier.getPhone()+"', '"+supplier.getEmail()+"', '"+supplier.getDescription()+"', CURRENT_DATE, CURRENT_DATE)");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Supplier findSupplier(Supplier supplier) {

        try {
            con.open();
            res = con.executeSql("");
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplier;
    }

    public List<Supplier> listSupplier() {
        List<Supplier> lstSupplier = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT \"SUPPLIER_ID\", \"NAME\", \"PHONE_NO\", \"EMAIL\", \"DESCRIPTION\", \"CREATE_DATE\", \"MOD_DATE\" FROM public.\"TBL_SUPPLIERS\"");
            while (rs.next()) {
                supplier = new Supplier();
                supplier.setIdSupplier(rs.getInt("SUPPLIER_ID"));
                supplier.setName(rs.getString("NAME"));
                supplier.setPhone(rs.getString("PHONE_NO"));
                supplier.setEmail(rs.getString("EMAIL"));
                supplier.setDescription(rs.getString("DESCRIPTION"));
                supplier.setCreateDate(rs.getString("CREATE_DATE"));
                supplier.setModDate(rs.getString("MOD_DATE"));
                lstSupplier.add(supplier);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return lstSupplier;
    }

    public Boolean updateSupplier(Supplier supplier) {
        try {
            con.open();
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Boolean deleteSupplier(Supplier supplier) {
        try {
            con.open();
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
