/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Material;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Programador 1
 */
public interface IMaterial {

    public Map<String, Object> getMaterial(String codigo);

    public ArrayList<Material> listMaterial();

}
