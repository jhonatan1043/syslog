/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Requisicion;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Programador 1
 */
public interface IRequisicion {

    public Map<String, Object> saveRequisicion(Requisicion requisicion);

    public boolean saveRequisicionDetalle(Requisicion requisicion);

    public Map<String, Object> updateRequisicion(Requisicion requisicion);

    public boolean updateRequisicionDetalle(Requisicion requisicion);

    public ArrayList<Requisicion> listRequisicion();

    public ArrayList<Requisicion> listRequisicion(int emp_requisicion);

    public Requisicion getRequisicion(String cc_requisicion);

    public boolean deleteRequisicion(String cc_requisicion);

    public Map<String, Object> getMaterial(String codigo);

}
