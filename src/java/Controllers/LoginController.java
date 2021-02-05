/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DaoLogin;
import Models.Login;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        Map <String, Object> map = new HashMap<>();
        HttpSession sesion = request.getSession();
        
        boolean isValid = false;
        
        Login login = new Login();
        DaoLogin daoLogin = new DaoLogin();
        
        login.setUser(request.getParameter("username"));
        login.setPass(request.getParameter("password"));
        login.setIdEmpresa(Integer.parseInt(request.getParameter("empresa")));

        login = daoLogin.login(login);

        if (login.getTipo() != null) {
           isValid = true;
           map.put("user", login);
           sesion.setAttribute("idEmpresa", login.getEmpresa());
        } 
        
        map.put("isValid", isValid);
        
        white(response,map);
    }

    private void white(HttpServletResponse response, Map<String, Object> map) throws IOException {
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write(new Gson().toJson(map));
    }


}
