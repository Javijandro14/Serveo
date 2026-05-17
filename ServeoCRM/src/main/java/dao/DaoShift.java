package dao;

import Models.Shift;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoShift{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Shift shift = new Shift();

    
    public Boolean createShift(Shift shift) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_SHIFTS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+shift.getIdEmployee()+","+shift.getStartTime()+","+shift.getEndTime()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Shift findShift(Shift shift) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shift;
    }

    
    public List<Shift> lstShift() {
        List<Shift> listShift = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                shift = new Shift();
                shift.setIdShift(rs.getInt(""));
                shift.setIdEmployee(rs.getInt(""));
                shift.setEmployee(rs.getString(""));
                shift.setStartTime(rs.getString(""));
                shift.setEndTime(rs.getString(""));
                shift.setCreateDate(rs.getString(""));
                shift.setModDate(rs.getString(""));
                listShift.add(shift);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listShift;
    }

    
    public Boolean updateShift(Shift shift) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_SHIFTS SET START_TIME="+shift.getStartTime()+",END_TIME="+shift.getEndTime()+",MOD_DATE=CONVERT(DATE,GETDATE()) WHERE SHIFT_ID="+shift.getIdShift()+" AND EMPLOYEE_ID="+shift.getIdEmployee());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteShift(Shift shift) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_SHIFTS WHERE SHIFT_ID="+shift.getIdShift()+",EMPLOYEE_ID="+shift.getIdEmployee());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}