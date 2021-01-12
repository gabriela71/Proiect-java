
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-md navbar-dark bg-primary  ">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Jobs</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${activePage eq 'Register' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Register">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Jobs">Jobs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Positions">Positions</a>
            </li> 
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/PendingPositions">Pending Positions</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/InactivePositions">Inactive Positions</a>
            </li> 

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Comments">Comments</a>
            </li> 
            <li class="nav-item ${activePage eq 'Applicants' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/Applicants">Applicants</a>
            </li>
            <li class="nav-item ${activePage eq 'Proposed' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/Proposed">Proposed</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/CandidateProfile">My Profile</a>
            </li>
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