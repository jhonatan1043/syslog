/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DaoLogin;
import General.EncryptDescryptString;
import Models.Login;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Programador 1
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        Login login = new Login();
        DaoLogin daoLogin = new DaoLogin();
        EncryptDescryptString encryptDescryptString =  new EncryptDescryptString();
        boolean resul = false;
        
        login.setUser(request.getParameter("username"));
        login.setPass(request.getParameter("password"));
        login.setIdEmpresa(Integer.parseInt(request.getParameter("empresa")));

        login = daoLogin.login(login.getUser());
        
        try {
            System.out.println(encryptDescryptString.DescryptString("0xB0E24FEB69AAF8DDF53B2A81DF8BC875".getBytes()));
            System.out.println(Arrays.toString(login.getPassEncrypt()));
            
            if(encryptDescryptString.DescryptString(login.getPassEncrypt()).equals(login.getPass())){
                resul = true;
            }
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("user", login);

        if (resul) {
            dispatcher = request.getRequestDispatcher("dashboard.jsp");
            System.out.println("access");
        } else {
            dispatcher = request.getRequestDispatcher("dashboard.jsp");
            System.out.println("error");
        }
        dispatcher.forward(request, response);

    }

}
