<%-- 
    Document   : browseJobs
    Created on : Jan 6, 2021, 11:45:27 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Jobs">
    <form method="POST" action="${pageContext.request.contextPath}/Jobs">
       
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
                        <div class="mb-1 text-muted"><fmt:message key="availableJobs"/>: ${position.nrPersoaneCautate-position.nrPersoaneAprobate}</div>
                        <p class="card-text mb-auto ">${position.responsabilitati}</p>                                            
                        <br>
                        <p class="card-text mb-auto">${position.beneficii}</p>      
                        <c:if test="${pageContext.request.isUserInRole('ClientRole')}">
                            <button class="btn btn-primary  btn-lg btn-block" type="submit" name="position_id" value="${position.id}"><fmt:message key="apply"/></button>                       
                        </c:if>            
                    </div>
                </div>
            </div>          
            </div>                     
        </c:forEach>      
    </form> 
</t:pageTemplate>
