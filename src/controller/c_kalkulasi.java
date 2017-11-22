/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.m_login;
import view.v_pemasakanKalkulasi;
import view.v_produksi;

/**
 *
 * @author Vin
 */
public class c_kalkulasi {

    v_pemasakanKalkulasi view;
    public static double botol;
    public static double air;
    public static double teh;

    public c_kalkulasi(v_pemasakanKalkulasi view) throws SQLException {
        this.view = view;
        view.setVisible(true);
        view.addBackListener(new kembaliListener());
        view.CekListener(new CekListener());
        view.getKrak(new hitungKrak());
    }

    private class hitungKrak implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

            String regex = "\\d+";//untuk menggunakan parameternya
            if (view.getKrak().getText().matches(regex)) {
                botol = ((Double.valueOf(view.getKrak().getText()) * 24));
                view.getBotol().setText(Double.toString(botol));
                air = ((Double.valueOf(view.getBotol().getText()) * 0.22));
                view.getAir().setText(Double.toString(air));
                teh = ((Double.valueOf(view.getAir().getText()) / 100));
                view.getTeh().setText(Double.toString(teh));
            } else {
                view.getKrak().setText("");
                JOptionPane.showMessageDialog(view, "Silahkan Masukkan Angka dengan BENAR!1!!1");
            }

        }
    }

    private class CekListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class kembaliListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            v_produksi a = new v_produksi();
            a.setVisible(true);
            try {
                c_produksi theController = new c_produksi(a, new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_produksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            view.dispose();
        }
    }

}
