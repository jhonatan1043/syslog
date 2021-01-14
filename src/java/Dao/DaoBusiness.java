/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import General.Conexion;
import Interfaces.IBusiness;
import Models.Business;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programador 1
 */
public class DaoBusiness implements IBusiness {

    Conexion cnx = new Conexion();

    @Override
    public ArrayList<Business> listBusiness() {
        ArrayList<Business> list = new ArrayList<>();
        Business business;
        try {

            PreparedStatement prm = cnx.getConexion().prepareStatement("SELECT cod_empresa, nom_empresa FROM empresa");

            try (ResultSet resultSet = prm.executeQuery()) {
                while (resultSet.next()) {
                    business = new Business();
                    business.setIdBusiness(resultSet.getInt(1));
                    business.setBusiness(resultSet.getString(2));
                    list.add(business);
                }
            }
            cnx.getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
