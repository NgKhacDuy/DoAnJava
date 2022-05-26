/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author HP
 */
public class KHUYENMAI {
   public String CTKM;
   public int MAKH;
   public int MASP;

    public KHUYENMAI() {
    }

    public KHUYENMAI(String CTKM, int MAKH, int MASP) {
        this.CTKM = CTKM;
        this.MAKH = MAKH;
        this.MASP = MASP;
    }

    public String getCTKM() {
        return CTKM;
    }

    public void setCTKM(String CTKM) {
        this.CTKM = CTKM;
    }

    public int getMAKH() {
        return MAKH;
    }

    public void setMAKH(int MAKH) {
        this.MAKH = MAKH;
    }

    public int getMASP() {
        return MASP;
    }

    public void setMASP(int MASP) {
        this.MASP = MASP;
    }
}
        

