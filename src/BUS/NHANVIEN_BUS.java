/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NHANVIEN_DAO;
import DTO.NHANVIEN_DTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Formatter;

/**
 *
 * @author DELL
 */
public class NHANVIEN_BUS {
    private ArrayList<NHANVIEN_DTO>listnv=null;
    private NHANVIEN_DAO nvDAO=new NHANVIEN_DAO();
    public NHANVIEN_BUS(){
        docListNV();
    }   
    public void docListNV(){
        listnv=nvDAO.getListNV();
    }
    public ArrayList<NHANVIEN_DTO>getListNV(){
        if(listnv==null);
            docListNV();
        return listnv;
    }
    public ArrayList<NHANVIEN_DTO>getNVTheoTen(String ten){
        ArrayList<NHANVIEN_DTO>dsnv=new ArrayList<>();
        for(NHANVIEN_DTO nv: listnv){
            String tenNV=nv.getTENNV().toLowerCase();
            if(tenNV.toLowerCase().contains(ten.toLowerCase()))
                dsnv.add(nv);
        }
        return dsnv;
    }
    public ArrayList<NHANVIEN_DTO>getNVTheoMa(String ma){
        ArrayList<NHANVIEN_DTO>dsnv=new ArrayList<>();
        int manv=Integer.parseInt(ma);
        for(NHANVIEN_DTO nv :listnv){
            int maNV=nv.getMANV();
            if(maNV==manv)
                dsnv.add(nv);
        }
        return dsnv;
    }
    public boolean themNV(String ten,String ngaysinh,String diachi, String sdt, String chucvu, String calam){
        try {
            NHANVIEN_DTO nv = new NHANVIEN_DTO();
            nv.setTENNV(ten);
            nv.setNGAYSINH(ngaysinh);
            nv.setDIACHI(diachi);
            nv.setSDT(sdt);
            nv.setCHUCVU(chucvu);
            nv.setCALAM(calam);
            if(nvDAO.themNV(nv))
                return true;
            else 
                return false;
            
        } catch (Exception e) {
        }
        return false;
        
    }
    public boolean xoaNV(String ma){
        if(ma.trim().equals(""))
            return false;
        int manv=Integer.parseInt(ma);
        if(nvDAO.xoaNV(manv))
            return true;
        return false;
    }
    public boolean suaNV(String ma,String ten,String ngaysinh,String diachi, String sdt, String chucvu, String calam){
        try {
            int manv=Integer.parseInt(ma);
            NHANVIEN_DTO nv = new NHANVIEN_DTO();
            nv.setMANV(manv);
            nv.setTENNV(ten);
            nv.setNGAYSINH(ngaysinh);
            nv.setDIACHI(diachi);
            nv.setSDT(sdt);
            nv.setCHUCVU(chucvu);
            nv.setCALAM(calam);
            if(nvDAO.suaNV(nv))
                return true;
            else
                return false;
        } catch (Exception e) {
        }
        return false;
    }
}
