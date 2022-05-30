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
                hd.setManv(rs.getInt(3));
                hd.setGiamgia(rs.getDouble(4));
                hd.setTongtien(rs.getDouble(5));
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
            String sql = "INSERT INTO HOADON (MAHD,MAKH,MANV,GIAMGIA,TONGTIEN) "+"VALUES(?,?,?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hd.getMahd());
            pre.setInt(2, hd.getMakh());
            pre.setInt(3, hd.getManv());
            pre.setDouble(4, hd.getGiamgia());
            pre.setDouble(5, hd.getTongtien());
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
                    +"MANV=?, "
                    +"GIAMGIA=?, "
                    +"TONGTIEN=? "
                    +"WHERE MAHD=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hd.getMakh());
            pre.setInt(2, hd.getManv());
            pre.setDouble(3, hd.getGiamgia());
            pre.setDouble(4, hd.getTongtien());
            pre.setInt(5, hd.getMahd());
            pre.execute();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public int getMaHD_CTHD(int ma) throws SQLException{
        myconnect=new MyConnect();
        Connection con = myconnect.getCon();
        try{
            String sql = "SELECT * FROM CTHOADON WHERE MAHD = "+ma;
            PreparedStatement pre=con.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            if(rs.next())
                return rs.getInt(1);
        }
        catch (Exception e) {
        }
        return 0;
    }
    public double getTongTien_CTHD(int ma) throws SQLException{
        myconnect= new MyConnect();
        Connection con = myconnect.getCon();   
        try {
            String sql="SELECT THANHTIEN FROM CTHOADON WHERE MAHD ="+ma;
            PreparedStatement pre=con.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            if(rs.next())
                return rs.getDouble(1);
        } catch (Exception e) {
        }
        return 0;
    }
    public boolean getMaKH_KH(int ma) throws SQLException{
        myconnect= new MyConnect();
        Connection con = myconnect.getCon();  
        try {
            String sql="SELECT MAKH FROM KHACHHANG WHERE MAKH="+ma;
            PreparedStatement pre=con.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            if(rs.next())
                return true;
        } catch (Exception e) {
        }
        return false;
    }
    public double checkGiamGia(int ma) throws SQLException{
        myconnect= new MyConnect();
        Connection con = myconnect.getCon(); 
        try {
            String sql="SELECT GIAMGIA FROM KHUYENMAI WHERE MAKH="+ma;
            PreparedStatement pre=con.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            if(rs.next())
                return rs.getDouble(1);
        } catch (Exception e) {
        }
        return 0;
    }
    public boolean getMaNV_NV(int ma) throws SQLException{
        myconnect= new MyConnect();
        Connection con = myconnect.getCon();  
        try {
            String sql="SELECT MANV FROM NHANVIEN WHERE MANV="+ma;
            PreparedStatement pre=con.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            if(rs.next())
                return true;
        } catch (Exception e) {
        }
        return false;
    }

    
}
