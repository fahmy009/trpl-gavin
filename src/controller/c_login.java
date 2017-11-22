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
import model.m_login;
import model.m_daftar;
import controller.c_login;
import view.v_AdminDaftar;
import view.v_admin;
import controller.c_login;
import view.v_awal;
import view.v_gudang;
import view.v_login;
import view.v_logistik;
import view.v_produksi;

/**
 *
 * @author Vin
 */
public class c_login {

    v_login theView;
    m_login theModel;
    v_AdminDaftar view;
    m_daftar model;

    public c_login(v_AdminDaftar view, m_daftar model) {
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
            Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    c_login(v_login theView, m_login theModel) {
        this.theView = theView;
        this.theModel = theModel;
        theView.setVisible(true);
        theView.btn_login(new LoginListener());
        theView.btn_exit(new ExitListener());

    }

    private class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theModel.Login(theView.getUsername(), theView.getPassword());
                System.out.println(theModel.getStatusUser());
                if (theView.getUsername().equalsIgnoreCase("") || theView.getPassword().equalsIgnoreCase("")) {
                    theView.message("Pastikan Username dan Password Anda Terisi");
                    theView.Reset();
                } else if (theModel.getStatusUser().equalsIgnoreCase("")) {
                    theView.message("Pastikan Username dan Password Anda Benar");
                    theView.Reset();

                } else if (theModel.getStatusUser().equalsIgnoreCase("admin")) {
                    theView.dispose();
                    v_admin a = new v_admin();
                    c_admin theController = new c_admin(a, new m_login());
                    System.out.println("Berhasil");
                } else if (theModel.getStatusUser().equalsIgnoreCase("logistik")) {
                    theView.dispose();
                    v_logistik a = new v_logistik();
                    c_logistik theController = new c_logistik(a, new m_login());
                    System.out.println("Berhasil");
                } else if (theModel.getStatusUser().equalsIgnoreCase("produksi")) {
                    theView.dispose();
                    v_produksi a = new v_produksi();
                    c_produksi theController = new c_produksi(a, new m_login());
                    System.out.println("Berhasil");
                } else if (theModel.getStatusUser().equalsIgnoreCase("gudang")) {
                    theView.dispose();
                    v_gudang a = new v_gudang();
                    c_gudang theController = new c_gudang(a, new m_login());
                    System.out.println("Berhasil");
                }
           } catch (Exception ex) {

            }

        }
    }

    private class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
//                model.save(view.getNamauser(), view.getUsername(), view.getPass(), view.getStatus());
                model.save("NULL,'" + view.getNamaUser() + "','" + view.getAlamat() + "','" + view.getJenisKelamin() + "','"
                        + view.getStatus() + "','"
                        + view.getUsername() + "','"
                        + view.getPassword() + "'" + "");
                view.setTable(model.getTableModel());
                view.setNamaUser("");
                view.setAlamat("");
//                view.setJK("");
//                view.setStatus("");
                view.setUsername("");
                view.setPassword("");
                view.text(false);
                view.buttonsave(true);
                view.button(true);
            } catch (SQLException ex) {
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
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
                String JK = view.getValueAt(baris, 3);
                String Status = view.getValueAt(baris, 4);
                String Username = view.getValueAt(baris, 5);
                String Password = view.getValueAt(baris, 6);

                view.setId(iduser);
                view.setNamaUser(NamaUser);
                view.setAlamat(Alamat);
//                view.setJK(JK);
//                view.setStatus(Status);
                view.setUsername(Username);
                view.setPassword(Password);
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
                String nama = view.getNamaUser();
                String alamat = view.getAlamat();
                String jenis = view.getJenisKelamin();
                String status = view.getStatus();
                String username = view.getUsername();
                String pass = view.getPassword();
                model.update("nama ='" + nama + "', alamat='" + alamat + "', jenis_kelamin='" + jenis + "', status= '"
                        + status + "', username='" + username + "', password= '" + pass + "' WHERE id_user =" + id);
//                model.update(id, nama, user, pass, status);
                clear();
                view.text(true);
                view.buttonupdate(true);
                view.button(true);
                view.setTable(model.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            v_admin a = new v_admin();
            a.setVisible(true);
            try {
                c_admin theController = new c_admin(a, new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("oke");
            view.dispose();
        }
    }

    public void clear() {
        view.setId("");
        view.setNamaUser("");
//        view.setJK("");
//        view.setStatus("");
        view.setUsername("");
        view.setPassword("");
    }
}
