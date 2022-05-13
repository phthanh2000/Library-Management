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
public class Nhanvien {

    private String manv;
    private String name;
    private Date ngaysinh;
    private String diaChi;
    private String sdt;

    
    public Nhanvien() {
        
    }
    public Nhanvien(String manv, String name, Date ngaysinh, String diaChi, String sdt) {
        this.manv = manv;
        this.name = name;
        this.ngaysinh = ngaysinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }
       public String getMaNV() {
        return manv;
    }
    public void setMaNV(String maNV) {
        this.manv = maNV;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getNgaySinh() {
        return ngaysinh;
    }
    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diachi) {
        this.diaChi = diachi;
    }
    
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String Sdt) {
        this.sdt = sdt;
    }

}
