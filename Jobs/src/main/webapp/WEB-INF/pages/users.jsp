<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />
 <t:pageTemplate pageTitle="Users">
     <h1><fmt:message key="dateusers"/></h1>
     <form method="POST" action="${pageContext.request.contextPath}/User">
         <div class="row">
            <div class="col-md-1">
                <h6></h6>
            </div>
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
            <div class="col-md-3">
                <h6><fmt:message key="positionName"/></h6>
            </div>
            <div class="col-md-1">
                <h6><fmt:message key="username"/></h6>
            </div>
        </div>
        <c:forEach var="user" items="${users}" varStatus="status">  
             <div class="row">
                <div class="col-md-1">
                    <input type="checkbox" name="user_ids" value="${user.id}"/>
                </div>
                <div class="col-md-1">
                   ${user.nume} 
                </div>
                <div class="col-md-1">
                   ${user.prenume} 
                </div>
                <div class="col-md-1">
                   ${user.nrTelefon} 
                </div>
                <div class="col-md-1">
                   ${user.nrMobil} 
                </div>
                <div class="col-md-2">
                   ${user.email} 
                </div>
                <div class="col-md-3">
                   ${user.pozitie} 
                </div>
                <div class="col-md-1">
                   ${user.username} 
                </div>
                <div>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}" role="button"><fmt:message key="editeaza"/></a>
                </div>
            </div>    
        </c:forEach>
        <div class="row">
            <button class="btn btn-danger" type="submit"> <fmt:message key="delete"/> </button>
        </div>
    </form>
 </t:pageTemplate>
