/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DaoLogin;
import Models.Login;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Programador 1
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        Login login = new Login();
        DaoLogin daoLogin = new DaoLogin();

        login.setUser(request.getParameter("username"));
        login.setPass(request.getParameter("password"));
        login.setIdEmpresa(0);
        login.setEmpresa(request.getParameter("Empresa"));

        daoLogin.login(login);

        request.setAttribute("user", login);

        if ("".equals(login.getTipo())) {
            dispatcher = request.getRequestDispatcher("dashboard.jsp"); 
        } else {
            dispatcher = request.getRequestDispatcher("dashboard.jsp");
        }
        dispatcher.forward(request, response);
    }
}
