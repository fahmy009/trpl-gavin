/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vin
 */
public class m_suhu {

    public koneksi kon;
    public double massa;
    public double volume;
    public double m_es;

    public m_suhu() throws SQLException {
        super();
        kon = new koneksi("root", "", "db_trpl");
    }

    public double cekSuhu(double suhu, int mesin) throws SQLException {
        String query = "select volume from tb_mesin where id_mesin = " + mesin;
        ResultSet rs = kon.getResult(query);
        rs.last();

//        volume = rs.getDouble("volume");
//        massa = volume/1000;
//        
//        m_es = ((massa*(suhu-28)) / (0.5*28)) * 1000;
//        return Math.ceil(m_es);
        volume = rs.getDouble("volume");

        m_es = ((1000 / volume) * (suhu - 28)) / 14;
        return Math.ceil(m_es);
    }

    public Double getVolume() {
        return volume;
    }

}
