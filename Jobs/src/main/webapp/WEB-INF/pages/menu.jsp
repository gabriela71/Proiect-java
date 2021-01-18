
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-md navbar-dark bg-primary  ">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${activePage eq 'Register' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/About">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Register">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Jobs">Jobs</a>
            </li>
            
            <c:if test="${pageContext.request.isUserInRole('PositionRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Positions">Positions</a>
                </li> 
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('DirectorGeneralRole')}">    
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/PendingPositions">Pending Positions</a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('PositionRole')}"> 
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/InactivePositions">Inactive Positions</a>
                </li> 
            
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/CommentsMenu">Comments</a>
                </li> 
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('RecruiterRole')}">
                <li class="nav-item ${activePage eq 'Applicants' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Applicants">Applicants</a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('PositionRole')}">
                <li class="nav-item ${activePage eq 'Proposed' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Proposed">Proposed Candidate</a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                <li class="nav-item ${activePage eq 'Choose' ? ' active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Choose">Elected Candidate</a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('CandidateRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/CandidateProfile">My Profile</a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/User">Users</a>
                </li>
            </c:if>
        </ul>
            
        <ul class="navbar-nav m1-auto">
            
            <form method="POST" action="${pageContext.request.contextPath}/ChangeLanguage">
                <select id="language" name="language" onchange="submit()">
                 <option value="">Language</option>
                 <option value="en" ${language eq 'en' ? ' selected' : ''}>English</option>
                 <option value="ro" ${language eq 'ro' ? ' selected' : ''}>Romanian</option>
                 <option value="de" ${language eq 'de' ? ' selected' : ''}>German</option>
             </select>
            </form>

            <li class="nav-item">
                <c:choose>
                    <c:when test="${pageContext.request.getRemoteUser()==null}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                    </c:otherwise>
                </c:choose>
            </li>    
        </ul>    
    </div>
</nav>