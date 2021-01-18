/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.CentroCosto;
import java.util.ArrayList;

/**
 *
 * @author Programador 1
 */
public interface ICentroCosto {

    public ArrayList<CentroCosto> listCentroCosto();

    public ArrayList<CentroCosto> listCentrosCostos(int idEmpresa);

    public CentroCosto getCentroCosto(String codigoCentroCosto);

}
