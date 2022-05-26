/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KHACHHANG_DTO;
import DTO.LOAISP_DTO;
import DTO.KHACHHANG_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KHACHHANG_DAO {
    private MyConnect myconnect;
    public ArrayList<KHACHHANG_DTO> getlistKH(){
    try {
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql="SELECT * FROM KHACHHANG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<KHACHHANG_DTO> dskh=new ArrayList<>();
            while(rs.next()){
                KHACHHANG_DTO kh=new KHACHHANG_DTO();
                kh.setMAKH(rs.getInt(1));
                kh.setTENKH(rs.getString(2));
                kh.setSDT(rs.getString(3));
                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException e) {
        }
        return null;
    }
    public boolean themNV(KHACHHANG_DTO kh){
        try {
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql="INSERT INTO KHACHHANG(TENKH,SDT) "+"VALUES(?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, kh.getTENKH());
            pre.setString(2, kh.getSDT());
            pre.execute();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean xoaNV(int ma){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "DELETE FROM KHACHHANG WHERE MAKH ="+ma;
            Statement st = con.createStatement();
            st.execute(sql);
            return true;
        } catch(SQLException e){}
        return false;
    }
    public boolean suaNV(KHACHHANG_DTO kh){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "UPDATE KHACHHANG SET "
                    +"TENKH=?, "
                    +"SDT=? "
                    +"WHERE MAKH=?";
            
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,kh.getTENKH());
            pre.setString(2,kh.getSDT());
            pre.setInt(3,kh.getMAKH());
            pre.execute();
            return true;
        } catch (SQLException e){}
        return false;
    }
}
