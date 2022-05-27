/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.CTHD_DTO;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author DELL
 */
public class CTHD_DAO {
    private MyConnect myconnect;
    public ArrayList<CTHD_DTO>getListCTHD(){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon(); 
            String sql ="SELECT * FROM CTHOADON";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<CTHD_DTO>dscthd=new ArrayList<>();
            while(rs.next()){
                CTHD_DTO cthd = new CTHD_DTO();
                cthd.setMahd(rs.getInt(1));
                cthd.setMasp(rs.getInt(2));
                cthd.setSoluong(rs.getInt(3));
                cthd.setDongia(rs.getInt(4));
                cthd.setThanhtien(rs.getInt(5));
                dscthd.add(cthd);
            }
            return dscthd;
        } catch (Exception e) {
        }
        return null;
    }
    public boolean themCTHD(CTHD_DTO cthd){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "INSERT INTO CTHOADON (MASP,SOLUONG,DONGIA,THANHTIEN) "+"VALUES(?,?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, cthd.getMasp());
            pre.setInt(2, cthd.getSoluong());
            pre.setInt(3, cthd.getDongia());
            pre.setInt(4,cthd.getThanhtien());
            pre.execute();
            return true;
        } catch(SQLException e){}
        return false;
    }
    public boolean xoaCTHD(int ma){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "DELETE FROM CTHOADON WHERE MAHD="+ma;
            Statement st = con.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean suaCTHD(CTHD_DTO cthd){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "UPDATE CTHOADON SET "
                    +"MASP=?, "
                    +"SOLUONG=?, "
                    +"DONGIA=?, "
                    +"THANHTIEN=? "
                    +"WHERE MAHD=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, cthd.getMasp());
            pre.setInt(2, cthd.getSoluong());
            pre.setInt(3, cthd.getDongia());
            pre.setInt(4, cthd.getThanhtien());
            pre.setInt(5, cthd.getMahd());
            pre.execute();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
