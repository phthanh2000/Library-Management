/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
//import static DAL.KhachHangData.ps;
import Utils.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gaara
 */
public class AdminData {
    public static ResultSet rs;
    public static PreparedStatement ps;

    public static AdminData cLog(String maAdmin, String password) {
        AdminData con = null;
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM quan_tri where Ma_Admin = ? and Password = ? ");
            ps.setString(1, maAdmin);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next()) {
                con = new AdminData();
            }

        } catch (Exception e) {
            return con = null;
        }
        return con;
    }
}
