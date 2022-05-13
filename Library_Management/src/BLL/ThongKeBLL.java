/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Search;
import GUI.JFrameThongKe;
import Utils.Connect;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.util.ArrayList;

/**
 *
 * @author F
 */
public class ThongKeBLL {
    public static PreparedStatement ps ;
    public static ResultSet rs ;
    public static String sql = "SELECT * FROM phieu_muon where Han_tra < (select CURDATE())";
    public static Connection con = Connect.getConnect();
    public JTextArea getTa() {
        return JFrameThongKe.taBaoCao;
    }
    public JButton inbc() {
        return JFrameThongKe.jButton2;
    }
    public static void thongke(){
        Search.LoadData(sql, JFrameThongKe.jTable1);
        try{
            String sql1 = "SELECT SUM(So_luong) as sach FROM sach";
            String sql2 = "SELECT COUNT(Ma_Khach_hang) as khachhang FROM khach_hang";
            String sql3 = "SELECT COUNT(Ma_Phieu_muon) as phieumuon FROM phieu_muon";
            String sql4 = "SELECT COUNT(DISTINCT Ma_Khach_hang) as khachmuon FROM phieu_muon";
            //String sql5 = "SELECT COUNT(Ma_Phieu_muon) as phieumuon FROM phieu_muon where (Han_tra < (select CURDATE()) and Han_tra IS NULL)";
            ResultSet rs1 = Search.ShowTextField(sql1);
            ResultSet rs2 = Search.ShowTextField(sql2);
            ResultSet rs3 = Search.ShowTextField(sql3);
            ResultSet rs4 = Search.ShowTextField(sql4);
            //ResultSet rs5 = Search.ShowTextField(sql5);
            
            if(rs1.next()) JFrameThongKe.jLabel2.setText("Tong so sach : "+Integer.toString(rs1.getInt("sach")));
            if(rs2.next()) JFrameThongKe.jLabel1.setText("Tong so khach hang: " + Integer.toString(rs2.getInt("khachhang")));
            if(rs3.next()) JFrameThongKe.jLabel3.setText("Tổng so phieu muon: "+Integer.toString(rs3.getInt("phieumuon")));
            if(rs4.next()) JFrameThongKe.jLabel4.setText("Tổng so khach hang dang muon: "+Integer.toString(rs4.getInt("khachmuon")));
            //if(rs5.next()) this.jLabel5.setText("Tổng số phiếu quá hạn là: "+Integer.toString(rs5.getInt("phieumuon")));
            
        }catch(Exception e) {
            
        }
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JFrameThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        List l = null;
        l=DbUtils.resultSetToNestedList(rs);
        JFrameThongKe.taBaoCao.append(JFrameThongKe.jLabel2.getText()+"\n");
        JFrameThongKe.taBaoCao.append(JFrameThongKe.jLabel1.getText()+"\n");
        JFrameThongKe.taBaoCao.append(JFrameThongKe.jLabel3.getText()+"\n");
        JFrameThongKe.taBaoCao.append(JFrameThongKe.jLabel4.getText()+"\n\n");
        //this.taBaoCao.append(this.jLabel5.getText()+"\n\n");
        JFrameThongKe.taBaoCao.append("| Ma Phieu Muon | Ma Khach Hang | Ma Sach | Ngay Muon | Han Tra |\n");
        for(int i=1;i <= l.size();i++)
        JFrameThongKe.taBaoCao.append(l.get(1).toString()+"\n");
        
    }
    public static void save(){
                try {
            JFileChooser jfc = new JFileChooser("Save");
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String content = JFrameThongKe.taBaoCao.getText();
                jfc.setDialogTitle("Save File");
                FileOutputStream fos = new FileOutputStream(jfc.getSelectedFile()+".xls");
                fos.write(content.getBytes());
                fos.flush();
                fos.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công");
            }

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
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
                DefaultTableModel model = (DefaultTableModel) JFrameThongKe.jTable1.getModel();
                // ten Cot
                for (int j = 0; j < JFrameThongKe.jTable1.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFrameThongKe.jTable1.getRowCount(); j++) {
                    for (int k = 0; k < JFrameThongKe.jTable1.getColumnCount(); k++) {
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