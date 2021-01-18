
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />


<nav class="navbar navbar-expand-md navbar-dark bg-primary  ">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Jobs</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${activePage eq 'Register' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp"><fmt:message key="about"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Register"><fmt:message key="register"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Jobs"><fmt:message key="jobs"/></a>
            </li>
            
            <c:if test="${pageContext.request.isUserInRole('PositionRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Positions"><fmt:message key="position"/></a>
                </li> 
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('DirectorGeneralRole')}">    
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/PendingPositions"><fmt:message key="pendingPosition"/></a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('PositionRole')}"> 
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/InactivePositions"><fmt:message key="inactivePosition"/></a>
                </li> 
            
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/CommentsMenu"><fmt:message key="comments"/></a>
                </li> 
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('RecruiterRole')}">
                <li class="nav-item ${activePage eq 'Applicants' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Applicants"><fmt:message key="applicants"/></a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('PositionRole')}">
                <li class="nav-item ${activePage eq 'Proposed' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Proposed"><fmt:message key="proposed"/></a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                <li class="nav-item ${activePage eq 'Choose' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Choose"><fmt:message key="elected"/></a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('CandidateRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/CandidateProfile"><fmt:message key="profile"/></a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/User"><fmt:message key="users"/></a>
                </li>
            </c:if>
        </ul>
            
        <ul class="navbar-nav m1-auto">
            
            <form method="POST" action="${pageContext.request.contextPath}/ChangeLanguage">
                <select id="language" name="language" onchange="submit()">                
                 <option value="en" ${language eq 'en' ? ' selected' : ''}>English</option>
                 <option value="ro" ${language eq 'ro' ? ' selected' : ''}>Romanian</option>
                 <option value="de" ${language eq 'de' ? ' selected' : ''}>German</option>
             </select>
            </form>

            <li class="nav-item">
                <c:choose>
                    <c:when test="${pageContext.request.getRemoteUser()==null}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Login"><fmt:message key="login"/></a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="${pageContext.request.contextPath}/Logout"><fmt:message key="logout"/></a>
                    </c:otherwise>
                </c:choose>
            </li>    
        </ul>    
    </div>
</nav>