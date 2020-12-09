/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.controllers;

import com.nbcc.factories.DistrictFactory;
import com.nbcc.models.District;
import com.nbcc.models.DistrictValidationException;
import com.nbcc.models.ViewModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Alejandro Toledano 
 */
public class WorldController extends HttpServlet {

    private District district;

    @Override
    public void init() throws ServletException {
        District district = (District) DistrictFactory.createDistrictRepo();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String view = "/index.jsp";
        ViewModel viewModel = new ViewModel();
        request.setAttribute("ViewModel", viewModel);

        List<District> districts;
        
//        try {
//            districts = DistrictFactory.createDistrictRepo();
//        } catch (Exception e) {
//        }

        getServletContext().getRequestDispatcher(view).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String view = "";
        ViewModel viewModel = new ViewModel();
        request.setAttribute("ViewModel", viewModel);

        // insert Code here
        getServletContext().getRequestDispatcher(view).forward(request, response);
    }

    protected District buildDistrict(HttpServletRequest request) {
        return district;
    }

    protected void validate(District district) throws DistrictValidationException {

        if (district.getName().equals("")) {
            throw new DistrictValidationException("District name cannot be empty");

        }
        if (district.getName().length() > 45) {
            throw new DistrictValidationException("District name can't exceed 45 characters.");
        }
        if (district.getCountryCode().equals("")) {
            throw new DistrictValidationException("Country code cannot be empty");
        }

    }
}
