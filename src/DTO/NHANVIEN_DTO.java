package DTO;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author BUI YEN NHI
 */
public class NHANVIEN_DTO {
    public int MANV;
    public String TENNV;
    public String NGAYSINH ;
    public String DIACHI;
    public String SDT;
    public String CHUCVU;
    public String CALAM;

    public NHANVIEN_DTO(int MANV, String TENNV, String NGAYSINH, String DIACHI, String SDT, String CHUCVU, String CALAM) {
        this.MANV = MANV;
        this.TENNV = TENNV;
        this.NGAYSINH = NGAYSINH;
        this.DIACHI = DIACHI;
        this.SDT = SDT;
        this.CHUCVU = CHUCVU;
        this.CALAM = CALAM;
    }

    public int getMANV() {
        return MANV;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public String getTENNV() {
        return TENNV;
    }

    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCHUCVU() {
        return CHUCVU;
    }

    public void setCHUCVU(String CHUCVU) {
        this.CHUCVU = CHUCVU;
    }

    public String getCALAM() {
        return CALAM;
    }

    public void setCALAM(String CALAM) {
        this.CALAM = CALAM;
    }

    public NHANVIEN_DTO() {
    }

    

    

    
    
           
    
}
