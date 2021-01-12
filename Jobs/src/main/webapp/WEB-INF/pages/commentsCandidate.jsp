<%-- 
    Document   : commentsCandidate
    Created on : 12-Jan-2021, 23:10:40
    Author     : Andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Comments Candidate">
    <form method="POST" action="${pageContext.request.contextPath}/CommentsCandidate">
        <br>

        <c:forEach var="candidate" items="${candidate}" varStatus="status">
            <div class="row mb-2 ">           
                <div class="col-md-12 ">
                    <div class="card flex-md-row mb-4 box-shadow h-md-250 ">
                        <div class="card-body d-flex flex-column align-items-start text-truncate">

                            <h3 class="mb-0">
                                <div class="text-dark" >${candidate.username}</div>
                            </h3>         
                            <a class="btn btn-dark btn-lg btn-block" href="${pageContext.request.contextPath}/AddCommentsCandidate?id_candidate=${candidate.id}&?id_user=${user.id}" role="button">Adauga comentariu</a>                                     
                        </div>
                    </div>
                </div>

            </div>          
        </c:forEach>
    </form> 
</t:pageTemplate>