/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trpl_sosro;

import controller.c_awal;
import controller.c_login;
import java.sql.SQLException;
import model.m_login;
import view.v_awal;

/**
 *
 * @author Vin
 */
public class Trpl_sosro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        v_awal a = new v_awal();
        c_awal control = new c_awal(a);
    }

}
