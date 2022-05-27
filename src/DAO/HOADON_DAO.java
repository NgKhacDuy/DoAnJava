/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.HOADON_DTO;
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
public class HOADON_DAO {
    private MyConnect myconnect;
    public ArrayList<HOADON_DTO>getListHD(){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon(); 
            String sql ="SELECT * FROM HOADON";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<HOADON_DTO>dshd=new ArrayList<>();
            while(rs.next()){
                HOADON_DTO hd = new HOADON_DTO();
                hd.setMahd(rs.getInt(1));
                hd.setMakh(rs.getInt(2));
                hd.setTongtien(rs.getInt(3));
                hd.setManv(rs.getInt(4));
                dshd.add(hd);
            }
            return dshd;
        } catch (Exception e) {
        }
        return null;
    }
    public boolean themHD(HOADON_DTO hd){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "INSERT INTO HOADON (MAKH,TONGTIEN,MANV) "+"VALUES(?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hd.getMakh());
            pre.setInt(2, hd.getTongtien());
            pre.setInt(3, hd.getTongtien());
            pre.execute();
            return true;
        } catch(SQLException e){}
        return false;
    }
    public boolean xoaHD(int ma){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "DELETE FROM HOADON WHERE MAHD="+ma;
            Statement st = con.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean suaHD(HOADON_DTO hd){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "UPDATE HOADON SET "
                    +"MAKH=?, "
                    +"TONGTIEN=?, "
                    +"MANV=? "
                    +"WHERE MAHD=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hd.getMakh());
            pre.setInt(2, hd.getTongtien());
            pre.setInt(3, hd.getManv());
            pre.setInt(4, hd.getMahd());
            pre.execute();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
}
