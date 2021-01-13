/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Dao.DaoBusiness;
import Models.Business;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Programador 1
 */
@WebService(serviceName = "LoginWebService")
public class LoginWebService {
    
    DaoBusiness daoBusiness =  new DaoBusiness();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "loadBusiness")
    public List<Business> loadBusiness() {
        return daoBusiness.listBusiness();
    }

}
