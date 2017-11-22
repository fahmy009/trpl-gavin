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
public class m_daftar extends modelInheritance{
    
    private final koneksi kon;

    public m_daftar() throws SQLException{
        super();
        kon = new koneksi("root", "", "db_trpl");
    }
    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id_User", "Nama User","Alamat", "Jenis Kelamin", "Status", "Username", "Password"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from tb_user";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[7];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    @Override
    public boolean delete(String query) throws SQLException {
        String queries = "DELETE FROM tb_user WHERE id_user='" + query + "'";
        return super.delete(queries); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String query) throws SQLException {
        String queries = "UPDATE tb_user SET " + query;
        return super.update(queries); //To change body of ge nerated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(String query) throws SQLException {
        String queries = "INSERT INTO tb_user VALUES (" + query + ")";
        return super.save(queries); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet check(String Username, String Password) throws SQLException {
        String query = "SELECT * FROM tb_user WHERE username='" + Username + "' AND password='" + Password + "'";
        ResultSet Result = kon.getResult(query);
        return Result;
    }
}
