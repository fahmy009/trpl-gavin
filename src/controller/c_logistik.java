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
import model.m_cabang;
import model.m_login;
import model.m_permintaanLogistik;
import model.m_stokLogistik;
import view.v_cabang;
import view.v_login;
import view.v_logistik;
import view.v_permintaanGudang;
import view.v_permintaanLogistik;
import view.v_stokLogistik;

/**
 *
 * @author Vin
 */
public class c_logistik {

    private m_login theModel;
    private v_logistik theView;

    public c_logistik(v_logistik theView, m_login theModel) {
        this.theView = theView;
        this.theModel = theModel;
        theView.setVisible(true);
        theView.addCabangListener(new cabangListener());
        theView.addPermintaanListener(new mintaListener());
        theView.addStokListener(new stokListener());
        theView.addLogout(new logoutListener());
    }

    private class cabangListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_cabang a = new v_cabang();
            a.setVisible(true);
            try {
                c_cabang theController = new c_cabang(a, new m_cabang());
            } catch (SQLException ex) {
                Logger.getLogger(c_cabang.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }

    private class mintaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_permintaanLogistik a = new v_permintaanLogistik();
            a.setVisible(true);
            try {
                c_permintaanLogistik theController = new c_permintaanLogistik(a, new m_permintaanLogistik());
            } catch (SQLException ex) {
                Logger.getLogger(c_permintaanLogistik.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }

    private class stokListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_stokLogistik a = new v_stokLogistik();
            a.setVisible(true);
            try {
                c_stokLogistik theController = new c_stokLogistik(a, new m_stokLogistik());
            } catch (SQLException ex) {
                Logger.getLogger(c_stokLogistik.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(c_admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }
}
