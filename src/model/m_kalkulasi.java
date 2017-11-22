/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vin
 */
public class m_kalkulasi {

    public koneksi kon;
    public String[] getKalkulasi = new String[3];

    public m_kalkulasi() throws SQLException {
        super();
        kon = new koneksi("root", "", "db_trpl");
    }

    public void Kalkulasi(int id) throws SQLException {
        String query = "Select * from tb_mutu where id_mutu= " + id;
        ResultSet rs = kon.getResult(query);
        while (rs.next()) {
            for (int i = 1; i < getKalkulasi.length + 1; i++) {
                getKalkulasi[i - 1] = rs.getString(i);
            }
        }
    }

    public String getStatus() {
        return getKalkulasi[2];
    }

}
