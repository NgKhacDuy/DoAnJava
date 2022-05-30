/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class HOADON_DTO {
    int mahd;
    int makh;
    double tongtien;
    int manv;
    double giamgia;

    public HOADON_DTO() {
    }

    public HOADON_DTO(int mahd, int makh, double tongtien, int manv, double giamgia) {
        this.mahd = mahd;
        this.makh = makh;
        this.tongtien = tongtien;
        this.manv = manv;
        this.giamgia = giamgia;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public double getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(double giamgia) {
        this.giamgia = giamgia;
    }

    
    
}
