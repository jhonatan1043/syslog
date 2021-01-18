/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Requisicion;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Programador 1
 */
public interface IRequisicion {

    public boolean saveRequisicion(Requisicion requisicion);

    public boolean saveRequisicionDetalle(DefaultTableModel modelo);

    public boolean updateRequisicion(Requisicion requisicion);

    public boolean updateRequisicionDetalle(DefaultTableModel modelo);

    public ArrayList<Requisicion> listRequisicion();

    public ArrayList<Requisicion> listRequisicion(int emp_requisicion);

    public Requisicion getRequisicion(String cc_requisicion);

    public boolean deleteRequisicion(String cc_requisicion);

}
