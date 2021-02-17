/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import General.Conexion;
import General.Querys;
import Interfaces.IRequisicion;
import Models.Requisicion;
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
public class DaoRequisicion implements IRequisicion {

    Conexion cnx = new Conexion();

    @Override
    public Map<String, Object> saveRequisicion(Requisicion requisicion) {
        boolean result = false;
        Map<String, Object> mapRes = new HashMap<>();
        String message;

        try {
            try (PreparedStatement psmt = cnx.getConexion().prepareStatement(Querys.QUERY_SAVE_REQUISICION)) {
                psmt.setInt(1, requisicion.getEmp_requisicion());
                psmt.setString(2, requisicion.getCc_requisicion());
                psmt.setDate(3, requisicion.getFecha_requisicion());
                psmt.setString(4, requisicion.getTipo_requisicion());
                psmt.setString(5, requisicion.getObs_requisicion());
                psmt.setString(6, requisicion.getClase_requisicion());
                psmt.setString(7, requisicion.getInterno_requisicion());
                psmt.setString(8, requisicion.getUser_rq());
                try (ResultSet resultSet = psmt.executeQuery()) {
                    while (resultSet.next()) {
                        requisicion.setNum_requisicion(resultSet.getString(1));
                        requisicion.setEstado_requisicion("N");
                    }

                    cnx.getConexion().close();
                }
                psmt.close();
                result = true;
                message = "Registrado con Exito, codigo: " + requisicion.getNum_requisicion();

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRequisicion.class.getName()).log(Level.SEVERE, null, ex);
            message = ex.getMessage();
        }

        mapRes.put("isValid", result);
        mapRes.put("message", message);
        mapRes.put("data", requisicion);

        return mapRes;
    }

    @Override
    public boolean saveRequisicionDetalle(Requisicion requisicion) {
        return false;

    }

    @Override
    public Map<String, Object> updateRequisicion(Requisicion requisicion) {
        boolean result = false;
        Map<String, Object> mapRes = new HashMap<>();
        String message;

        try {
            try (PreparedStatement psmt = cnx.getConexion().prepareStatement(Querys.QUERY_UPDATE_REQUISICION)) {
                psmt.setInt(1, requisicion.getEmp_requisicion());
                psmt.setString(2, requisicion.getCc_requisicion());
                psmt.setDate(3, requisicion.getFecha_requisicion());
                psmt.setString(4, requisicion.getTipo_requisicion());
                psmt.setString(5, requisicion.getObs_requisicion());
                psmt.setString(6, requisicion.getClase_requisicion());
                psmt.setString(7, requisicion.getInterno_requisicion());
                psmt.setString(8, requisicion.getUser_rq());
                psmt.setString(9, requisicion.getNum_requisicion());

                psmt.execute();
                cnx.getConexion().close();
                psmt.close();
                result = true;
                message = "Actualizado con Exito, codigo: " + requisicion.getNum_requisicion();

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRequisicion.class.getName()).log(Level.SEVERE, null, ex);
            message = ex.getMessage();
        }

        mapRes.put("isValid", result);
        mapRes.put("message", message);
        mapRes.put("data", requisicion);

        return mapRes;
    }

    @Override
    public boolean updateRequisicionDetalle(Requisicion requisicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Requisicion> listRequisicion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Requisicion> listRequisicion(int emp_requisicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Requisicion getRequisicion(String cc_requisicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteRequisicion(String cc_requisicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
