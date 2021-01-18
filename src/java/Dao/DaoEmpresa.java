/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import General.Conexion;
import Models.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interfaces.IEmpresa;

/**
 *
 * @author Programador 1
 */
public class DaoEmpresa implements IEmpresa {

    Conexion cnx = new Conexion();

    @Override
    public ArrayList<Empresa> listBusiness() {
        ArrayList<Empresa> list = new ArrayList<>();
        Empresa business;
        try {

            PreparedStatement prm = cnx.getConexion().prepareStatement("SELECT cod_empresa, nom_empresa FROM empresa");

            try (ResultSet resultSet = prm.executeQuery()) {
                while (resultSet.next()) {
                    business = new Empresa();
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
