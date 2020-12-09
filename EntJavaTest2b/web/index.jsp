<%-- 
    Document   : index
    Created on : Mar 26, 2019, 1:10:52 PM
    Author     : Chris.Cusack
--%>

<%@page import="com.nbcc.models.Country"%>
<%@page import="com.nbcc.models.ViewModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    ViewModel viewModel = (ViewModel)request.getAttribute("ViewModel");

    if (viewModel == null) {
        response.sendRedirect("/EntJavaTest2b/home");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>District Creation</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    </head>
    <body class="m-5">
        <h1>Create a District</h1>
        <form action="home" method="post">
            <table class="table table-striped">
                <tr>
                    <td>District Name:</td>
                    <td><input type="text" name="txtDistrictName" /></td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td>
                        <select name="ddlCountry">
                            <option value="">--Select a Country--</option>
                            <% for (Country c : viewModel.getCountries()) {%>
                            <option value="<%= c.getCode()%>"><%= c.getName()%></option>
                            <% }%>
                        </select>                  
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="btnCreateDistrict" value="Create District" class="btn btn-primary" /></td>
                </tr>
            </table>
        </form>
        <c:if test="<%= viewModel.showErrors()%>">
            <ul class="alert alert-danger" role="alert">
                <% for (String err : viewModel.getErrors()) {%>
                <li> <%= err%></li>
                    <% }%>
            </ul>
        </c:if> 
    </body>
</html>
