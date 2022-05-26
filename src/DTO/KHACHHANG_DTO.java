/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author HP
 */
public class KHACHHANG_DTO {
public int MAKH;
public String TENKH;
public String SDT;

public KHACHHANG_DTO(){
}
public KHACHHANG_DTO(int MAKH, String TENKH, String SDT){
    this.MAKH= MAKH;
    this.TENKH= TENKH;
    this.SDT= SDT;
}
public int getMAKH(){
    return MAKH;
}
public void setMAKH(int MAKH){
    this.MAKH=MAKH;
}
public String getTENKH(){
    return TENKH;
}
public void setTENKH(String TENKH){
    this.TENKH= TENKH;
}
public String getSDT(){
    return SDT;
}
public void setSDT(String SDT){
    this.SDT= SDT;
}
}
