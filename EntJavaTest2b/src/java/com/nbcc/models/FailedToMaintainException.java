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
public class FailedToMaintainException extends Exception {

    private String id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    public FailedToMaintainException() {
        super();
    }

    public FailedToMaintainException(String message) {
        super(message);
    }
    
    public FailedToMaintainException(String message, String Id) {
        super(message);
        this.id = id;
    }

    public FailedToMaintainException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public FailedToMaintainException(String message, Throwable cause, String Id) {
        super(message, cause);
        this.id = id;
    }
}
