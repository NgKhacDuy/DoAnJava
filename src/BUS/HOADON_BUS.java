/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HOADON_DAO;
import DTO.HOADON_DTO;
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
}
