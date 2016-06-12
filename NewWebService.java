/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import File.TestParsingXmlWithSAX;
/**
 *
 * @author LENOVO
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserInformation")
    public String getUserInformation(@WebParam(name = "Id") int Id) {
        //TODO write your implementation code here:
		new TestParsingXmlWithSAX();
        
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllUserInfo")
    public String getAllUserInfo() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserBosName")
    public String getUserBosName() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPoints")
    public String getPoints(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return null;
    }

    
}
