    package BLL;

import DAL.PhieuMuonData;
import static DAL.PhieuMuonData.ps;
import static DAL.PhieuMuonData.ps2;
import DAL.Search;
import DTO.PhieuMuon;
import GUI.JFramePhieuMuon;
import Utils.Connect;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author F
 */
public class PhieuMuonBLL {
    public static void show_info() {
        ArrayList<PhieuMuon> list = PhieuMuonData.getListpm();
        DefaultTableModel model = (DefaultTableModel) JFramePhieuMuon.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaMuon();
            row[1] = list.get(i).getMaKhach();
            row[2] = list.get(i).getMaSach();
            row[3] = list.get(i).getNgayMuon();
            row[4] = list.get(i).getHanTra();

            model.addRow(row);
        }
        JFramePhieuMuon.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFramePhieuMuon.txt1.setEnabled(false);
        int selectedRow = JFramePhieuMuon.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFramePhieuMuon.tb1.getModel();
        JFramePhieuMuon.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFramePhieuMuon.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFramePhieuMuon.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFramePhieuMuon.txt4.setText(model.getValueAt(selectedRow, 3).toString());
        JFramePhieuMuon.txt5.setText(model.getValueAt(selectedRow, 4).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFramePhieuMuon.txt1.setText(null);
        JFramePhieuMuon.txt2.setText(null);
        JFramePhieuMuon.txt3.setText(null);
        JFramePhieuMuon.txt4.setText(null);
        JFramePhieuMuon.txt5.setText(null);
        JFramePhieuMuon.txt1.setEnabled(true);
        }
    public static void addPM() {
        ArrayList<PhieuMuon> phieumuon = PhieuMuonData.addPM(JFramePhieuMuon.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFramePhieuMuon.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deletePM() {
        ArrayList<PhieuMuon> phieumuon = PhieuMuonData.deletePM(JFramePhieuMuon.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFramePhieuMuon.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updatePM() {
        ArrayList<PhieuMuon> phieumuon = PhieuMuonData.updatePM(JFramePhieuMuon.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFramePhieuMuon.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachPM()
    {
        if(JFramePhieuMuon.txt7.getText().length() == 0) {
            String sql1 = "SELECT * from phieu_muon ";
            Search.LoadData(sql1, JFramePhieuMuon.tb2);
        }
        else {
            String sql1 = "SELECT * from phieu_muon WHERE Ma_Phieu_muon like N'%"+JFramePhieuMuon.txt7.getText()+"%' ";
            Search.LoadData(sql1, JFramePhieuMuon.tb2);
        }
    }
    public static void returnPM (){
        String sql = "UPDATE sach SET So_luong = ? where Ma_Sach = ?";
        String sql1 = "SELECT So_luong FROM sach where Ma_Sach = '"+JFramePhieuMuon.txt2.getText()+"'";
        String sql2 = "UPDATE phieu_muon SET Han_tra = (select CURDATE()) where Ma_Phieu_muon = ?";
        
        
        try {
            ps2 = Connect.getConnect().prepareStatement(sql2);
            ps2.setString(1, JFramePhieuMuon.txt1.getText());
            ps2.executeQuery();
            
            ps = Connect.getConnect().prepareStatement(sql);
            ResultSet rs = Search.ShowTextField(sql1);
            ps.setString(2,JFramePhieuMuon.txt2.getText());
            int count = 0;
            if(rs.next()) count = rs.getInt("So_luong");
            
            ps.setInt(1, count+1);
            ps.execute();
        } catch (Exception ex) {
        }
    }
    public static void save1(){
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xls");
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) JFramePhieuMuon.tb1.getModel();
                // ten Cot
                for (int j = 0; j < JFramePhieuMuon.tb1.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFramePhieuMuon.tb1.getRowCount(); j++) {
                    for (int k = 0; k < JFramePhieuMuon.tb1.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
         
    }   
        }
        }
}
