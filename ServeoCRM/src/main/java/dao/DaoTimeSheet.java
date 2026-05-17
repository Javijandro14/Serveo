package dao;

import Models.TimeSheet;
import config.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoTimeSheet{
    
    TimeSheet timeSheet = new TimeSheet();
    
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();

    
    public Boolean createTimeSheet(TimeSheet timeSheet) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_TIME_SHEETS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+timeSheet.getIdEmployee()+","+timeSheet.getIdShift()+","+timeSheet.getClockIn()+","+timeSheet.getClockOut()+","+timeSheet.getIdApprovedUser()+","+timeSheet.getStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public TimeSheet findTimeSheet(TimeSheet timeSheet) {
        timeSheet = new TimeSheet();
        try {
            con.open(); 
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            timeSheet.setIdTimeSheet(rs.getInt("0"));
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timeSheet;
    }

    
    public List<TimeSheet> lstTimeSheet() {
        List<TimeSheet> listTimeSheet = new ArrayList<>();
        try {
            con.open(); 
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                timeSheet = new TimeSheet();
                timeSheet.setIdTimeSheet(rs.getInt("0"));
                listTimeSheet.add(timeSheet);
            }
            rs.close();
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTimeSheet;
    }

    
    public Boolean updateTimeSheet(TimeSheet timeSheet) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_TIME_SHEETS SET CLOCK_IN="+timeSheet.getClockIn()+",CLOCK_OUT="+timeSheet.getClockOut()+",APPROVED_BY="+timeSheet.getIdApprovedUser()+",TIMESHEET_STATUS="+timeSheet.getStatus()+",MOD_DATE="+timeSheet.getModDate()+" WHERE TIMESHEET_ID="+timeSheet.getIdTimeSheet()+" AND EMPLOYEE_ID="+timeSheet.getIdEmployee()+" AND SHIFT_ID="+timeSheet.getIdShift()+";");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteTimeSheet(TimeSheet timeSheet) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_TIME_SHEETS WHERE TIMESHEET_ID="+timeSheet.getIdTimeSheet()+" AND EMPLOYEE_ID="+timeSheet.getIdEmployee()+" AND SHIFT_ID="+timeSheet.getIdShift()+";");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoTimeSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}