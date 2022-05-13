/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.AdminData;
import DTO.Admin;
import GUI.JFrameChucNang2;
import GUI.JFrameLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author F
 */
public final class AdminBLL {
    public static ResultSet rs = null;
    public static PreparedStatement ps = null;
    public boolean login() {
        String user = JFrameLogin.txt1.getText();
        String pass = String.valueOf(JFrameLogin.txt2.getPassword());
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !", "Error", 1);
        } else {
            AdminData ad = new AdminData().cLog(user, pass);
            try {
                if (ad != null) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "NOTIFICATION", 1);
                    JFrameChucNang2 cn = new JFrameChucNang2();
                    cn.setVisible(true);    
                    cn.setLocationRelativeTo(null);
                    
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại ", "NOTIFICATION", 1);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return false;
    }
}

