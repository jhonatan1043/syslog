/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

/**
 *
 * @author Programador 1
 */
public class Querys {

    //CENTRO DE COSTO
    public static String QUERY_LIST_CENTRO_COSTO = "SELECT cod_cc AS Código,"
            + " nom_cc AS Descripción "
            + " FROM   centroscosto"
            + " ORDER BY nom_cc";

    public static String QUERY_LIST_CENTRO_COSTO_EMPRESA = "SELECT cod_cc AS Código,"
            + " nom_cc AS Descripción "
            + " FROM   centroscosto WHERE emp_cc = ?"
            + " ORDER BY nom_cc";

    public static String QUERY_GET_CENTRO_COSTO = "SELECT nom_cc AS Descripción "
            + " FROM   centroscosto"
            + " WHERE cod_cc = ?";

    //CLASIFICACION REQUISICION
    public static String QUERY_LIST_CLASIFICACION = "SELECT cod_clasificacion AS Código,"
            + " nom_clasificacion AS Descripción"
            + " FROM clasificacion ORDER BY cod_clasificacion";

    public static String QUERY_GET_CLASIFICACION = "SELECT nom_clasificacion AS Descripción"
            + " FROM clasificacion WHERE cod_clasificacion = ?";
    //|REQUISICIOM
    public static String QUERY_SAVE_REQUISICION = "EXEC spRequisionesGuardar ?,?,?,?,?,?,?,?";

    public static String QUERY_UPDATE_REQUISICION = "EXEC spRequisionesActualizar ?,?,?,?,?,?,?,?,?";
   
   public static String QUERY_GET_MATERIAL_CODIGO = "SELECT cod_material AS Código, nom_material AS Descripción, und_material \n" +
                                                    " FROM   material \n" +
                                                    " WHERE cod_material = ?";
   
      public static String QUERY_LIST_MATERIAL = "SELECT cod_material AS Código, nom_material AS Descripción, und_material \n" +
                                                        " FROM material ORDER BY DESC";
}
