/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KHUYENMAI_DAO;
import DTO.KHUYENMAI_DTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KHUYENMAI_BUS {
    private ArrayList<KHUYENMAI_DTO>listKM=null;
    private KHUYENMAI_DAO km_dao = new KHUYENMAI_DAO();
    public KHUYENMAI_BUS(){
        doclistKM();
    }
    public void doclistKM(){
        listKM=km_dao.getlistKM();
    }
    public ArrayList<KHUYENMAI_DTO>getlistKM(){
        if(listKM==null)
            doclistKM();
        return listKM;
    }
    public ArrayList<KHUYENMAI_DTO>getKMtheoMaKH(String ma){
        ArrayList<KHUYENMAI_DTO>dskm=new ArrayList<>();
        int makh=Integer.parseInt(ma);
        for(KHUYENMAI_DTO km :listKM){
            int maKH=km.getMakh();
            if(maKH==makh)
                dskm.add(km);
        }
        return dskm;
    }
    public boolean themKM(String ctkm, int makh, int giamgia){
        try {
            KHUYENMAI_DTO km = new KHUYENMAI_DTO();
            km.setCtkm(ctkm);
            km.setMakh(makh);
            km.setGiamgia(giamgia);
            if(km_dao.themKM(km))
                return true;
            else
                return false;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean xoaKM(int makh){
        if(km_dao.xoaKM(makh))
            return true;
        return false;
    }
    public boolean suaKM(String ctkm, int makh, int giamgia){
        try {
            KHUYENMAI_DTO km = new KHUYENMAI_DTO();
            km.setCtkm(ctkm);
            km.setMakh(makh);
            km.setGiamgia(giamgia);
            if(km_dao.suaKM(km))
                return true;
            else
                return false;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean checkMAKH(String ma) throws SQLException{
        return km_dao.checkMAKH(ma);
    }
}
