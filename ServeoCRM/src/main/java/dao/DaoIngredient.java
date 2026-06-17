package dao;

import Models.Ingredient;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoIngredient {

    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Ingredient ingredient = new Ingredient();

    public Boolean createIngredient(Ingredient ingredient) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO public.\"TBL_INGREDIENTS\" VALUES (SELECT MAX(\"INGREDIENT_ID\")+1 FROM public.\"TBL_INGREDIENTS\", "+ingredient.getIdSupplier()+", '"+ingredient.getName()+"', "+ingredient.getQuantity()+", '"+ingredient.getUnit()+"', CURRENT_DATE, CURRENT_DATE)");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Ingredient findIngredient(Ingredient ingredient) {

        try {
            con.open();
            res = con.executeSql("");
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredient;
    }

    public List<Ingredient> listIngredient() {
        List<Ingredient> lstIngredient = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT I.\"INGREDIENT_ID\", S.\"SUPPLIER_ID\", S.\"NAME\" AS \"SUPPLIER\", I.\"NAME\", I.\"QUANTITY\", I.\"UNIT\", I.\"CREATE_DATE\", I.\"MOD_DATE\" FROM public.\"TBL_INGREDIENTS\" AS I, public.\"TBL_SUPPLIERS\" AS S WHERE I.\"SUPPLIER_ID\" = S.\"SUPPLIER_ID\"");
            while (rs.next()) {
                ingredient = new Ingredient();
                ingredient.setIdIngredient(rs.getInt("INGREDIENT_ID"));
                ingredient.setIdSupplier(rs.getInt("SUPPLIER_ID"));
                ingredient.setSupplier(rs.getString("SUPPLIER"));
                ingredient.setName(rs.getString("NAME"));
                ingredient.setQuantity(rs.getDouble("QUANTITY"));
                ingredient.setUnit(rs.getString("UNIT"));
                ingredient.setCreateDate(rs.getString("CREATE_DATE"));
                ingredient.setModDate(rs.getString("MOD_DATE"));
                lstIngredient.add(ingredient);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return lstIngredient;
    }

    public Boolean updateIngredient(Ingredient ingredient) {
        try {
            con.open();
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public Boolean deleteIngredient(Ingredient ingredient) {
        try {
            con.open();
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
