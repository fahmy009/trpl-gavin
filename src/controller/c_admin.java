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
import model.m_daftar;
import model.m_laporan;
import view.v_admin;
import view.v_AdminDaftar;
import view.v_lapAdmin;
import view.v_login;

/**
 *
 * @author Vin
 */
public class c_admin {

    private m_login theModel;
    private v_admin theView;

    public c_admin(v_admin theView, m_login theModel) {
        this.theView = theView;
        this.theModel = theModel;
        theView.setVisible(true);
        theView.addDaftarListener(new daftarListener());
        theView.addLaporanListener(new laporanListener());
        theView.addLogout(new logoutListener());
    }

    private class daftarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_AdminDaftar a = new v_AdminDaftar();
            a.setVisible(true);
            try {
                c_login theController = new c_login(a, new m_daftar());
            } catch (SQLException ex) {
                Logger.getLogger(c_admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            theView.dispose();
        }
    }

    private class laporanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_lapAdmin a = new v_lapAdmin();
            a.setVisible(true);
            try {
                c_laporan theController = new c_laporan(a, new m_laporan());
            } catch (SQLException ex) {
                Logger.getLogger(c_admin.class.getName()).log(Level.SEVERE, null, ex);
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
