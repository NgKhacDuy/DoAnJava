/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KHUYENMAI_DTO;
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
public class KHUYENMAI_DAO {
    private MyConnect myconnect;
    public ArrayList<KHUYENMAI_DTO>getlistKM(){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon(); 
            String sql ="SELECT * FROM KHUYENMAI";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<KHUYENMAI_DTO>dskm=new ArrayList<>();
            while(rs.next()){
                KHUYENMAI_DTO km = new KHUYENMAI_DTO();
                km.setCtkm(rs.getString(1));
                km.setMakh(rs.getInt(2));
                km.setGiamgia(rs.getInt(3));
                dskm.add(km);
            }
            return dskm;
        } catch (Exception e) {
        }
        return null;
    }
    public boolean themKM(KHUYENMAI_DTO km){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "INSERT INTO KHUYENMAI (CTKM,MAKH,GIAMGIA)"+"VALUES(?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, km.getCtkm());
            pre.setInt(2, km.getMakh());
            pre.setInt(3, km.getGiamgia());
            pre.execute();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean xoaKM(int ma){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql="DELETE FROM KHUYENMAI WHERE MAKH="+ma;
            Statement st = con.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
        }        
        return false;

    }
    public boolean suaKM(KHUYENMAI_DTO km){
        try {
             myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql="UPDATE KHUYENMAI SET "
                    +"CTKM=?, "
                    +"GIAMGIA=? "
                    +"WHERE MAKH=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, km.getCtkm());
            pre.setInt(2, km.getGiamgia());
            pre.setInt(3, km.getMakh());
            pre.execute();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean checkMAKH(String ma) throws SQLException{
        myconnect= new MyConnect();
        Connection con = myconnect.getCon();
        try {
            String sql="SELECT MAKH FROM KHACHHANG WHERE MAKH="+ma;
            PreparedStatement pre=con.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            if(rs.next())
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
