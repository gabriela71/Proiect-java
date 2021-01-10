<%-- 
    Document   : pozitiiNeaprobate
    Created on : Jan 10, 2021, 3:21:28 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="PendingPositions">
    <form method="POST" action="${pageContext.request.contextPath}/PendingPositions">
        <h1>Pozitii in curs de aprobare</h1>
        <c:forEach var="position" items="${positions}" varStatus="status">
            <div class="row mb-2 ">           
            <div class="col-md-12 ">
                <div class="card flex-md-row mb-4 box-shadow h-md-250 ">
                    <div class="card-body d-flex flex-column align-items-start text-truncate">
                        <strong class="d-inline-block mb-2 text-primary">${position.cerinte}</strong>
                        <strong class="d-inline-block mb-2 text-secondary">${position.departament}</strong>
                        <h3 class="mb-0">
                            <div class="text-dark" >${position.denumire}</div>
                        </h3>
                        <div class="mb-1 text-muted">Numar persoane cautate:${position.nrPersoaneCautate}</div>                        
                        <p class="card-text mb-auto ">${position.responsabilitati}</p>                                            
                        <br>
                        <p class="card-text mb-auto">${position.beneficii}</p>
                        <button class="btn btn-primary btn-lg btn-block" type="submit" name="approve" value="${position.id}">Aproba</button>
                        <button class="btn btn-danger btn-lg btn-block" type="submit" name="delete" value="${position.id}">Delete</button>
                    </div>                                      
                </div>
            </div>            
            </div>                       
        </c:forEach>       
    </form> 
</t:pageTemplate>

