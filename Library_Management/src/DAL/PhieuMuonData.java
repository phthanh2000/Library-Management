/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.PhieuMuon;
import GUI.JFramePhieuMuon;
import static GUI.JFramePhieuMuon.ps;
import static GUI.JFramePhieuMuon.ps2;
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
public class PhieuMuonData {
    public static PreparedStatement ps;
            
    public static PreparedStatement ps2;        

    public static ResultSet rs;

    public static Connect conn;

    public static ArrayList<PhieuMuon> getListpm() {

        ArrayList<PhieuMuon> ListPM = new ArrayList<PhieuMuon>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM phieu_muon order by Ma_Phieu_muon asc");
            rs = ps.executeQuery();
            PhieuMuon pm;
            while (rs.next()) {
                pm = new PhieuMuon(rs.getString("Ma_Phieu_muon"), rs.getString("Ma_Khach_hang"),rs.getString("Ma_Sach"), rs.getDate("Ngay_muon"), rs.getDate("Han_tra"));
                ListPM.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPM;
    }

    public static ArrayList<PhieuMuon> ListPM(String maMuon) {
        ArrayList<PhieuMuon> list = new ArrayList<PhieuMuon>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM phieu_muon where Ma_Phieu_muon = '" + JFramePhieuMuon.txt7.getText() + "'");
            rs = ps.executeQuery();

            PhieuMuon pm;
            while (rs.next()) {
                pm = new PhieuMuon(
                        rs.getString("Ma_Phieu_muon"),
                        rs.getString("Ma_Khach_hang"),
                        rs.getString("Ma_Sach"),
                        rs.getDate("Ngay_muon"),
                        rs.getDate("Han_tra")
                );
                list.add(pm);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<PhieuMuon> addPM(String maMuon) {
        ArrayList<PhieuMuon> list = new ArrayList<PhieuMuon>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `phieu_muon`"
                    + "(`Ma_Phieu_muon`, `Ma_Khach_hang`, `Ma_sach`, `Ngay_muon`, `Han_tra`)"
                    + "VALUES ('" + JFramePhieuMuon.txt1.getText() + "','" + JFramePhieuMuon.txt2.getText() + "','" + JFramePhieuMuon.txt3.getText() + "','" + Date.valueOf(JFramePhieuMuon.txt4.getText()) + "','" + Date.valueOf(JFramePhieuMuon.txt5.getText()) + "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFramePhieuMuon.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<PhieuMuon> deletePM(String maMuon) {
        ArrayList<PhieuMuon> list = new ArrayList<PhieuMuon>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `phieu_muon` where Ma_Phieu_muon = '" + JFramePhieuMuon.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFramePhieuMuon.txt2.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");

        }

        return list;
    }

    public static ArrayList<PhieuMuon> updatePM(String maMuon) {
        ArrayList<PhieuMuon> list = new ArrayList<PhieuMuon>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `phieu_muon` SET `Ma_Khach_Hang`='" + JFramePhieuMuon.txt2.getText() + "',`Ma_Phieu_Muon`='" + JFramePhieuMuon.txt1.getText() + "',`Ma_sach`='" + JFramePhieuMuon.txt3.getText() + "',`Ngay_muon`='" + Date.valueOf(JFramePhieuMuon.txt4.getText()) + "',`Han_tra`='" +Date.valueOf(JFramePhieuMuon.txt5.getText()) + "' WHERE Ma_Phieu_muon = '" + maMuon+ "'");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sửa thành công !! ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }
    public static void sreachPM (String sql,JTable tb) {
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
