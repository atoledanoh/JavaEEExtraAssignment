/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.models;

/**
 *
 * @author serap
 */
public class FailedToRetrieveException extends Exception{
    
    public FailedToRetrieveException(){
        super();
    }
    
    public FailedToRetrieveException(String message){
        super(message);
    }
    
    public FailedToRetrieveException(String message, Throwable cause){
        super(message, cause);
    }
}
