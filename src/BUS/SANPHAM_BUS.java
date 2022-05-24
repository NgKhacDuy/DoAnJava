/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.SANPHAM_DTO;
import DAO.SANPHAM_DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class SANPHAM_BUS {
    private ArrayList<SANPHAM_DTO> listSP = null;
    private SANPHAM_DAO spDAO = new SANPHAM_DAO();
    public SANPHAM_BUS() throws ClassNotFoundException, SQLException{
        docListSP();
    }
    public void docListSP() throws ClassNotFoundException, SQLException{
        listSP= spDAO.getListSanPham();
    }
    public ArrayList<SANPHAM_DTO> getListSanPham() throws ClassNotFoundException, SQLException{
        if (listSP == null)
            docListSP();
        return listSP;
    }
    public SANPHAM_DTO getSanPham(String ma){
        if(!ma.trim().equals("")){
            try {
                int maSP = Integer.parseInt(ma);
                for(SANPHAM_DTO sp : listSP)
                    if(sp.getMASP()==maSP)
                        return sp;
            } catch (Exception e) {
            }
        }
        return null;
    }
    public ArrayList<SANPHAM_DTO> getSanPhamTheoTen(String ten){
        ArrayList<SANPHAM_DTO> dssp = new ArrayList<>();
        for(SANPHAM_DTO sp : listSP){
            String tenSP = sp.getTENSP().toLowerCase();
            if(tenSP.toLowerCase().contains(ten.toLowerCase()))
                dssp.add(sp);
        }
        return dssp;
    }
    public void capNhatSoLuongSP(int ma, int soLuongMat){
        spDAO.capNhatSoLuongSP(ma, soLuongMat);
    }
    public boolean themSanPham(String tensp,String gia, String size, String soluong){
        try {
            int soluongSP=Integer.parseInt(soluong);
            int donGia=Integer.parseInt(gia);
            SANPHAM_DTO sp = new SANPHAM_DTO();
            sp.setTENSP(tensp);
            sp.setGIA(donGia);
            sp.setSIZE(size);
            sp.setSOLUONG(soluongSP);
            if(spDAO.themSanPham(sp)){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public boolean xoaSanPham(String ma){
        if(ma.trim().equals("")){
            return false;
        }
        int masp=Integer.parseInt(ma);
        if(spDAO.xoaSanPham(masp)){
            return true;
        }
        return false;
    }   
    public boolean suaSanPham(String ma,String ten,String gia, String size, String soluong){
        try {
            int masp=Integer.parseInt(ma);
            int soLuong=Integer.parseInt(soluong);
            int DonGia=Integer.parseInt(gia);
            SANPHAM_DTO sp = new SANPHAM_DTO();
            sp.setMASP(masp);
            sp.setTENSP(ten);
            sp.setGIA(DonGia);
            sp.setSIZE(size);
            sp.setSOLUONG(soLuong);
            if(spDAO.suaSanPham(sp)){
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
    public String getTenSP(int masp){
        for(SANPHAM_DTO sp: listSP)
            if(sp.getMASP()==masp)
                return sp.getTENSP();
        return"";
    }
    
}
