<%-- 
    Document   : comments
    Created on : 10-Jan-2021, 21:11:39
    Author     : Andrei
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Comments">
    <form method="POST" action="${pageContext.request.contextPath}/Comments Position">
        <br>

        <c:forEach var="position" items="${positions}" varStatus="status">
            <div class="row mb-2 ">           
                <div class="col-md-12 ">
                    <div class="card flex-md-row mb-4 box-shadow h-md-250 ">
                        <div class="card-body d-flex flex-column align-items-start text-truncate">

                            <h3 class="mb-0">
                                <div class="text-dark" >${position.denumire}</div>
                            </h3>         
                                <a class="btn btn-dark btn-lg btn-block" href="${pageContext.request.contextPath}/CommentsPosition?id_pozitie=${position.id}&?id_user=${user.id}" role="button"><fmt:message key="buttonAddComments"/></a>                                     
                        </div>
                    </div>
                </div>

            </div>          
        </c:forEach>
    </form> 
</t:pageTemplate>