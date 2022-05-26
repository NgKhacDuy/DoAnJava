/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author HP
 */
public class KHACHHANG {
public int MAKH;
public String TEN;
public int SDT;

public KHACHHANG(){
}
public KHACHHANG(int MAKH, String TEN, int SDT){
    this.MAKH= MAKH;
    this.TEN= TEN;
    this.SDT= SDT;
}
public int getMAKH(){
    return MAKH;
}
public void setMAKH(int MAKH){
    this.MAKH=MAKH;
}
public String getTEN(){
    return TEN;
}
public void setTEN(String TEN){
    this.TEN= TEN;
}
public int getSDT(){
    return SDT;
}
public void setSDT(int SDT){
    this.SDT= SDT;
}
}
