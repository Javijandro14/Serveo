package dao;

import Models.Reservation;
import config.DbConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoReservation{
    Boolean res = false;
    ResultSet rs = null;
    DbConnection con = new DbConnection();
    Reservation reservation = new Reservation();

    
    public Boolean createReservation(Reservation reservation) {
        try {
            con.open();
            res = con.executeSql("INSERT INTO TBL_RESERVATIONS VALUES((SELECT MAX(IDAREA)+1 FROM [TBL_TIME_SHEETS]),"+reservation.getIdUser()+","+reservation.getIdTable()+","+reservation.getScheduledDate()+","+reservation.getPartySize()+","+reservation.getStatus()+",CONVERT(DATE,GETDATE()),CONVERT(DATE,GETDATE()))");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Reservation findReservation(Reservation reservation) {
        try {
            con.open();
            res = con.executeSql("");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservation;
    }

    
    public List<Reservation> lstReservation() {
        List<Reservation> listReservation = new ArrayList<>();
        try {
            con.open();
            rs = con.executeQuery("SELECT S.IDSTATUS, S.NAME, S.TYPE, S.MODDATE, S.CREATEDATE FROM STATUS S");
            while (rs.next()) {
                reservation = new Reservation();
                reservation.setIdReservation(rs.getInt(""));
                reservation.setIdUser(rs.getInt(""));
                reservation.setIdTable(rs.getInt(""));
                reservation.setPartySize(rs.getInt(""));
                reservation.setScheduledDate(rs.getString(""));
                reservation.setUser(rs.getString(""));
                reservation.setTable(rs.getString(""));
                reservation.setStatus(rs.getString(""));
                reservation.setCreateDate(rs.getString(""));
                reservation.setModDate(rs.getString(""));
                listReservation.add(reservation);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listReservation;
    }

    
    public Boolean updateReservation(Reservation reservation) {
        try {
            con.open();
            res = con.executeSql("UPDATE TBL_RESERVATIONS SET SCHEDULE_DATE="+reservation.getScheduledDate()+",PARTY_SIZE="+reservation.getPartySize()+",RESERVATION_STATUS="+reservation.getStatus()+", MOD_DATE=CONVERT(DATE,GETDATE()) WHERE RESERVATION_ID="+reservation.getIdReservation()+" AND USER_ID="+reservation.getIdUser()+" AND TABLE_ID="+reservation.getIdTable());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    public Boolean deleteReservation(Reservation reservation) {
        try {
            con.open();
            res = con.executeSql("DELETE FROM TBL_RESERVATIONS WHERE RESERVATION_ID="+reservation.getIdReservation()+" AND USER_ID="+reservation.getIdUser()+" AND TABLE_ID="+ reservation.getIdTable());
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}