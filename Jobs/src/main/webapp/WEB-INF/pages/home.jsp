<%-- 
    Document   : home
    Created on : 16-Jan-2021, 13:27:29
    Author     : Andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.project.i18n.language" />


<t:pageTemplate pageTitle="Home">
    <div class="container-fluid">

        <center>
        <c:choose>
            <c:when test="${pageContext.request.getRemoteUser()!=null}">
                <h1><fmt:message key="welcome"/>,${pageContext.request.getRemoteUser()}</h1>
            </c:when>
            <c:otherwise>
                <h1><fmt:message key="welcome"/></h1>
            </c:otherwise>
        </c:choose>
        </center>      
    </div>
</t:pageTemplate>