package com.nbcc.dataccess;

import com.nbcc.models.District;
import com.nbcc.models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author serap
 */
public class MySqlDistricts implements DistrictRepo {

    protected static String url = "jdbc:mysql://localhost:3306/world?useSSL=false";
    protected static String userName = "root";
    protected static String password = "1234";

    public District insertDistrict(District district) throws FailedToMaintainException {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection(
                    url, userName, password)) {

                String query = "insert into district"
                        + "(Code, Name)"
                        + "Values (?,?);";

                try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                    pstmt.setString(1, district.getName());
                    pstmt.setString(2, district.getCountryCode());

                    int key = pstmt.executeUpdate();

                    district.setId(Integer.toString(key));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new FailedToMaintainException("Failed to Create District", e);
        } catch (Exception e) {
            throw new FailedToMaintainException("Something went wrong creating District", e);
        }

        return district;
    }

    public List<Country> getCountryList() throws FailedToRetrieveException {
        ArrayList<Country> countries = new ArrayList<Country>();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection(
                    url, userName, password)) {

                String query = "SELECT Code,Name FROM district ORDER BY Name;";

                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            Country country = ConvertToCountry(rs);
                            countries.add(country);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new FailedToRetrieveException("Failed to retrieve Countries", e);
        } catch (Exception e) {
            throw new FailedToRetrieveException("Something went wrong retrieving Countries", e);
        }

        return countries;
    }

    private Country ConvertToCountry(ResultSet rs) throws SQLException {

        Country country = new Country();

        country.setCode(rs.getString("Code"));
        country.setName(rs.getString("Name"));

        return country;
    }
}
