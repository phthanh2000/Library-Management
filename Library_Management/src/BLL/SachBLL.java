/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.SachData;
import DAL.Search;
import DTO.Sach;
import GUI.JFrameSach;
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
public class SachBLL {
     public static void show_info() {
        ArrayList<Sach> list = SachData.getLists();
        DefaultTableModel model = (DefaultTableModel) JFrameSach.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[8];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaSach();
            row[1] = list.get(i).getTenSach();
            row[2] = list.get(i).getTenTacGia();
            row[3] = list.get(i).getNhaXB();
            row[4] = list.get(i).getNhaCC();
            row[5] = list.get(i).getHinhthuc();
            row[6] = list.get(i).getSoLuong();
            row[7] = list.get(i).getGiaTien();
            model.addRow(row);
        }
        JFrameSach.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFrameSach.txt1.setEnabled(false);
        int selectedRow = JFrameSach.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameSach.tb1.getModel();
        JFrameSach.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameSach.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameSach.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameSach.txt4.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameSach.txt5.setText(model.getValueAt(selectedRow, 4).toString());
        JFrameSach.txt6.setText(model.getValueAt(selectedRow, 5).toString());
        JFrameSach.txt7.setText(model.getValueAt(selectedRow, 6).toString());
        JFrameSach.txt8.setText(model.getValueAt(selectedRow, 7).toString());
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameSach.txt1.setText(null);
        JFrameSach.txt2.setText(null);
        JFrameSach.txt3.setText(null);
        JFrameSach.txt4.setText(null);
        JFrameSach.txt5.setText(null);
        JFrameSach.txt6.setText(null);
        JFrameSach.txt7.setText(null);
        JFrameSach.txt1.setEnabled(true);
        JFrameSach.txt8.setText(null);

    }
    public static void addS() {
        ArrayList<Sach> sach = SachData.addS(JFrameSach.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameSach.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteS() {
        ArrayList<Sach> sach = SachData.deleteS(JFrameSach.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameSach.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateS() {
        ArrayList<Sach> sach = SachData.updateS(JFrameSach.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameSach.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachS()
    {
        if(JFrameSach.txt8.getText().length() == 0) {
            String sql1 = "SELECT * from sach ";
            Search.LoadData(sql1, JFrameSach.tb2);
        }
        else {
            String sql1 = "SELECT * from sach WHERE Ma_Sach like N'%"+JFrameSach.txt9.getText()+"%' "+ "or Ten_Tac_gia like N'%"+JFrameSach.txt9.getText()+"%'";
            Search.LoadData(sql1, JFrameSach.tb2);
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
                DefaultTableModel model = (DefaultTableModel) JFrameSach.tb1.getModel();
                // ten Cot
                for (int j = 0; j < JFrameSach.tb1.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFrameSach.tb1.getRowCount(); j++) {
                    for (int k = 0; k < JFrameSach.tb1.getColumnCount(); k++) {
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
