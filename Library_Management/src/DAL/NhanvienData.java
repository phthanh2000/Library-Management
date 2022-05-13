/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.Nhanvien;
import GUI.JFrameNhanVien;
import Utils.Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;

/**
 *
 * @author Gaara
 */
public class NhanvienData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;

    public static ArrayList<Nhanvien> getListnv() {

        ArrayList<Nhanvien> ListNV = new ArrayList<Nhanvien>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM nhan_vien order by Ma_nhan_vien asc");
            rs = ps.executeQuery();
            Nhanvien nv;
            while (rs.next()) {
                nv = new Nhanvien(rs.getString("Ma_Nhan_vien"), rs.getString("Ten_Nhan_vien"), rs.getDate("Ngay_sinh"), rs.getString("Dia_chi"), rs.getString("Phone"));
                ListNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListNV;
    }

    public static ArrayList<Nhanvien> ListNV(String manv) {
        ArrayList<Nhanvien> list = new ArrayList<Nhanvien>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM nhan_vien where Ma_Nhan_vien = '" + JFrameNhanVien.txt8.getText() + "'");
            rs = ps.executeQuery();

            Nhanvien nv;
            while (rs.next()) {
                nv = new Nhanvien(
                        rs.getString("Ma_Nhan_vien"),
                        rs.getString("Ten_Nhan_vien"),
                        rs.getDate("Ngay_sinh"),
                        rs.getString("Dia_chi"),
                        rs.getString("Phone")

                );
                list.add(nv);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<Nhanvien> addStaff(String manv) {
        ArrayList<Nhanvien> list = new ArrayList<Nhanvien>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `nhan_vien`"
                    + "(`Ma_Nhan_vien`, `Ten_Nhan_vien`, `Ngay_sinh`, `Dia_chi`, `Phone`)"
                    + "VALUES ('" + JFrameNhanVien.txt1.getText() + "','" + JFrameNhanVien.txt2.getText() + "','" + Date.valueOf(JFrameNhanVien.txt3.getText()) + "','" + JFrameNhanVien.txt4.getText() + "','" + JFrameNhanVien.txt5.getText()+ "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFrameNhanVien.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<Nhanvien> deleteStaff(String manv) {
        ArrayList<Nhanvien> list = new ArrayList<Nhanvien>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `nhan_vien` where Ma_nhan_vien = '" + JFrameNhanVien.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFrameNhanVien.txt2.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");

        }

        return list;
    }

    public static ArrayList<Nhanvien> updateStaff(String manv) {
        ArrayList<Nhanvien> list = new ArrayList<Nhanvien>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `nhan_vien` SET `Ten_Nhan_vien`='" + JFrameNhanVien.txt2.getText() + "',`Ma_Nhan_vien`='" + JFrameNhanVien.txt1.getText() + "',`Ngay_sinh`='" + Date.valueOf(JFrameNhanVien.txt3.getText()) + "',`Dia_chi`='" + JFrameNhanVien.txt4.getText() + "',`Phone`='" + JFrameNhanVien.txt5.getText() + "' WHERE Ma_Nhan_vien = '" + manv+ "'");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sửa thành công !! ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }
    public static void sreachStaff (String sql,JTable tb) {
         try{
            ps = (PreparedStatement) Connect.getConnect().prepareStatement(sql);
            rs = ps.executeQuery();
            tb.setModel((DbUtils.resultSetToTableModel(rs)));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e ,"Thông báo lỗi",1);
        }
    }
    
}
