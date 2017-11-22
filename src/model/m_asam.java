/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Vin
 */
public class m_asam {
    public koneksi kon;
    public String[] getAsam = new String[4];

    public m_asam() throws SQLException {
        kon = new koneksi("root", "", "db_trpl");
    }

    public void Keasaman(int id) throws SQLException {
        String query = "Select * from tb_asam where id_asam  = " + id;
        ResultSet rs = kon.getResult(query);
        while (rs.next()) {
            for (int i = 1; i < getAsam.length + 1; i++) {
                getAsam[i - 1] = rs.getString(i);
            }
        }
    }

    public String getStatus() {
        return getAsam[2];
    }

    public String getTindakan() {
        return getAsam[3];
    }
   
}
