/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DaoMaterial;
import Dao.DaoRequisicion;
import Models.Requisicion;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Programador 1
 */
public class RequisicionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Requisicion requisicion = new Requisicion();
        DaoRequisicion daoRequisicion = new DaoRequisicion();
        Map<String, Object> map;
        int caso = Integer.parseInt(request.getParameter("caso"));

        requisicion.setCc_requisicion(request.getParameter("centroCosto"));
        switch (caso) {

            case 1:
                requisicion.setEmp_requisicion(Integer.parseInt(request.getParameter("idEmpresa")));
                requisicion.setClase_requisicion(request.getParameter("clasificacion"));
                requisicion.setFecha_requisicion(Date.valueOf(request.getParameter("fechaRequicion")));
                requisicion.setTipo_requisicion(request.getParameter("tipo"));
                requisicion.setObs_requisicion(request.getParameter("observacion"));
                requisicion.setInterno_requisicion(request.getParameter("numInterno"));
                requisicion.setUser_rq(request.getParameter("user"));
                map = daoRequisicion.saveRequisicion(requisicion);
                white(response, map);
                break;
            case 2:
                requisicion.setCc_requisicion(request.getParameter("numRequicion"));        
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoMaterial daoMaterial = new DaoMaterial();
        Map<String, Object> map = null;
        int tipo;
        String codigo;

        tipo = Integer.parseInt(request.getParameter("tipo"));

        if (tipo == 1) {
            codigo = request.getParameter("codigo");
            map = daoMaterial.getMaterial(codigo);
        }

        white(response, map);
    }

    private void white(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }

}
