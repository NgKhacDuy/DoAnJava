/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class CTHD_DTO {
    int mahd;
    int masp;
    int soluong;
    int dongia;
    int thanhtien;
    Date ngaylap;

    public CTHD_DTO(int mahd, int masp, int soluong, int dongia, int thanhtien, Date ngaylap) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.ngaylap = ngaylap;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public CTHD_DTO() {
    }

    
}
