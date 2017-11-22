/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vin
 */
public class m_login {

    public static String status;
    public static String username;
    public String status_user = "";
    private koneksi kon;

    public m_login() throws SQLException {
        super();
        kon = new koneksi("root", "", "db_trpl");
//        this.kon = new Koneksi("root","","perikanan");
    }

    public void Login(String user, String pass) throws SQLException {
        String query = "select * from tb_user where username = '" + user + "' and password = '" + pass + "'";
        ResultSet rs = kon.getResult(query);
        if (rs.next()) {
            username = user;
//            id_user = rs.getString("id_member");
            status_user = rs.getString("status");
//            status = "valid";
        } else {
//            status = "tidak valid";
        }
    }

    public String getStatus() {
        return status;
    }

    public String getStatusUser() {
        return status_user;
    }
}
