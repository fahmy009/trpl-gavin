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
import model.m_daftar;
import model.m_login;
import model.m_permintaanGudang;
import model.m_stokgudang;
import view.v_AdminDaftar;
import view.v_gudang;
import view.v_login;
import view.v_permintaanGudang;
import view.v_stokGudang;
import view.v_stokGudang;

/**
 *
 * @author Vin
 */
public class c_gudang {

    m_login theModel;
    v_gudang theView;

    public c_gudang(v_gudang theView, m_login theModel) {
        this.theView = theView;
        this.theModel = theModel;
        theView.setVisible(true);
        theView.addMintaListener(new mintaListener());
        theView.addStokListener(new stokListener());
        theView.addLogout(new logoutListener());
    }

    private class mintaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_permintaanGudang a = new v_permintaanGudang();
            a.setVisible(true);
            try {
                c_permintaanGudang theController = new c_permintaanGudang(a, new m_permintaanGudang());
            } catch (SQLException ex) {
                Logger.getLogger(c_permintaanGudang.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }

    private class stokListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_stokGudang a = new v_stokGudang();
            a.setVisible(true);
            try {
                c_stokgudang theController = new c_stokgudang(a, new m_stokgudang());
            } catch (SQLException ex) {
                Logger.getLogger(c_stokgudang.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(c_gudang.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }
}
