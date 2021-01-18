/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Programador 1
 */
public class Requisicion {

    private int emp_requisicion;
    private String cc_requisicion;
    private String num_requisicion;
    private Date fecha_requisicion;
    private String tipo_requisicion;
    private String estado_requisicion;
    private String obs_requisicion;
    private Date fecha_ap;
    private String user_ap;
    private String clase_requisicion;
    private String user_rq;
    private String interno_requisicion;
    private DefaultTableModel modelo;

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public int getEmp_requisicion() {
        return emp_requisicion;
    }

    public void setEmp_requisicion(int emp_requisicion) {
        this.emp_requisicion = emp_requisicion;
    }

    public String getCc_requisicion() {
        return cc_requisicion;
    }

    public void setCc_requisicion(String cc_requisicion) {
        this.cc_requisicion = cc_requisicion;
    }

    public String getNum_requisicion() {
        return num_requisicion;
    }

    public void setNum_requisicion(String num_requisicion) {
        this.num_requisicion = num_requisicion;
    }

    public Date getFecha_requisicion() {
        return fecha_requisicion;
    }

    public void setFecha_requisicion(Date fecha_requisicion) {
        this.fecha_requisicion = fecha_requisicion;
    }

    public String getTipo_requisicion() {
        return tipo_requisicion;
    }

    public void setTipo_requisicion(String tipo_requisicion) {
        this.tipo_requisicion = tipo_requisicion;
    }

    public String getEstado_requisicion() {
        return estado_requisicion;
    }

    public void setEstado_requisicion(String estado_requisicion) {
        this.estado_requisicion = estado_requisicion;
    }

    public String getObs_requisicion() {
        return obs_requisicion;
    }

    public void setObs_requisicion(String obs_requisicion) {
        this.obs_requisicion = obs_requisicion;
    }

    public Date getFecha_ap() {
        return fecha_ap;
    }

    public void setFecha_ap(Date fecha_ap) {
        this.fecha_ap = fecha_ap;
    }

    public String getUser_ap() {
        return user_ap;
    }

    public void setUser_ap(String user_ap) {
        this.user_ap = user_ap;
    }

    public String getClase_requisicion() {
        return clase_requisicion;
    }

    public void setClase_requisicion(String clase_requisicion) {
        this.clase_requisicion = clase_requisicion;
    }

    public String getUser_rq() {
        return user_rq;
    }

    public void setUser_rq(String user_rq) {
        this.user_rq = user_rq;
    }

    public String getInterno_requisicion() {
        return interno_requisicion;
    }

    public void setInterno_requisicion(String interno_requisicion) {
        this.interno_requisicion = interno_requisicion;
    }

}
