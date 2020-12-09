/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.controllers;

import com.nbcc.dataccess.DistrictFactory;
import com.nbcc.dataccess.DistrictRepo;
import com.nbcc.models.*;
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

    private DistrictRepo districtRepo;

    @Override
    public void init() throws ServletException {
        this.districtRepo = DistrictFactory.createDistrictRepo();
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

        //Insert Code here
        getCountryList(viewModel);

        try {
            getCountryList(viewModel);
        } catch (Exception e) {
        }
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
        District district = buildDistrict(request);

        //If the district object has an empty name, throw an “DistrictValidationException”
        //and set the message in the exception to indicate that the name cannot be empty
        try {
            validate(district);

            view = "/districtCreated.jsp";
            viewModel.setDistrict(district);
        } catch (DistrictValidationException e) {
            viewModel.addError(e.getMessage());

            // reload coountry list
            getCountryList(viewModel);

            view = "/index.jsp";
        }

        getServletContext().getRequestDispatcher(view).forward(request, response);
    }

    protected District buildDistrict(HttpServletRequest request) {
        District district = new District();

        district.setName(request.getParameter("txtDistrictName"));
        district.setCountryCode(request.getParameter("ddlCountry"));

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

    //added method to get the county list
    private void getCountryList(ViewModel viewModel) {
        List<Country> countriesList;

        try {
            countriesList = districtRepo.getCountryList();
            viewModel.setCountries(countriesList);
        } catch (FailedToRetrieveException e) {
            viewModel.addError(e.getMessage());
        }
    }
}
