/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Gaara
 */
public class Sach {
    private String maSach;
    private String tenSach;
    private String tenTacGia;
    private String nhaXB;
    private String nhaCC;
    private String hinhthuc;
    private int giaTien;
    private int soLuong;
    
    public Sach() {
        
    }
    
    public Sach(String maSach, String tenSach, String tenTacGia, String nhaXB,String nhaCC,String hinhthuc, int soLuong, int giaTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.nhaXB = nhaXB;
        this.nhaCC= nhaCC;
        this.hinhthuc= hinhthuc;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        
    }
    
    public String getMaSach() {
        return maSach;
    }
    
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    
    public String getTenSach() {
        return tenSach;
    }
    
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    
    public String getTenTacGia() {
        return tenTacGia;
    }
    
    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
    
    public String getNhaXB() {
        return nhaXB;
    }
    
    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }
    
    public String getNhaCC() {
        return nhaCC;
    }
    
    public void setNhaCC(String nhaCC) {
        this.nhaCC = nhaCC;
    }
    
    public String getHinhthuc() {
        return hinhthuc;
    }
    
    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc= hinhthuc;
    }
    
    public int getGiaTien() {
        return giaTien;
    }
    
    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
