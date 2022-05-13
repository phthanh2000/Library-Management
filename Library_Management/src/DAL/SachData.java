/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.Sach;
import GUI.JFrameSach;
import Utils.Connect;
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
public class SachData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;

    public static ArrayList<Sach> getLists() {

        ArrayList<Sach> ListS = new ArrayList<Sach>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM sach order by Ma_Sach asc");
            rs = ps.executeQuery();
            Sach s;
            while (rs.next()) {
                s = new Sach(rs.getString("Ma_Sach"), rs.getString("Ten_Sach"), rs.getString("Ten_Tac_gia"), rs.getString("Nha_xb"), rs.getString("Nha_cc"), rs.getString("Hinh_thuc"), rs.getInt("So_luong"), rs.getInt("Gia_tien"));
                ListS.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListS;
    }

    public static ArrayList<Sach> ListS(String maSach) {
        ArrayList<Sach> list = new ArrayList<Sach>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM sach where Ma_Sach = '" + JFrameSach.txt9.getText() + "')");
            rs = ps.executeQuery();

            Sach s;
            while (rs.next()) {
                s = new Sach(
                        rs.getString("Ma_Sach"),
                        rs.getString("Ten_Sach"),
                        rs.getString("Ten_Tac_gia"),
                        rs.getString("Nha_xb"),
                        rs.getString("Nha_cc"),
                        rs.getString("Hinh_thuc"),
                        rs.getInt("So_luong"),
                        rs.getInt("Gia_tien")
                );
                list.add(s);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<Sach> addS(String maSach) {
        ArrayList<Sach> list = new ArrayList<Sach>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `sach`"
                    + "(`Ma_Sach`, `Ten_Sach`, `Ten_Tac_gia`, `Nha_xb`, `Nha_cc`, `Hinh_thuc`,  `So_luong`, `Gia_tien`)"
                    + "VALUES ('" + JFrameSach.txt1.getText() + "','" + JFrameSach.txt2.getText() + "','" + JFrameSach.txt3.getText() + "','" + JFrameSach.txt4.getText() + "','" + JFrameSach.txt5.getText() + "','" + JFrameSach.txt6.getText() + "','" + Integer.parseInt(JFrameSach.txt7.getText()) + "','" + Integer.parseInt(JFrameSach.txt8.getText()) + "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFrameSach.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<Sach> deleteS(String maSach) {
        ArrayList<Sach> list = new ArrayList<Sach>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `sach` where Ma_Sach = '" + JFrameSach.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFrameSach.txt2.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");

        }

        return list;
    }

    public static ArrayList<Sach> updateS(String maSach) {
        ArrayList<Sach> list = new ArrayList<Sach>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `sach` SET `Ma_Sach`='" + JFrameSach.txt1.getText() + "',`Ten_Sach`='" + JFrameSach.txt2.getText() + "',`Ten_Tac_gia`='" + JFrameSach.txt3.getText() + "',`Nha_xb`='" + JFrameSach.txt4.getText() + "',`Nha_cc`='" + JFrameSach.txt5.getText() + "',`Hinh_thuc`='" + JFrameSach.txt6.getText() + "',`So_luong`='" + Integer.parseInt(JFrameSach.txt7.getText()) + "',`Gia_tien`='" + Integer.parseInt(JFrameSach.txt8.getText())+ "' WHERE Ma_Sach = '" + maSach + "'");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sửa thành công !! ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }
    public static void sreachS (String sql,JTable tb) {
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
