/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import General.Conexion;
import General.Querys;
import Interfaces.ICentroCosto;
import Models.CentroCosto;
import Models.ClasificacionRequisicion;
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
public class DaoCentroCosto implements ICentroCosto {

    Conexion cnx = new Conexion();

    @Override
    public ArrayList<CentroCosto> listCentroCosto() {
        ArrayList<CentroCosto> list = new ArrayList<>();
        CentroCosto centroCosto;

        try {

            PreparedStatement prm = cnx.getConexion().prepareStatement(Querys.QUERY_LIST_CENTRO_COSTO);

            try (ResultSet resultSet = prm.executeQuery()) {
                while (resultSet.next()) {
                    centroCosto = new CentroCosto();
                    centroCosto.setCod_cc(resultSet.getString(1));
                    centroCosto.setNom_cc(resultSet.getString(2));
                    list.add(centroCosto);
                }
            }
            cnx.getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<CentroCosto> listCentrosCostos(int idEmpresa) {
        ArrayList<CentroCosto> list = new ArrayList<>();
        CentroCosto centroCosto;

        try {

            PreparedStatement prm = cnx.getConexion().prepareStatement(Querys.QUERY_LIST_CENTRO_COSTO_EMPRESA);
            prm.setInt(1, idEmpresa);

            try (ResultSet resultSet = prm.executeQuery()) {
                while (resultSet.next()) {
                    centroCosto = new CentroCosto();
                    centroCosto.setCod_cc(resultSet.getString(1));
                    centroCosto.setNom_cc(resultSet.getString(2));
                    list.add(centroCosto);
                }
            }
            cnx.getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public CentroCosto getCentroCosto(String codigoCentroCosto) {
        CentroCosto centroCosto = new CentroCosto();

        try {
            PreparedStatement prm = cnx.getConexion().prepareStatement(Querys.QUERY_GET_CENTRO_COSTO);
            prm.setString(1, codigoCentroCosto);

            try (ResultSet resultSet = prm.executeQuery()) {
                while (resultSet.next()) {
                    centroCosto.setCod_cc(codigoCentroCosto);
                    centroCosto.setNom_cc(resultSet.getString(1));
                }
            }
            cnx.getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centroCosto;
    }

}
