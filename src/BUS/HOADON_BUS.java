/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HOADON_DAO;
import DTO.HOADON_DTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HOADON_BUS {
    private ArrayList<HOADON_DTO>listhd=null;
    private HOADON_DAO hd_DAO=new HOADON_DAO();
    public HOADON_BUS(){
        doclistHD();
    }
    public void doclistHD(){
        listhd=hd_DAO.getListHD();
    }
    public ArrayList<HOADON_DTO>getlistHD(){
        if(listhd==null)
            doclistHD();
        return listhd;
    }
    public ArrayList<HOADON_DTO>getHDtheoMaHD(String ma){
        ArrayList<HOADON_DTO>dsHD=new ArrayList<>();
        int mahd = Integer.parseInt(ma);
        for(HOADON_DTO hd : listhd){
            int maHD=hd.getMahd();
            if(maHD==mahd)
                dsHD.add(hd);
        }
        return dsHD;
    }
    public ArrayList<HOADON_DTO>getHDtheoMaKH(String ma){
        ArrayList<HOADON_DTO>dsHD=new ArrayList<>();
        int makh = Integer.parseInt(ma);
        for(HOADON_DTO hd : listhd){
            int maKH=hd.getMahd();
            if(maKH==makh)
                dsHD.add(hd);
        }
        return dsHD;
    }
    public boolean themHD(int mahd,int makh, int manv, double giamgia, double tongtien){
        try {
            HOADON_DTO hd = new HOADON_DTO();
        hd.setMahd(mahd);
        hd.setMakh(makh);
        hd.setManv(manv);
        hd.setGiamgia(giamgia);
        hd.setTongtien(tongtien);
        if(hd_DAO.themHD(hd))
            return true;
        else
            return false;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean xoaHD(int ma){
        if(hd_DAO.xoaHD(ma))
            return true;
        return false;
    }
    public boolean suaHD(int mahd,int makh, int manv, double giamgia, double thanhtien){
        try {
            HOADON_DTO hd = new HOADON_DTO();
            hd.setMahd(mahd);
            hd.setMakh(makh);
            hd.setManv(makh);
            hd.setGiamgia(giamgia);
            hd.setTongtien(thanhtien);
            if(hd_DAO.suaHD(hd))
                return true;
            else
                return false;
        } catch (Exception e) {
        }
        return false;
    }
    public int getMAHD_CTHD(String ma) throws SQLException{
        int mahd=Integer.parseInt(ma);
        return hd_DAO.getMaHD_CTHD(mahd);
    }
    public double getTongTien_CTHD(String ma) throws SQLException{
        int tongtien=Integer.parseInt(ma);
        return hd_DAO.getTongTien_CTHD(tongtien);
    }
    public boolean checkMaKH(String ma) throws SQLException{
        int makh=Integer.parseInt(ma);
        return hd_DAO.getMaKH_KH(makh);
    }
    public boolean checkMaNV(String ma) throws SQLException{
        int manv=Integer.parseInt(ma);
        return hd_DAO.getMaNV_NV(manv);
    }
    public double checkGIAMGIA(String ma) throws SQLException{
        int makh=Integer.parseInt(ma);
        return hd_DAO.checkGiamGia(makh);
    }
    
}
