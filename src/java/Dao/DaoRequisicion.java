/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import General.Conexion;
import Interfaces.IRequisicion;
import Models.Requisicion;
import java.sql.PreparedStatement;
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
            try (PreparedStatement psmt = cnx.getConexion().prepareStatement("")) {
                psmt.setInt(1, requisicion.getEmp_requisicion());
                psmt.setString(2, requisicion.getCc_requisicion());
                psmt.setString(3, requisicion.getNum_requisicion());
                psmt.setDate(4, requisicion.getFecha_requisicion());
                psmt.setString(5, requisicion.getTipo_requisicion());
                psmt.setString(6, requisicion.getEstado_requisicion());
                psmt.setString(7, requisicion.getObs_requisicion());
                psmt.setDate(8, requisicion.getFecha_ap());
                psmt.setString(9, requisicion.getUser_ap());
                psmt.setString(10, requisicion.getClase_requisicion());
                psmt.setString(11, requisicion.getUser_rq());
                psmt.setString(12, requisicion.getInterno_requisicion());
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
    public boolean saveRequisicionDetalle(Requisicion requisicion) {
        return false;
        
    }

    @Override
    public boolean updateRequisicion(Requisicion requisicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
