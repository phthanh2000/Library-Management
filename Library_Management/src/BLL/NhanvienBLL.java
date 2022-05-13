/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhanvienData;
import DAL.Search;
import DTO.Nhanvien;
import GUI.JFrameNhanVien;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author F
 */
public class NhanvienBLL {
        public static void show_info() {
        ArrayList<Nhanvien> list = NhanvienData.getListnv();
        DefaultTableModel model = (DefaultTableModel) JFrameNhanVien.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaNV();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getNgaySinh();
            row[3] = list.get(i).getDiaChi();
            row[4] = list.get(i).getSdt();
            model.addRow(row);
        }
        JFrameNhanVien.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFrameNhanVien.txt1.setEnabled(false);
        int selectedRow = JFrameNhanVien.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameNhanVien.tb1.getModel();
        JFrameNhanVien.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameNhanVien.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameNhanVien.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameNhanVien.txt4.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameNhanVien.txt5.setText(model.getValueAt(selectedRow, 4).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameNhanVien.txt1.setText(null);
        JFrameNhanVien.txt2.setText(null);
        JFrameNhanVien.txt3.setText(null);
        JFrameNhanVien.txt4.setText(null);
        JFrameNhanVien.txt5.setText(null);
        JFrameNhanVien.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<Nhanvien> nhanvien = NhanvienData.addStaff(JFrameNhanVien.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhanVien.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<Nhanvien> nhanvien = NhanvienData.deleteStaff(JFrameNhanVien.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhanVien.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateStaff() {
        ArrayList<Nhanvien> nhanvien = NhanvienData.updateStaff(JFrameNhanVien.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhanVien.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachStaff()
    {
        if(JFrameNhanVien.txt8.getText().length() == 0) {
            String sql1 = "SELECT * from nhan_vien ";
            Search.LoadData(sql1, JFrameNhanVien.tb2);
        }
        else {
            String sql1 = "SELECT * from nhan_vien WHERE Ma_Nhan_vien like N'%"+JFrameNhanVien.txt8.getText()+"%' "+ "or Ten_Nhan_vien like N'%"+JFrameNhanVien.txt8.getText()+"%'";
            Search.LoadData(sql1, JFrameNhanVien.tb2);
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
                DefaultTableModel model = (DefaultTableModel) JFrameNhanVien.tb1.getModel();
                // ten Cot
                for (int j = 0; j < JFrameNhanVien.tb1.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFrameNhanVien.tb1.getRowCount(); j++) {
                    for (int k = 0; k < JFrameNhanVien.tb1.getColumnCount(); k++) {
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
