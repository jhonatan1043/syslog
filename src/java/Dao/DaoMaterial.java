/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import General.Conexion;
import General.Querys;
import Interfaces.IMaterial;
import Models.Material;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programador 1
 */
public class DaoMaterial implements IMaterial {

    Conexion cnx = new Conexion();

    @Override
    public Map<String, Object> getMaterial(String codigo) {
        boolean result = false;
        Map<String, Object> mapRes = new HashMap<>();
        Material material = new Material();
        String message;

        try {

            try (PreparedStatement psmt = cnx.getConexion().prepareStatement(Querys.QUERY_GET_MATERIAL_CODIGO)) {
                psmt.setString(1, codigo);

                try (ResultSet resultSet = psmt.executeQuery()) {
                    while (resultSet.next()) {
                        material.setCodigo(resultSet.getString(1));
                        material.setDescripcion(resultSet.getString(2));
                        material.setUnidad(resultSet.getString(3));
                    }
                    cnx.getConexion().close();
                }
            }
            result = true;
            message = "listo";
        } catch (SQLException ex) {
            Logger.getLogger(DaoRequisicion.class.getName()).log(Level.SEVERE, null, ex);
            message = ex.getMessage();
        }

        mapRes.put("isValid", result);
        mapRes.put("message", message);
        mapRes.put("data", material);
        return mapRes;
    }

    @Override
    public ArrayList<Material> listMaterial() {
        ArrayList<Material> list = new ArrayList<>();
        Material material;

        try {

            try (PreparedStatement psmt = cnx.getConexion().prepareStatement(Querys.QUERY_LIST_MATERIAL)) {

                try (ResultSet resultSet = psmt.executeQuery()) {
                    while (resultSet.next()) {
                        material = new Material();
                        material.setCodigo(resultSet.getString(1));
                        material.setDescripcion(resultSet.getString(2));
                        material.setUnidad(resultSet.getString(3));
                        list.add(material);
                    }
                    cnx.getConexion().close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoRequisicion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
