/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import static DAO.MyConnect.conn;
import java.sql.SQLException;

import DTO.SANPHAM_DTO;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author DELL
 */
public class SANPHAM_DAO {
    private MyConnect myconnect;
    public ArrayList<SANPHAM_DTO> getListSanPham(){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "SELECT * FROM SANPHAM";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<SANPHAM_DTO> dssp = new ArrayList<>();
            while(rs.next()){
                SANPHAM_DTO sp = new SANPHAM_DTO();
                sp.setMASP(rs.getInt(1));
                sp.setTENSP(rs.getString(2));
                sp.setGIA(rs.getInt(3));
                sp.setSIZE(rs.getString(4));
                sp.setSOLUONG(rs.getInt(5));
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException e){
            
        }
        return null;
    }
    
    public SANPHAM_DTO getSanPham(int ma){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "SELECT * FROM SANPHAM WHERE MASP=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, ma);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                SANPHAM_DTO sp = new SANPHAM_DTO();
                sp.setMASP(rs.getInt(1));
                sp.setTENSP(rs.getString(2));
                sp.setGIA(rs.getInt(3));
                sp.setSIZE(rs.getString(4));
                sp.setSOLUONG(rs.getInt(5));
                return sp;
            }
        } catch(SQLException e){
        }
        return null;
    }
    public void capNhatSoLuongSP(int ma, int soLuongMat){
        SANPHAM_DTO sp = getSanPham(ma);
        int soLuong=sp.getSOLUONG();
        sp.setSOLUONG(soLuong+soLuongMat);
        try{
            String sql = "UPDATE SANPHAM SET SOLUONG =? WHERE MASP =" + ma;
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, sp.getSOLUONG());
            pre.executeUpdate();
        } catch (SQLException e){}
    }
    public boolean themSanPham(SANPHAM_DTO sp){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "INSERT INTO SANPHAM(TENSP,GIA,SIZE,SOLUONG)"+"VALUES (?,?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, sp.getTENSP());
            pre.setInt(2, sp.getGIA());
            pre.setString(3, sp.getSIZE());
            pre.setInt(4, sp.getSOLUONG());
            pre.execute();
            return true;
        } catch (SQLException e){}
        return false;
    }
    public ArrayList<SANPHAM_DTO> getTENSP_MASP(String ma, String ten){
        try {
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql="SELECT * FROM SANPHAM "
                    + "WHERE TENSP LIKE \"?\" "
                    + "and MASP =\"?\"";
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, ten);
            pre.setString(2, ma);
            ResultSet rs= pre.executeQuery();
            ArrayList<SANPHAM_DTO> dssp = new ArrayList<>();
            while(rs.next()){
                SANPHAM_DTO sp = new SANPHAM_DTO();
                sp.setMASP(rs.getInt(1));
                sp.setTENSP(rs.getString(2));
                sp.setGIA(rs.getInt(3));
                sp.setSIZE(rs.getString(4));
                sp.setSOLUONG(rs.getInt(5));
                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException e) {
            
        }
        return null;
    }
    
    public boolean xoaSanPham(int maSP){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "DELETE FROM SANPHAM WHERE MASP ="+maSP;
            Statement st = con.createStatement();
            st.execute(sql);
            return true;
        } catch(SQLException e){}
        return false;
    }
    public boolean suaSanPham(SANPHAM_DTO sp){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "UPDATE SANPHAM SET "
                    +"TENSP=?, "
                    + "GIA=?, "
                    + "SIZE=?, "
                    + "SOLUONG=? "
                    +"WHERE MASP=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,sp.getTENSP());
            pre.setInt(2, sp.getGIA());
            pre.setString(3, sp.getSIZE());
            pre.setInt(4, sp.getSOLUONG());
            pre.setInt(5, sp.getMASP());
            pre.execute();
            return true;
        } catch (SQLException e){}
        return false;
    }
    
}
