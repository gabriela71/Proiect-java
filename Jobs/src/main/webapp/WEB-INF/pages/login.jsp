<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />


<t:pageTemplate pageTitle="Login">
        <c:if test="${message!= null}">
        <div class="alery alert-warning" role="alert">
        ${message}
        </div>
        </c:if>
    <form class="form-signin"  method="POST" action="j_security_check">
        <h1 class="h3 md-3 front-weight-normal"><fmt:message key="signin"/></h1>
        
        <label for="username" class="sr-only"><fmt:message key="username"/></label>
        <input type="text" id="username" name="j_username" class="form-control" placeholder=<fmt:message key="username"/> required autofocus>
        <label for="password" class="sr-only"><fmt:message key="password"/></label>
        <input type="password" id="password" name="j_password" class="form-control" placeholder=<fmt:message key="password"/> required>
                
        <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="signin"/></button>
        <p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>
    </form> 
       
</t:pageTemplate>