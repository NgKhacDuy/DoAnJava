/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.LOAISP_DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DTO.LOAISP_DTO;
/**
 *
 * @author DELL
 */
public class LOAISP_BUS {
    private ArrayList<LOAISP_DTO> listLoaiSP=null;
    private LOAISP_DAO loaispDAO = new LOAISP_DAO();
    public LOAISP_BUS(){
        docListLoaiSP();
    }
    public void docListLoaiSP(){
        listLoaiSP=loaispDAO.getlistLoai();
    }
    public ArrayList<LOAISP_DTO> getListLoaiSP(){
        if(listLoaiSP==null);
            docListLoaiSP();
        return listLoaiSP;
    }
    public ArrayList<LOAISP_DTO> getLoaiTheoTen(String ten){
        ArrayList<LOAISP_DTO> dsloaisp=new ArrayList<>();
        for(LOAISP_DTO loaisp : listLoaiSP){
            String tenLoai=loaisp.getTenloaisp().toLowerCase();
            if(tenLoai.toLowerCase().contains(ten))
                dsloaisp.add(loaisp);
        }
        return dsloaisp;
    }
    public ArrayList<LOAISP_DTO> getLoaiTheoMa(String ma){
        ArrayList<LOAISP_DTO> dsloaisp=new ArrayList<>();
        int maLoai=Integer.parseInt(ma);
        for(LOAISP_DTO loaisp : listLoaiSP){
            int maLoai1=loaisp.getMaloaisp();
            if(maLoai1==maLoai)
                dsloaisp.add(loaisp);
        }
        return dsloaisp;
    }
    public boolean themLoai(String ten){
        try {
            LOAISP_DTO loaisp=new LOAISP_DTO();
            loaisp.setTenloaisp(ten);
            if(loaispDAO.themLoaisp(loaisp))
                return true;
            else
                return false;
        } catch (Exception e) {
        }
        return false;
    }
    public boolean xoaLoai(String ma){
        if(ma.trim().equals("")){
            return false;
        }
        int maloai=Integer.parseInt(ma);
        if(loaispDAO.xoaLoaiSP(maloai)){
            return true;
        }
        return false;
    }   
    public boolean suaLoai(String ma,String ten){
        try {
            int maloai=Integer.parseInt(ma);
            LOAISP_DTO loaisp = new LOAISP_DTO();
            loaisp.setMaloaisp(maloai);
            loaisp.setTenloaisp(ten);
            if(loaispDAO.suaLoaiSP(loaisp)){
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
