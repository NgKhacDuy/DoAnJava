/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KHACHHANG_DAO;
import DTO.KHACHHANG_DTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KHACHHANG_BUS {
    private ArrayList<KHACHHANG_DTO> listkh=null;
    private KHACHHANG_DAO kh_DAO = new KHACHHANG_DAO();
    public KHACHHANG_BUS(){
        docListKH();
    }
    public void docListKH(){
        listkh=kh_DAO.getlistKH();
    }
    public ArrayList<KHACHHANG_DTO> getListKH(){
        if(listkh==null);
            docListKH();
        return listkh;
    }
    public ArrayList<KHACHHANG_DTO> getKHTheoTen(String ten){
        ArrayList<KHACHHANG_DTO> dskh=new ArrayList<>();
        for(KHACHHANG_DTO kh : listkh){
            String tenkh=kh.getTENKH().toLowerCase();
            if(tenkh.toLowerCase().contains(ten))
                dskh.add(kh);
        }
        return dskh;
    }
    public ArrayList<KHACHHANG_DTO> getKHTheoMa(String ma){
        ArrayList<KHACHHANG_DTO> dskh=new ArrayList<>();
        int maKH=Integer.parseInt(ma);
        for(KHACHHANG_DTO kh : listkh){
            int makh=kh.getMAKH();
            if(makh==maKH)
                dskh.add(kh);
        }
        return dskh;
    }
    public boolean themKH(String ten,String sdt){
        try {
            KHACHHANG_DTO kh=new KHACHHANG_DTO();
            kh.setTENKH(ten);
            kh.setSDT(sdt);
            if(kh_DAO.themNV(kh))
                return true;
            else
                return false;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean xoaKH(String ma){
        if(ma.trim().equals("")){
            return false;
        }
        int manv=Integer.parseInt(ma);
        if(kh_DAO.xoaNV(manv)){
            return true;
        }
        return false;
    }   
    public boolean suaKH(String ma,String ten,String sdt){
        try {
            int manv=Integer.parseInt(ma);
            KHACHHANG_DTO kh = new KHACHHANG_DTO();
            kh.setMAKH(manv);
            kh.setTENKH(ten);
            kh.setSDT(sdt);
            if(kh_DAO.suaNV(kh)){
                return true;
            }
            else{
                return false;
            }
        } 
        
        catch (Exception e) {
        }
        return false;
    }
}
