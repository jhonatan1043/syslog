/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import General.Conexion;
import General.Querys;
import Interfaces.IClasificacionRequisicion;
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
public class DaoClasificacionRequisicion implements IClasificacionRequisicion {
 Conexion cnx = new Conexion();
 
    @Override
    public ArrayList<ClasificacionRequisicion> listClasificacionRequisicion() {
       ArrayList<ClasificacionRequisicion> list = new ArrayList<>();
        ClasificacionRequisicion clasificacionRequisicion;
        
        try {

            PreparedStatement prm = cnx.getConexion().prepareStatement(Querys.QUERY_LIST_CLASIFICACION);

            try (ResultSet resultSet = prm.executeQuery()) {
                while (resultSet.next()) {
                    clasificacionRequisicion = new ClasificacionRequisicion();
                    clasificacionRequisicion.setClasificacion(resultSet.getString(1));
                    clasificacionRequisicion.setNom_clasificacion(resultSet.getString(2));
                    list.add(clasificacionRequisicion);
                }
            }
            cnx.getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ClasificacionRequisicion getClasificacionRequisicion(String codigoClasificacionRequisicion) {
        ClasificacionRequisicion clasificacionRequisicion = new ClasificacionRequisicion();
        
        try {
            PreparedStatement prm = cnx.getConexion().prepareStatement(Querys.QUERY_GET_CLASIFICACION);
            prm.setString(1, codigoClasificacionRequisicion);
            
            try (ResultSet resultSet = prm.executeQuery()) {
                while (resultSet.next()) {
                    clasificacionRequisicion.setClasificacion(codigoClasificacionRequisicion);
                    clasificacionRequisicion.setNom_clasificacion(resultSet.getString(1));
                }
            }
            cnx.getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clasificacionRequisicion;
    }
    
}
