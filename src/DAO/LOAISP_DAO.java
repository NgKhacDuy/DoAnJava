/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static DAO.MyConnect.conn;
import DTO.LOAISP_DTO;
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
public class LOAISP_DAO {
    private MyConnect myconnect;
    public ArrayList<LOAISP_DTO> getlistLoai(){
        try {
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql="SELECT * FROM LOAISP";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<LOAISP_DTO> dsloaisp=new ArrayList<>();
            while(rs.next()){
                LOAISP_DTO loaisp=new LOAISP_DTO();
                loaisp.setMaloaisp(rs.getInt(1));
                loaisp.setTenloaisp(rs.getString(2));
                dsloaisp.add(loaisp);
            }
            return dsloaisp;
        } catch (SQLException e) {
        }
        return null;
    }   
    public boolean themLoaisp(LOAISP_DTO loaisp){
        try {
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql="INSERT INTO LOAISP(TENLOAISP)"+"VALUES(?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, loaisp.getTenloaisp());
            pre.execute();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean xoaLoaiSP(int maloaiSP){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "DELETE FROM LOAISP WHERE MALOAISP ="+maloaiSP;
            Statement st = con.createStatement();
            st.execute(sql);
            return true;
        } catch(SQLException e){}
        return false;
    }
    public boolean suaLoaiSP(LOAISP_DTO loaisp){
        try{
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "UPDATE LOAISP SET "
                    +"TENLOAISP=? "
                    +"WHERE MALOAISP=?";
            
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,loaisp.getTenloaisp());
            pre.setInt(2, loaisp.getMaloaisp());
            pre.execute();
            return true;
        } catch (SQLException e){}
        return false;
    }
}
