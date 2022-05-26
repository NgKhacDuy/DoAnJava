/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author BUI YEN NHI
 */
public class NHACC_DTO {
    public int MANHACC;
    public String TENNCC;
    public String DIACHI;
    public String SDT;

    public int getMANHACC() {
        return MANHACC;
    }

    public void setMANHACC(int MANHACC) {
        this.MANHACC = MANHACC;
    }

    public String getTENNCC() {
        return TENNCC;
    }

    public void setTENNCC(String TENNCC) {
        this.TENNCC = TENNCC;
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
    public NHACC_DTO(int MANHACC,String TENNCC,String DIACHI,String SHT){
            this.MANHACC=MANHACC;
            this.TENNCC=TENNCC;
            this.DIACHI=DIACHI;
            this.SDT=SDT;
}
    
}
