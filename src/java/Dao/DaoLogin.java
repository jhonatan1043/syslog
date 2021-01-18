/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import General.Conexion;
import Interfaces.ILogin;
import Models.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programador 1
 */
public class DaoLogin implements ILogin {

    Conexion cnx = new Conexion();

    @Override
    public Login login(Login login ) {

        try {

            PreparedStatement prm = cnx.getConexion().prepareStatement("SELECT estado_user "
                                                                       + "FROM usuarios WHERE cod_user = ? "
                                                                       + " AND pwd_user = ?");
            prm.setString(1, login.getUser());
            prm.setString(2, login.getPass());
            
            try (ResultSet result = prm.executeQuery()) {
                while (result.next()) {
                    login.setTipo(result.getString(1));
                }
            }
            
            System.out.println(login);
            
            cnx.getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
}
