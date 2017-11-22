/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.awt.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.koneksi;
//import javax.swing.text.Document;
import model.m_login;
import model.m_permintaanLogistik;
import view.v_logistik;
import view.v_permintaanLogistik;

/**
 *
 * @author Vin
 */
public class c_permintaanLogistik {

    v_logistik theView;
    v_permintaanLogistik view;
    m_permintaanLogistik model;
    private koneksi kon;
    public static String nama;

    public c_permintaanLogistik(v_permintaanLogistik view, m_permintaanLogistik model) throws SQLException {
        this.view = view;
        this.model = model;
        view.setVisible(true);
        view.setComboCabang(model.Cabang());
        view.getBtnPesan(new btnTambah());
        view.getBtnBatal(new btnHapus());
        view.getBtnCetak(new btnCetak());
        view.getBtnKembali(new btnKembali());
        view.getTableMinta().setModel(model.getTable());
    }

    private class btnCetak implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                nama = JOptionPane.showInputDialog(theView, "Masukkan Nama File");
                if (nama.isEmpty()) {
                    JOptionPane.showMessageDialog(theView, "Silahkan Masukkan Nama Dulu");
                } else {
                    model.createSamplePDF();
                }
            } catch (Exception ex) {
                Logger.getLogger(c_permintaanLogistik.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class btnKembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c_logistik a = new c_logistik(new v_logistik(), new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_permintaanLogistik.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.dispose();
        }
    }

    private class btnTambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getSosro().getText().equalsIgnoreCase("") || view.getFruittea().getText().equalsIgnoreCase("")
                    || view.getTebs().getText().equalsIgnoreCase("") || view.getStee().getText().equalsIgnoreCase("")
                    || view.getCabang().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(view, "Silahkan Dicek dan Diisi Kembali");
            } else {
                SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
                String tanggal = String.valueOf(fm.format(view.getTanggal().getDate()));
                try {
                    model.save("NULL," + view.getCabang().getSelectedIndex() + "," + view.getSosro().getText() + "," + view.getFruittea().getText()
                            + "," + view.getTebs().getText() + "," + view.getStee().getText() + ",'" + tanggal + "' ");
                    view.getTableMinta().setModel(model.getTable());
                    view.hapus();
                } catch (SQLException ex) {
                    Logger.getLogger(c_permintaanLogistik.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private class btnHapus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.delete((String) view.getTableMinta().getValueAt(view.getTableMinta().getSelectedRow(), 0));
                view.getTableMinta().setModel(model.getTable());
            } catch (SQLException ex) {
                Logger.getLogger(c_permintaanLogistik.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
