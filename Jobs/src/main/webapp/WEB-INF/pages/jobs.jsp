<%-- 
    Document   : browseJobs
    Created on : Jan 6, 2021, 11:45:27 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Jobs">
    <form method="POST" action="${pageContext.request.contextPath}/Jobs">
        <h1> probam</h1>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Aplica</button>
    </form> 
</t:pageTemplate>
