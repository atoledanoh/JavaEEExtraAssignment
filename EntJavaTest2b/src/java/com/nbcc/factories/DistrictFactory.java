/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.factories;

import com.nbcc.dataccess.DistrictRepo;
import com.nbcc.dataccess.MySqlDistricts;

/**
 *
 * @author Alejandro Toledano 
 */
public class DistrictFactory {

    public static DistrictRepo createDistrictRepo() {
        return new MySqlDistricts();
    }
}
