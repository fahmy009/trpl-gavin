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
import model.m_suhu;
import view.v_pemasakanSuhu;
import model.m_login;
import view.v_produksi;

/**
 *
 * @author Vin
 */
public class c_suhu {

    private m_suhu theModel;
    private v_pemasakanSuhu theView;

    public c_suhu(v_pemasakanSuhu theView, m_suhu theModel) {
        this.theModel = theModel;
        this.theView = theView;
        theView.setVisible(true);
        theView.addBackListener(new backListener());
        theView.CekListener(new hasilPerformed());
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

    private class hasilPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double suhu = Double.parseDouble(theView.getSuhu());
            int idSuhu;
            try {
                if (suhu <= 89) {
                    idSuhu = 3;
                    theModel.cekSuhu(suhu, theView.getMesin());
                    theView.setKondisi("Volume Mesin : " + theModel.getVolume().toString() + ",\n Kondisi air terlalu dingin.");
                    theView.setTanggapan("Silahkan Naikkan Temperatur pemasak dan  \njangan lupa melakukan pengukuran suhu pemasakan");
                } else if (suhu >= 90 && suhu <= 100) {
                    idSuhu = 1;
                    theModel.cekSuhu(suhu, theView.getMesin());
                    theView.setKondisi("Volume Mesin : " + theModel.getVolume().toString() + ", \n Kondisi air normal.");
                    theView.setTanggapan("Kondisi Pemanas Normal, tetap  \n kontrol kondisi temperatur");
                } else if (suhu > 100) {
                    idSuhu = 2;
                    theModel.cekSuhu(suhu, theView.getMesin());
                    theView.setKondisi("Volume Mesin : " + theModel.getVolume().toString() + ", \n Kondisi air terlalu panas.");
                    theView.setTanggapan("Untuk membuat suhu pemasakan normal,  \n maka berikan es sebanyak " + theModel.cekSuhu(suhu, theView.getMesin()) + " kg.");
                    System.out.println(theModel.getVolume());
                }
            } catch (SQLException ex) {
                Logger.getLogger(c_suhu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private class kembaliListener implements ActionListener {

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
            }
        }
    }
}
