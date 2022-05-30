/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class KHUYENMAI_DTO {
    String ctkm;
    int makh;
    int giamgia;

    public String getCtkm() {
        return ctkm;
    }

    public void setCtkm(String ctkm) {
        this.ctkm = ctkm;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public KHUYENMAI_DTO(String ctkm, int makh, int giamgia) {
        this.ctkm = ctkm;
        this.makh = makh;
        this.giamgia = giamgia;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    

    public KHUYENMAI_DTO() {
    }
}
