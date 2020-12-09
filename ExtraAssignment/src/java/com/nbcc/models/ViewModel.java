/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serap
 */
public class ViewModel {

    private List<String> errors;

    private District district;

    private List<Country> countries;

    public ViewModel() {
        countries = new ArrayList<Country>();
        errors = new ArrayList<String>();
    }

    /**
     * Get the value of countries
     *
     * @return the value of countries
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * Set the value of countries
     *
     * @param countries new value of countries
     */
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void addError(String errorMessage) {
        errors.add(errorMessage);
    }

    public boolean showErrors() {
        return errors.size() > 0;
    }

    /**
     * Get the value of errors
     *
     * @return the value of errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Set the value of errors
     *
     * @param errors new value of errors
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    /**
     * Get the value of district
     *
     * @return the value of district
     */
    public District getDistrict() {
        return district;
    }

    /**
     * Set the value of district
     *
     * @param district new value of district
     */
    public void setDistrict(District district) {
        this.district = district;
    }

}
