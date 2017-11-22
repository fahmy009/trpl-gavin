/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.UpdatableResultSet;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.m_cabang;
import model.m_login;
import view.v_cabang;
import view.v_logistik;

/**
 *
 * @author Vin
 */
public class c_cabang {

    v_cabang view;
    m_cabang model;

    public c_cabang(v_cabang view, m_cabang model) {
        this.model = model;
        this.view = view;
        view.setVisible(true);
        view.addSaveListener(new saveListener());
        view.addeditListener(new editListener());
        view.addUpdateListener(new updateListener());
        view.addDeleteListener(new hapusListener());
        view.addBackListener(new backListener());

        try {
            view.setTable(model.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(c_cabang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
//                model.save(view.getNamauser(), view.getUsername(), view.getPass(), view.getStatus());
                model.save("NULL,'" + view.getCabang() + "','" + view.getAlamat() + "'" + "");
                view.setTable(model.getTableModel());
                view.setNamaUser("");
                view.setAlamat("");
//                view.setJK("");
//                view.setStatus("");
                view.text(false);
                view.buttonsave(true);
                view.button(true);
            } catch (SQLException ex) {
                Logger.getLogger(c_cabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class editListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int baris = view.getSelectedRow();
            if (baris != -1) {

                String iduser = view.getValueAt(baris, 0);
                String NamaUser = view.getValueAt(baris, 1);
                String Alamat = view.getValueAt(baris, 2);

                view.setId(iduser);
                view.setNamaUser(NamaUser);
                view.setAlamat(Alamat);
//                view.setJK(JK);
//                view.setStatus(Status);
                view.text(true);
            }
//        view.button(true);
        }
    }

    private class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = view.getSelectedRow();
                String id = view.getId();
//                int id = Integer.parseInt(iduser);
                String nama = view.getCabang();
                String alamat = view.getAlamat();
                model.update("nama_cabang ='" + nama + "', alamat='" + alamat + "' WHERE id_cabang =" + id);
//                model.update(id, nama, user, pass, status);
                clear();
                view.text(true);
                view.buttonupdate(true);
                view.button(true);
                view.setTable(model.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_cabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int baris = view.getSelectedRow();
                String iduser = view.getValueAt(baris, 0);
                System.out.println(iduser);
                model.delete(iduser);
                view.setTable(model.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_cabang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_logistik a = new v_logistik();
            a.setVisible(true);
            try {
                c_logistik theController = new c_logistik(a, new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_logistik.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            view.dispose();
        }
    }

    public void clear() {
        view.setId("");
        view.setNamaUser("");
        view.setAlamat("");
//        view.setJK("");
//        view.setStatus("");

    }
}
