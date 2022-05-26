/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NHANVIEN_DTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class NHANVIEN_DAO {
    private MyConnect myconnect;
    public ArrayList<NHANVIEN_DTO> getListNV(){
        try{
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql="SELECT * FROM NHANVIEN";
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            ArrayList<NHANVIEN_DTO>dsnv=new ArrayList<>();
            while(rs.next()){
                NHANVIEN_DTO nv = new NHANVIEN_DTO();
                nv.setMANV(rs.getInt(1));
                nv.setTENNV(rs.getString(2));
                nv.setNGAYSINH(rs.getString(3));
                nv.setDIACHI(rs.getString(4));
                nv.setSDT(rs.getString(5));
                nv.setCHUCVU(rs.getString(6));
                nv.setCALAM(rs.getString(7));
                dsnv.add(nv);
            }
            return dsnv;
        }catch(SQLException e){}
        return null;
    }
    public boolean themNV(NHANVIEN_DTO nv){
        try {
            myconnect= new MyConnect();
            Connection con = myconnect.getCon();
            String sql="INSERT INTO NHANVIEN(TENNV,NGAYSINH,DIACHI,SDT,CHUCVU,CALAM)"+"VALUES(?,?,?,?,?,?)";
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, nv.getTENNV());
            pre.setString(2, nv.getNGAYSINH());
            pre.setString(3,nv.getDIACHI());
            pre.setString(4,nv.getSDT());
            pre.setString(5,nv.getCHUCVU());
            pre.setString(6, nv.getCALAM());
            pre.execute();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean xoaNV(int maNV){
        try{
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql = "DELETE FROM NHANVIEN WHERE MANV ="+maNV;
            Statement st=con.createStatement();
            st.execute(sql);
            return true;
        }
        catch(SQLException e){}
        return false;
    }
    public boolean suaNV(NHANVIEN_DTO nv){
        try {
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql="UPDATE NHANVIEN SET "
                    +"TENNV=?, "
                    +"NGAYSINH=?, "
                    +"DIACHI=?, "
                    +"SDT=?, "
                    +"CHUCVU=?, "
                    +"CALAM=? "
                    +"WHERE MANV=?";
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, nv.getTENNV());
            pre.setString(2, nv.getNGAYSINH());
            pre.setString(3, nv.getDIACHI());
            pre.setString(4,nv.getSDT());
            pre.setString(5, nv.getCHUCVU());
            pre.setString(6, nv.getCALAM());
            pre.setInt(7, nv.getMANV());
            pre.execute();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
