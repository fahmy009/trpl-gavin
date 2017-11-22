/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.c_permintaanLogistik;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vin
 */
public class m_permintaanLogistik extends modelInheritance {

    private koneksi kon;

    public m_permintaanLogistik() throws SQLException {
        super();
        kon = new koneksi("root", "", "db_trpl");
    }

    public String[] Cabang() throws SQLException {
        String query = "SELECT * FROM tb_cabang";
        ResultSet rs = kon.getResult(query);
        rs.last();
        String tahun[] = new String[rs.getRow()];
        rs.beforeFirst();
        int a = 0;
        while (rs.next()) {
            tahun[a] = rs.getString("nama_cabang");
            a++;
        }
        a = 0;
        return tahun;
    }

    public DefaultTableModel getTable() throws SQLException {
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

    public void createSamplePDF() throws Exception {
        String header[] = {"Id Pesan", "Cabang", "Sosro", "Fruittea", "Tebs", "S-Tee", "Tanggal"};
        DefaultTableModel tabelModel = new DefaultTableModel(null, header);
        ResultSet rs = kon.getResult("SELECT p.id_permintaan, c.nama_cabang, p.sosro, p.fruittea, p.tebs, p.stee, p.tanggal from tb_permintaanlogistik p join tb_cabang c on p.id_cabang = c.id_cabang");
        for (int i = tabelModel.getRowCount() - 1; i >= 0; i--) {
            tabelModel.removeRow(i);
        }

//        return tabelModel;
        Document documento = new Document();

        //Create new File
        File file = new File("D:/Games/" + c_permintaanLogistik.nama + ".pdf");
        file.createNewFile();
        FileOutputStream fop = new FileOutputStream(file);
        PdfWriter.getInstance(documento, fop);
        documento.open();
        //Fonts
        Font fontHeader = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Font fontBody = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
        //Table for header
        PdfPTable cabetabla = new PdfPTable(header.length);
        for (int j = 0; j < header.length; j++) {
            Phrase frase = new Phrase(header[j], fontHeader);
            PdfPCell cell = new PdfPCell(frase);
            cell.setBackgroundColor(new BaseColor(Color.lightGray.getRGB()));
            cabetabla.addCell(cell);
        }
        documento.add(cabetabla);
        //Tabla for body
        PdfPTable tabla = new PdfPTable(header.length);
//        for (int i = 0; i < body.length; i++) {
//            for (int j = 0; j < body[i].length; j++) {
//                tabla.addCell(new Phrase(body[i][j], fontBody));
//            }
//        }
        while (rs.next()) {
            String kolom[] = new String[7];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
                tabla.addCell(new Phrase(kolom[i], fontBody));
            }

        }
        documento.add(tabla);
        documento.close();
        fop.flush();
        fop.close();
    }

    @Override
    public boolean delete(String query) throws SQLException {
        String queries = "DELETE FROM tb_permintaanlogistik WHERE id_permintaan =" + query;
        return super.delete(queries); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(String query) throws SQLException {
        String queries = "INSERT INTO tb_permintaanlogistik VALUES (" + query + ")";
        return super.save(queries); //To change body of generated methods, choose Tools | Templates.
    }
// (id_permintaan, id_cabang, sosro, fruittea, tebs, stee, tanggal)
}
