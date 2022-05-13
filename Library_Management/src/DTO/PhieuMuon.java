/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Gaara
 */
public class PhieuMuon {
    private String maMuon;
    private String maKhach;
    private String maSach;
    private Date ngayMuon;
    private Date hanTra;
    
    public PhieuMuon() {
        
    }
    
    public PhieuMuon(String maMuon, String maKhach, String maSach, Date ngayMuon, Date hanTra) {
        this.maMuon = maMuon;
        this.maKhach = maKhach;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
    }
    
    public String getMaMuon() {
        return maMuon;
    }
    public void setMaMuon(String mm) {
        this.maMuon = mm;
    }
    
    public String getMaKhach() {
        return maKhach;
    }
    public void setMaKhach(String maKhach) {
        this.maKhach = maKhach;
    }
    
    public String getMaSach() {
        return maSach;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    
    public Date getNgayMuon() {
        return ngayMuon;
    }
    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }
    public Date getHanTra() {
        return hanTra;
    }
    public void setHanTra(Date hantra) {
        this.hanTra = hantra;
    }
    
    
}
