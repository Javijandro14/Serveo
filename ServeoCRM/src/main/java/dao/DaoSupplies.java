package dao;

import Models.Supplies;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSupplies {

    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Supplies supplies = new Supplies();

    public Boolean createSupplies(Supplies supplies) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO public.\"TBL_SUPPLIES\" VALUES (SELECT MAX(\"ITEM_ID\")+1 FROM public.\"TBL_SUPPLIES\", "+supplies.getIdSupplier()+",'"+supplies.getName()+"', "+supplies.getQuantity()+", '"+supplies.getUnit()+"', CURRENT_DATE, CURRENT_DATE)");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Supplies findSupplies(Supplies supplies) {

        try {
            con.open();
            res = con.executeSql("");
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplies;
    }

    public List<Supplies> listSupplies() {
        List<Supplies> lstSupplies = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.\"ITEM_ID\", SP.\"SUPPLIER_ID\", SP.\"NAME\" AS \"SUPPLIER\", S.\"NAME\", S.\"QUANTITY\", S.\"UNIT\", S.\"CREATE_DATE\", S.\"MOD_DATE\" FROM public.\"TBL_SUPPLIES\" AS S, public.\"TBL_SUPPLIERS\" AS SP WHERE S.\"SUPPLIER_ID\" = SP.\"SUPPLIER_ID\"");
            while (rs.next()) {
                supplies = new Supplies();
                supplies.setIdItem(rs.getInt("ITEM_ID"));
                supplies.setIdSupplier(rs.getInt("SUPPLIER_ID"));
                supplies.setQuantity(rs.getDouble("QUANTITY"));
                supplies.setName(rs.getString("NAME"));
                supplies.setSupplier(rs.getString("SUPPLIER"));
                supplies.setUnit(rs.getString("UNIT"));
                supplies.setCreateDate(rs.getString("CREATE_DATE"));
                supplies.setModDate(rs.getString("MOD_DATE"));
                lstSupplies.add(supplies);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return lstSupplies;
    }

    public Boolean updateSupplies(Supplies supplies) {
        try {
            con.open();
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Boolean deleteSupplies(Supplies supplies) {
        try {
            con.open();
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoSupplies.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
