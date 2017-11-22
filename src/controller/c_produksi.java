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
import model.m_asam;
import model.m_login;
import model.m_stokProduksi;
import model.m_suhu;
import view.v_produksi;
import view.v_pemasakanAsam;
import view.v_pemasakanKalkulasi;
import view.v_pemasakanSuhu;
import view.v_login;
import view.v_stokProduksi;

/**
 *
 * @author Vin
 */
public class c_produksi {

    private m_login theModel;
    private v_produksi theView;

    public c_produksi(v_produksi theView, m_login theModel) {
        this.theView = theView;
        this.theModel = theModel;
        theView.setVisible(true);
        theView.suhuListener(new suhuListener());
        theView.phListener(new phListener());
        theView.kalkulasiListener(new kalkulasiListener());
        theView.addStokListener(new stokListener());
        theView.addLogout(new logoutListener());
    }

    private class suhuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_pemasakanSuhu a = new v_pemasakanSuhu();
            a.setVisible(true);
            try {
                c_suhu theController = new c_suhu(a, new m_suhu());
            } catch (SQLException ex) {
                Logger.getLogger(c_cabang.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }

    private class phListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_pemasakanAsam a = new v_pemasakanAsam();
            a.setVisible(true);
            try {
                c_asam theController = new c_asam(a, new m_asam());
            } catch (SQLException ex) {
                Logger.getLogger(c_produksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }

    private class kalkulasiListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_pemasakanKalkulasi a = new v_pemasakanKalkulasi();
            a.setVisible(true);
            try {
                c_kalkulasi theController = new c_kalkulasi(a);
            } catch (SQLException ex) {
                Logger.getLogger(c_produksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }

    private class stokListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_stokProduksi a = new v_stokProduksi();
            a.setVisible(true);
            try {
                c_stokProduksi theController = new c_stokProduksi(a, new m_stokProduksi());
            } catch (SQLException ex) {
                Logger.getLogger(c_produksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();

        }
    }

    private class logoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_login a = new v_login();
            a.setVisible(true);
            try {
                c_login theController = new c_login(a, new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_produksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }
}
