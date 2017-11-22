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
import view.v_lapAdmin;
import model.m_laporan;
import view.v_admin;
import model.m_login;
import view.v_produksi;

/**
 *
 * @author Vin
 */
public class c_laporan {

    v_lapAdmin view;
    m_laporan model;

    public c_laporan(v_lapAdmin view, m_laporan model) throws SQLException {
        this.view = view;
        this.model = model;
        view.setVisible(true);
        view.getBtnKembali(new btnKembali());
        view.getTableLaporan().setModel(model.getTableLaporan());
    }

    private class btnKembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c_admin a = new c_admin(new v_admin(), new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.dispose();
        }
    }
}
