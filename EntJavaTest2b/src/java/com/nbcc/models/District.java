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
public class District {

    private String Id;

    private String name;

    private String CountryCode;

    /**
     * Get the value of CountryCode
     *
     * @return the value of CountryCode
     */
    public String getCountryCode() {
        return CountryCode;
    }

    /**
     * Set the value of CountryCode
     *
     * @param CountryCode new value of CountryCode
     */
    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of Id
     *
     * @return the value of Id
     */
    public String getId() {
        return Id;
    }

    /**
     * Set the value of Id
     *
     * @param Id new value of Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

}
