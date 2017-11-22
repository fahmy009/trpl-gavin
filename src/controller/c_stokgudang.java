/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_login;
import model.m_stokgudang;
import view.v_gudang;
import view.v_stokGudang;
/**
 *
 * @author Vin
 */
public class c_stokgudang {
    v_stokGudang view;
    m_stokgudang model;
     public c_stokgudang(v_stokGudang view, m_stokgudang model) throws SQLException {
        this.view = view;
        this.model = model;
        view.setVisible(true);
        view.getBtnKirim(new btnKirim());
        view.getBtnKembali(new btnKembali());
        view.getTableStok().setModel(model.getTableStok());
        view.getTableKirim().setModel(model.getTableKirim());
    }

    private class btnKirim implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (view.getTableStok().getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(view, "Pilih Data terlebih dahulu");
                } else {
                    model.save((String) view.getTableStok().getValueAt(view.getTableStok().getSelectedRow(), 0));
                    model.delete((String) view.getTableStok().getValueAt(view.getTableStok().getSelectedRow(), 0));
                    view.getTableKirim().setModel(model.getTableKirim());
                    view.getTableStok().setModel(model.getTableStok());
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_stokgudang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class btnKembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c_gudang a = new c_gudang(new v_gudang(), new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_stokgudang.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.dispose();
        }
    }
}
