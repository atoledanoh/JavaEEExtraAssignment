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
public class DistrictValidationException extends Exception {

    private District district;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public District getDistrict() {
        return this.district;
    }

    public DistrictValidationException() {
        super();
    }

    public DistrictValidationException(String message) {
        super(message);
    }

    public DistrictValidationException(String message, District district) {
        super(message);
        this.district = district;
    }
}
