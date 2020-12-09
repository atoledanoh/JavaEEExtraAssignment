/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.dataccess;

import com.nbcc.models.Country;
import com.nbcc.models.District;
import com.nbcc.models.FailedToMaintainException;
import com.nbcc.models.FailedToRetrieveException;
import java.util.List;

/**
 *
 * @author Alejandro Toledano 
 */
public interface DistrictRepo {

    public District insertDistrict(District district) throws FailedToMaintainException;

    public List<Country> getCountryList() throws FailedToRetrieveException;
}
