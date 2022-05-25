/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class LOAISP_DTO {
    int maloaisp;
    String tenloaisp;

    public LOAISP_DTO(int maloaisp, String tenloaisp) {
        this.maloaisp = maloaisp;
        this.tenloaisp = tenloaisp;
    }

    public LOAISP_DTO() {
    }

    public int getMaloaisp() {
        return maloaisp;
    }

    public void setMaloaisp(int maloaisp) {
        this.maloaisp = maloaisp;
    }

    public String getTenloaisp() {
        return tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        this.tenloaisp = tenloaisp;
    }
}
