<%-- 
    Document   : cars
    Created on : Nov 6, 2020, 8:31:26 AM
    Author     : Gabriela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Proposed">
    <h1>Candidates who proposed</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Applicants">
       <div class="row">
                <div class="col-md-1">
                    <h6>Last Name</h6>
                </div>
                <div class="col-md-1">
                    <h6>First Name</h6>
                </div>
                <div class="col-md-1">
                   <h6>Telephone number </h6>
                </div>
                <div class="col-md-1">
                   <h6>Mobile number </h6>
                </div>
                <div class="col-md-2">
                   <h6>Email</h6>
                </div>
                <div class="col-md-1">
                   <h6>Position Name </h6>
                </div>
                <div class="col-md-1">
                   <h6>Position Department </h6>
                </div>
        </div>
        <c:forEach var="aplicant" items="${aplicanti}" varStatus="status">  
            <div class="row">
                <div class="col-md-1">
                   ${aplicant.nume} 
                </div>
                <div class="col-md-1">
                   ${aplicant.prenume} 
                </div>
                <div class="col-md-1">
                   ${aplicant.nrTelefon} 
                </div>
                <div class="col-md-1">
                   ${aplicant.nrMobil} 
                </div>
                <div class="col-md-2">
                   ${aplicant.email} 
                </div>
                <div class="col-md-1">
                   ${aplicant.denumire} 
                </div>
                <div class="col-md-1">
                   ${aplicant.departament} 
                </div>
                <div>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/suggest.jsp?id=${aplicant.id}" role="button">Choose</a>
                </div>
                <div>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/delete.jsp?id=${aplicant.id}" role="button">Delete</a>
                </div>
            </div>
        </c:forEach>
     </form>
   </t:pageTemplate>
