/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DaoRequisicion;
import Models.Requisicion;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Programador 1
 */
@WebServlet(name = "RequisicionController", urlPatterns = {"/Requisicion"})
public class RequisicionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Requisicion requisicion = new Requisicion();
        DaoRequisicion daoRequisicion = new DaoRequisicion();
        Map<String, Object> map = new HashMap<>();

        boolean isValid;

        requisicion.setEmp_requisicion(Integer.parseInt(request.getParameter("idEmpresa")));
        requisicion.setCc_requisicion(request.getParameter("CentroCosto"));
        requisicion.setClase_requisicion(request.getParameter("clasificacion"));
        requisicion.setFecha_ap(Date.valueOf(request.getParameter("fechaRequicion")));
        requisicion.setTipo_requisicion(request.getParameter("tipo"));
        requisicion.setObs_requisicion(request.getParameter("observacion"));
        requisicion.setUser_rq(request.getParameter("User"));

        isValid = daoRequisicion.saveRequisicion(requisicion);

        map.put("isValid", isValid);

        white(response, map);
    }

    private void white(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }

}
