<%-- 
    Document   : commentsMenu
    Created on : 12-Jan-2021, 22:45:59
    Author     : Andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Comments">
    <form method="POST" action="${pageContext.request.contextPath}/Comments">

        <div class="row mb-2 ">           
            <div class="col-md-12 ">
                <div class="card flex-md-row mb-4 box-shadow h-md-250 ">
                    <div class="card-body d-flex flex-column align-items-start text-truncate">     
                        <a class="btn btn-dark btn-lg btn-block" href="${pageContext.request.contextPath}/Comments" role="button"><fmt:message key="addCommentsPosition"/></a>   
                        <a class="btn btn-dark btn-lg btn-block" href="${pageContext.request.contextPath}/CommentsCandidate" role="button"><fmt:message key="addCommentsCandidate"/></a>   
                    </div>
                </div>
            </div>

        </div>          

    </form> 
</t:pageTemplate>