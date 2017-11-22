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
import model.m_login;
import view.v_produksi;
import view.v_pemasakanAsam;
import model.m_asam;

/**
 *
 * @author Vin
 */
public class c_asam {

    private m_asam theModel;
    private v_pemasakanAsam theView;

    public c_asam(v_pemasakanAsam theView, m_asam theModel) throws SQLException {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        this.theView.CekListener(new HasilPerformed());
        theView.addBackListener(new backListener());
    }

    private class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            v_produksi a = new v_produksi();
            a.setVisible(true);
            try {
                c_produksi theController = new c_produksi(a, new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_produksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
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
