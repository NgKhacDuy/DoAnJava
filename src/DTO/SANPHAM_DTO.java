/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class SANPHAM_DTO {
    private int MASP;
    private String TENSP;
    private int GIA;
    private String SIZE;
    private int SOLUONG;

    public SANPHAM_DTO(int MASP, String TENSP, int GIA, String SIZE, int SOLUONG) {
        this.MASP = MASP;
        this.TENSP = TENSP;
        this.GIA = GIA;
        this.SIZE = SIZE;
        this.SOLUONG = SOLUONG;
    }

    public int getMASP() {
        return MASP;
    }

    public void setMASP(int MASP) {
        this.MASP = MASP;
    }

    public String getTENSP() {
        return TENSP;
    }

    public void setTENSP(String TENSP) {
        this.TENSP = TENSP;
    }

    public int getGIA() {
        return GIA;
    }

    public void setGIA(int GIA) {
        this.GIA = GIA;
    }

    public String getSIZE() {
        return SIZE;
    }

    public void setSIZE(String SIZE) {
        this.SIZE = SIZE;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public SANPHAM_DTO() {
    }

    
    
}
