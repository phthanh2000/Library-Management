/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhachHang;
import GUI.JFrameKhachHang;
import Utils.Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Gaara
 */
public class KhachHangData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;

    public static ArrayList<KhachHang> getListkh() {

        ArrayList<KhachHang> ListKH = new ArrayList<KhachHang>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM khach_hang order by Ma_Khach_hang asc");
            rs = ps.executeQuery();
            KhachHang kh;
            while (rs.next()) {
                kh = new KhachHang(rs.getString("Ma_Khach_hang"), rs.getString("Ten_Khach_hang"), rs.getDate("Ngay_sinh"), rs.getString("Dia_chi"), rs.getString("Phone"));
                ListKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKH;
    }

    public static ArrayList<KhachHang> ListKH(String maKhachHang) {
        ArrayList<KhachHang> list = new ArrayList<KhachHang>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM khach_hang where Ma_Khach_hang = '" + JFrameKhachHang.txt6.getText() + "'");
            rs = ps.executeQuery();

            KhachHang kh;
            while (rs.next()) {
                kh = new KhachHang(
                        rs.getString("Ma_Khach_hang"),
                        rs.getString("Ten_Khach_hang"),
                        rs.getDate("Ngay_sinh"),
                        rs.getString("Dia_chi"),
                        rs.getString("Phone")
                );
                list.add(kh);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<KhachHang> addKH(String maKhachHang) {
        ArrayList<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `khach_hang`"
                    + "(`Ma_Khach_hang`, `Ten_Khach_hang`, `Ngay_sinh`, `Dia_chi`, `Phone`)"
                    + "VALUES ('" + JFrameKhachHang.txt1.getText() + "','" + JFrameKhachHang.txt2.getText() + "','" + Date.valueOf(JFrameKhachHang.txt3.getText()) + "','" + JFrameKhachHang.txt4.getText() + "','" + JFrameKhachHang.txt5.getText() + "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFrameKhachHang.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<KhachHang> deleteKH(String maKhachHang) {
        ArrayList<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `khach_hang` where Ma_Khach_hang = '" + JFrameKhachHang.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFrameKhachHang.txt2.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");

        }

        return list;
    }

    public static ArrayList<KhachHang> updateKH(String maKhachHang) {
        ArrayList<KhachHang> list = new ArrayList<KhachHang>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `khach_hang` SET `Ten_Khach_hang`='" + JFrameKhachHang.txt2.getText() + "',`Ma_Khach_hang`='" + JFrameKhachHang.txt1.getText() + "',`Ngay_sinh`='" + Date.valueOf(JFrameKhachHang.txt3.getText()) + "',`Dia_chi`='" + JFrameKhachHang.txt4.getText() + "',`Phone`='" + JFrameKhachHang.txt5.getText() + "' WHERE Ma_Khach_hang = '" + maKhachHang+ "'");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sửa thành công !! ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }
    public static void sreachKH (String sql,JTable tb) {
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
    
