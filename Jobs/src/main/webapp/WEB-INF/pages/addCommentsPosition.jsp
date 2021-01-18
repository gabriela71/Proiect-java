<%-- 
    Document   : commentsPosition
    Created on : 10-Jan-2021, 21:51:58
    Author     : Andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Comments Position">
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/CommentsPosition">
        <div class="form-group">
            <label for="comentariu"><strong><fmt:message key="write"/></strong></label>
            <input type="text" id="text" name="comentariu" class="form-control" /> 
        </div>
        <input type="hidden" name="position_id" value="${position.id}" />
        <input type="hidden" name="user_id" value="${user.id}" />
        <button class="btn btn-dark btn-lg btn-block" type="submit"><fmt:message key="submit"/></button>

    </form>

</t:pageTemplate>