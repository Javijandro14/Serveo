package dao;

import Models.WaitlistEntree;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoWaitlistEntree{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    WaitlistEntree waitlistEntree = new WaitlistEntree();
    
    public Boolean createWaitlistEntree(WaitlistEntree waitlistEntree) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_WAITLIST_ENTRIES VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+waitlistEntree.getIdUser()+","+waitlistEntree.getPartySize()+","+waitlistEntree.getJoinedAt()+","+waitlistEntree.getStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public WaitlistEntree findWaitlistEntree(WaitlistEntree waitlistEntree) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return waitlistEntree;
    }

    
    public List<WaitlistEntree> lstWaitlistEntree() {
        List<WaitlistEntree> listWaitlistEntree = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                waitlistEntree = new WaitlistEntree();
                waitlistEntree.setIdWaitlist(rs.getInt(""));
                waitlistEntree.setIdUser(rs.getInt(""));
                waitlistEntree.setPartySize(rs.getInt(""));
                waitlistEntree.setJoinedAt(rs.getString(""));
                waitlistEntree.setStatus(rs.getString(""));
                waitlistEntree.setUser(rs.getString(""));
                waitlistEntree.setModDate(rs.getString(""));
                waitlistEntree.setCreateDate(rs.getString(""));
                listWaitlistEntree.add(waitlistEntree);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listWaitlistEntree;
    }

    
    public Boolean updateWaitlistEntree(WaitlistEntree waitlistEntree) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_WAITLIST_ENTRIES SET PARTY_SIZE="+waitlistEntree.getPartySize()+",JOINED_AT="+waitlistEntree.getJoinedAt()+",WAIT_STATUS="+waitlistEntree.getStatus()+", MOD_DATE=CONVERT(DATE,GETDATE()) WHERE  WAITLIST_ID="+waitlistEntree.getIdWaitlist()+"AND USER_ID="+waitlistEntree.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteWaitlistEntree(WaitlistEntree waitlistEntree) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_WAITLIST_ENTRIES WHERE WAITLIST_ID="+waitlistEntree.getIdWaitlist()+" AND USER_ID="+waitlistEntree.getIdUser());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
