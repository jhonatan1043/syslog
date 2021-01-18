/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.ClasificacionRequisicion;
import java.util.ArrayList;

/**
 *
 * @author Programador 1
 */
public interface IClasificacionRequisicion {

    public ArrayList<ClasificacionRequisicion> listClasificacionRequisicion();

    public ClasificacionRequisicion getClasificacionRequisicion(String codigoClasificacionRequisicion);

}
