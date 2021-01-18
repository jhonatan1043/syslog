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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programador 1
 */
public class DaoRequisicion implements IRequisicion {

    Conexion cnx = new Conexion();

    @Override
    public boolean saveRequisicion(Requisicion requisicion) {
        boolean result = false;

        try {
            try (PreparedStatement psmt = cnx.getConexion().prepareStatement(Querys.QUERY_SAVE_REQUISICION)) {
                psmt.setInt(1, requisicion.getEmp_requisicion());
                psmt.setString(2, requisicion.getCc_requisicion());
                psmt.setDate(3, requisicion.getFecha_requisicion());
                psmt.setString(4, requisicion.getTipo_requisicion());
                psmt.setString(5, requisicion.getEstado_requisicion());
                psmt.setString(6, requisicion.getObs_requisicion());
                psmt.setDate(7, requisicion.getFecha_ap());
                psmt.setString(8, requisicion.getUser_ap());
                psmt.setString(9, requisicion.getClase_requisicion());
                psmt.setString(10, requisicion.getUser_rq());
                psmt.setString(11, requisicion.getInterno_requisicion());
                try (ResultSet resultSet = psmt.executeQuery()) {
                    while (resultSet.next()) {
                        requisicion.setNum_requisicion(resultSet.getString(1));
                    }

                    cnx.getConexion().close();
                }
                psmt.close();
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoRequisicion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean saveRequisicionDetalle(Requisicion requisicion) {
        return false;

    }

    @Override
    public boolean updateRequisicion(Requisicion requisicion) {
        boolean result = false;

        try {
            try (PreparedStatement psmt = cnx.getConexion().prepareStatement(Querys.QUERY_UPDATE_REQUISICION)) {
                psmt.setInt(1, requisicion.getEmp_requisicion());
                psmt.setString(2, requisicion.getCc_requisicion());
                psmt.setDate(3, requisicion.getFecha_requisicion());
                psmt.setString(4, requisicion.getTipo_requisicion());
                psmt.setString(5, requisicion.getEstado_requisicion());
                psmt.setString(6, requisicion.getObs_requisicion());
                psmt.setDate(7, requisicion.getFecha_ap());
                psmt.setString(8, requisicion.getUser_ap());
                psmt.setString(9, requisicion.getClase_requisicion());
                psmt.setString(10, requisicion.getUser_rq());
                psmt.setString(11, requisicion.getInterno_requisicion());
                psmt.setString(12, requisicion.getNum_requisicion());
                psmt.execute();
                
                cnx.getConexion().close();
                psmt.close();
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoRequisicion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
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
