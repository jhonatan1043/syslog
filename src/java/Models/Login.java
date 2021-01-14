/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Programador 1
 */
public class Login {

    private String user;
    private String pass;
    private String tipo;
    private int idEmpresa;
    private String Empresa;
    private byte[] passEncrypt;

    public byte[] getPassEncrypt() {
        return passEncrypt;
    }

    public void setPassEncrypt(byte[] passEncrypt) {
        this.passEncrypt = passEncrypt;
    }
    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Login{" + "user=" + user + ", pass=" + pass + ", tipo=" + tipo + ", idEmpresa=" + idEmpresa + ", Empresa=" + Empresa + '}';
    }
}
