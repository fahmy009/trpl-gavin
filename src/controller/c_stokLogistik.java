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
import model.m_stokLogistik;
import model.m_stokProduksi;
import view.v_logistik;
import view.v_stokLogistik;
/**
 *
 * @author Vin
 */
public class c_stokLogistik {
     v_stokLogistik view;
    m_stokLogistik model;
     public c_stokLogistik(v_stokLogistik view, m_stokLogistik model) throws SQLException {
        this.view = view;
        this.model = model;
        view.setVisible(true);
        view.getBtnTerima(new btnTerima());
        view.getBtnKembali(new btnKembali());
        view.getTableStok().setModel(model.getTableStok());
    }

    private class btnTerima implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (view.getTableStok().getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(view, "Pilih Data terlebih dahulu");
                } else {
                    model.save((String) view.getTableStok().getValueAt(view.getTableStok().getSelectedRow(), 0));
                    model.delete((String) view.getTableStok().getValueAt(view.getTableStok().getSelectedRow(), 0));
                    view.getTableStok().setModel(model.getTableStok());
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_stokLogistik.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class btnKembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                c_logistik a = new c_logistik(new v_logistik(), new m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_stokLogistik.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.dispose();
        }
    }
}
