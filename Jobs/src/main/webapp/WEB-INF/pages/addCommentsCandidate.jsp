<%-- 
    Document   : addCommentsCandidate
    Created on : 12-Jan-2021, 23:19:57
    Author     : Andrei
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:pageTemplate pageTitle="Comments Candidate">
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCommentsCandidate">
        <div class="form-group">
            <label for="comentariu"><strong><p class="text-center">Write a comment:</p></strong></label>
            <input type="text" name="comentariu" />
        </div>
        <input type="hidden" name="candidate_id" value="${candidate.id}" />
        <input type="hidden" name="user_id" value="${user.id}" />
        <button class="btn btn-dark btn-lg btn-block" type="submit">Submit</button>

    </form>

</t:pageTemplate>