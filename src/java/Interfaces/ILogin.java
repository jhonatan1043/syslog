/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Login;

/**
 *
 * @author Programador 1
 */
public interface ILogin {
    
    public Login getUser(String user);
    
    public void login(Login login);
    
}
