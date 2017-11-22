/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vin
 */
public class koneksi {

    private Connection conn;
    private Statement stm;

    public koneksi(String username, String password, String db) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/" + db;
        conn = (Connection) DriverManager.getConnection(url, username, password);
        stm = (Statement) conn.createStatement();
    }

    public void execute(String sql) throws SQLException {
        stm.executeUpdate(sql);
    }

    public ResultSet getResult(String sql) throws SQLException {
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }

    public void close() throws SQLException {
        conn.close();
    }
}
