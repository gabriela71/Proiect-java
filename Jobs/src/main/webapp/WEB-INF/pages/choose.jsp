<%-- 
    Document   : cars
    Created on : Nov 6, 2020, 8:31:26 AM
    Author     : Gabriela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />
<t:pageTemplate pageTitle="Elected Candidate">
    <h1><fmt:message key="Elected"/></h1>
    <form method="POST" action="${pageContext.request.contextPath}/Choose">
      <div class="row">
                <div class="col-md-1">
                    <h6><fmt:message key="surname"/></h6>
                </div>
                <div class="col-md-1">
                    <h6><fmt:message key="forename"/></h6>
                </div>
                <div class="col-md-1">
                   <h6><fmt:message key="phone"/></h6>
                </div>
                <div class="col-md-1">
                   <h6><fmt:message key="mobile"/></h6>
                </div>
                <div class="col-md-2">
                   <h6><fmt:message key="email"/></h6>
                </div>
                <div class="col-md-1">
                   <h6><fmt:message key="positionName"/></h6>
                </div>
                <div class="col-md-1">
                   <h6><fmt:message key="positionDepartment"/></h6>
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
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/CreateUser?id=${aplicant.id}" role="button"><fmt:message key="create"/></a>
                </div>
                <div>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Detalii?id=${aplicant.id}" role="button"><fmt:message key="details"/></a>
                </div>
            </div>
        </c:forEach>
    </form>
   </t:pageTemplate>
