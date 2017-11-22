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
public class m_permintaanGudang extends modelInheritance {

    private koneksi kon;

    public m_permintaanGudang() throws SQLException {
        super();
        kon = new koneksi("root", "", "db_trpl");
    }

    public DefaultTableModel getTableMinta() throws SQLException {
        String header[] = {"Id Pesan", "Cabang", "Sosro", "Fruittea", "Tebs", "S-Tee", "Tanggal"};
        DefaultTableModel tabelModel = new DefaultTableModel(null, header);
        ResultSet rs = kon.getResult("SELECT p.id_permintaan, c.nama_cabang, p.sosro, p.fruittea, p.tebs, p.stee, p.tanggal from tb_permintaanlogistik p join tb_cabang c on p.id_cabang = c.id_cabang");
        for (int i = tabelModel.getRowCount() - 1; i >= 0; i--) {
            tabelModel.removeRow(i);
        }
        while (rs.next()) {
            String kolom[] = new String[7];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

            tabelModel.addRow(kolom);
        }
        return tabelModel;
    }

    public DefaultTableModel getTableStok() throws SQLException {
        String header[] = {"Id Pesan", "Cabang", "Sosro", "Fruittea", "Tebs", "S-Tee", "Tanggal"};
        DefaultTableModel tabelModel = new DefaultTableModel(null, header);
        ResultSet rs = kon.getResult("SELECT p.id_permintaan, c.nama_cabang, p.sosro, p.fruittea, p.tebs, p.stee, p.tanggal from tb_permintaangudang p join tb_cabang c on p.id_cabang = c.id_cabang");
        for (int i = tabelModel.getRowCount() - 1; i >= 0; i--) {
            tabelModel.removeRow(i);
        }
        while (rs.next()) {
            String kolom[] = new String[7];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

            tabelModel.addRow(kolom);
        }
        return tabelModel;
    }

    @Override
    public boolean delete(String query) throws SQLException {
        String queries = "DELETE FROM tb_permintaanlogistik WHERE id_permintaan =" + query;
        return super.delete(queries); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(String query) throws SQLException {
        String queries = "INSERT INTO tb_permintaangudang (id_permintaan, id_cabang, sosro, fruittea, tebs, stee, tanggal)"
                + " SELECT id_permintaan, id_cabang, sosro, fruittea, tebs, stee, tanggal FROM tb_permintaanlogistik where id_permintaan=" + query;
        return super.save(queries); //To change body of generated methods, choose Tools | Templates.
    }

}
