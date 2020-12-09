<%-- 
    Document   : districtCreated
    Created on : Mar 27, 2019, 7:26:04 AM
    Author     : Chris.Cusack
--%>

<%@page import="com.nbcc.models.ViewModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ViewModel viewModel = null;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>District Created</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
    </head>
    <body class="m-5">
        <h1>District Created</h1>
        <p>Id: <%= viewModel.getDistrict().getId() %> </p>
        <p>Name: <%= viewModel.getDistrict().getName()%> </p>
        <p>Country Code: <%= viewModel.getDistrict().getCountryCode()%> </p>
        <a href="home" class="btn btn-primary">Create another district</a>
    </body>
</html>
