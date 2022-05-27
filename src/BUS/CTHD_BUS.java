/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTHD_DAO;
import DTO.CTHD_DTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class CTHD_BUS {
    private ArrayList<CTHD_DTO>listcthd=null;
    private CTHD_DAO cthd_Dao= new CTHD_DAO();
    public CTHD_BUS(){
        doclistcthd();
    }
    public void doclistcthd(){
        listcthd=cthd_Dao.getListCTHD();
    }
    public ArrayList<CTHD_DTO>getlistcthd(){
        if(listcthd==null)
            doclistcthd();
        return listcthd;
    }
    public ArrayList<CTHD_DTO>getCTHDTheoMaHD(String ma){
        ArrayList<CTHD_DTO>dscthd=new ArrayList<>();
        int mahd=Integer.parseInt(ma);
        for(CTHD_DTO cthd:listcthd){
            int maHD=cthd.getMahd();
            if(maHD==mahd)
                dscthd.add(cthd);
        }
        return dscthd;
    }
    public ArrayList<CTHD_DTO>getCTHDTheoMaSP(String ma){
        ArrayList<CTHD_DTO>dscthd=new ArrayList<>();
        int masp=Integer.parseInt(ma);
        for(CTHD_DTO cthd:listcthd){
            int maSP=cthd.getMahd();
            if(maSP==masp)
                dscthd.add(cthd);
        }
        return dscthd;
    }
    public boolean themCthd(int masp, int soluong, int dongia, int thanhtien,Date ngaylap){
        try{
            CTHD_DTO cthd = new CTHD_DTO();
            cthd.setMasp(masp);
            cthd.setSoluong(soluong);
            cthd.setDongia(dongia);
            cthd.setThanhtien(thanhtien);
            cthd.setNgaylap(ngaylap);
            if(cthd_Dao.themCTHD(cthd))
                return true;
            else
                return false;
        } catch(Exception e){
            
        }
        return false;
    }
    public boolean xoaCthd(int mahd){
        if(cthd_Dao.xoaCTHD(mahd))
            return true;
        return false;
    }
    public boolean suaCthd(int mahd, int masp, int soluong, int dongia, int thanhtien,Date ngaylap){
        try {
            CTHD_DTO cthd = new CTHD_DTO();
            cthd.setMahd(mahd);
            cthd.setMasp(masp);
            cthd.setSoluong(soluong);
            cthd.setDongia(dongia);
            cthd.setThanhtien(thanhtien);
            cthd.setNgaylap(ngaylap);
            if(cthd_Dao.suaCTHD(cthd))
                return true;
            else
                return false;
        } catch (Exception e) {
        }
        return false;
    }
    public int getGiaTheoMa(String ma) throws SQLException{
        int masp=Integer.parseInt(ma);
        return cthd_Dao.getDonGiaTuMaSP(masp);
    }
    
}
