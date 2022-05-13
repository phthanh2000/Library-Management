/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.KhachHangData;
import DAL.Search;
import DTO.KhachHang;
import GUI.JFrameKhachHang;
import GUI.JFrameThongKe;
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
public class KhachHangBLL {
    public static void show_info() {
        ArrayList<KhachHang> list = KhachHangData.getListkh();
        DefaultTableModel model = (DefaultTableModel) JFrameKhachHang.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaKH();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getNgaySinh();
            row[3] = list.get(i).getDiaChi();
            row[4] = list.get(i).getSdt();

            model.addRow(row);
        }
        JFrameKhachHang.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFrameKhachHang.txt1.setEnabled(false);
        int selectedRow = JFrameKhachHang.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameKhachHang.tb1.getModel();
        JFrameKhachHang.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameKhachHang.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameKhachHang.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameKhachHang.txt4.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameKhachHang.txt5.setText(model.getValueAt(selectedRow, 4).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameKhachHang.txt1.setText(null);
        JFrameKhachHang.txt2.setText(null);
        JFrameKhachHang.txt3.setText(null);
        JFrameKhachHang.txt4.setText(null);
        JFrameKhachHang.txt5.setText(null);
        JFrameKhachHang.txt1.setEnabled(true);
        }
    public static void addKH() {
        ArrayList<KhachHang> khachhang = KhachHangData.addKH(JFrameKhachHang.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameKhachHang.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteKH() {
        ArrayList<KhachHang> khachhang = KhachHangData.deleteKH(JFrameKhachHang.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameKhachHang.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateKH() {
        ArrayList<KhachHang> khachhang = KhachHangData.updateKH(JFrameKhachHang.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameKhachHang.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachKH()
    {
        if(JFrameKhachHang.txt6.getText().length() == 0) {
            String sql1 = "SELECT * from khach_hang ";
            Search.LoadData(sql1, JFrameKhachHang.tb2);
        }
        else {
            String sql1 = "SELECT * from khach_hang WHERE Ma_Khach_hang like N'%"+JFrameKhachHang.txt6.getText()+"%' "+ "or Ten_Khach_hang like N'%"+JFrameKhachHang.txt6.getText()+"%'";
            Search.LoadData(sql1, JFrameKhachHang.tb2);
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
                DefaultTableModel model = (DefaultTableModel) JFrameKhachHang.tb1.getModel();
                // ten Cot
                for (int j = 0; j < JFrameKhachHang.tb1.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFrameKhachHang.tb1.getRowCount(); j++) {
                    for (int k = 0; k < JFrameKhachHang.tb1.getColumnCount(); k++) {
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
