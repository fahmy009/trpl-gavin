/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_login;
import view.v_awal;

/**
 *
 * @author Vin
 */
public class c_awal {

    v_awal a;

    public c_awal(v_awal a) {
        this.a = a;
        a.setVisible(true);
        this.a.klikLogin(new v_login());
        this.a.klikAbout(new v_about());
    }

    private class v_login implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            a.dispose();
            try {
                c_login con = new c_login(new view.v_login(), new m_login());
                a.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class v_about implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(a, "Project dari mata kuliah TRPL yang mengharuskan mahasiswa untuk membuat suatu program\n"
                    + "yang di dalamnya mencakup cara memanajemen perusahaan,\nsehingga membantu untuk memperoleh keuntungan yang besar.\n"
                    + "Kelompok Kami antara lain : \n" + "1. Ayu Sisca Irianti      152410101053\n" + "2. Siti Vika NF      152410101072\n"
                    + "3. Gavin Liffera Kusuma P      152410101096\n" + "4. Aisyah Nur F      152410101097\n" + "5. Agustin 152410101010 ");
        }

    }

    class HasilPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double asam = Double.parseDouble(theView.getPH());

            try {
                if (theView.getMesin() == 0 || theView.getPH().equalsIgnoreCase("")) {
                    theView.Message("Pastikan semua data terisi !");
                } else if (asam >= 6.5 && asam <= 8) {
                    theModel.Keasaman(2);
                    theView.setAnalisa(theModel.getStatus().toString());
                    theView.setTanggapan(theModel.getTindakan().toString());
                } else if (asam >= 9 && asam <= 14) {
                    theModel.Keasaman(1);
                    theView.setAnalisa(theModel.getStatus().toString());
                    theView.setTanggapan(theModel.getTindakan().toString());
                } else if (asam >= 5.1 && asam <= 6.4) {
                    theModel.Keasaman(3);
                    theView.setAnalisa(theModel.getStatus().toString());
                    theView.setTanggapan(theModel.getTindakan().toString());
                } else if (asam >= 4 && asam <= 5) {
                    theModel.Keasaman(4);
                    theView.setAnalisa(theModel.getStatus().toString());
                    theView.setTanggapan(theModel.getTindakan().toString());
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_asam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
