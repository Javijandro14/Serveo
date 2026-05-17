package dao;

import Models.Role;
import Models.Table;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoTable{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Table table = new Table();
    
    public Boolean createTable(Table table) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_TABLES VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+table.getTableNo()+","+table.getCapacity()+","+table.getLocation()+","+table.getStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Table findTable(Table table) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }

    
    public List<Table> lstTable() {
        List<Table> listTable = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                table = new Table();
                table.setIdTable(rs.getInt(""));
                table.setTableNo(rs.getInt(""));
                table.setCapacity(rs.getInt(""));
                table.setLocation(rs.getString(""));
                table.setStatus(rs.getString(""));
                table.setCreateDate(rs.getString(""));
                table.setModDate(rs.getString(""));
                listTable.add(table);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTable;
    }

    
    public Boolean updateTable(Table table) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_TABLES SET TABLE_NUMBER="+table.getTableNo()+",CAPACITY="+table.getCapacity()+",TABLE_LOCATION="+table.getLocation()+",TABLE_STATUS="+table.getStatus()+",MOD_DATE=CONVERT(DATE,GETDATE()) WHERE  TABLE_ID="+table.getIdTable());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteTable(Table table) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_TABLES WHERE TABLE_ID="+table.getIdTable()+" AND TABLE_NUMBER="+table.getTableNo());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}