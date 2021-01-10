<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-md navbar-dark bg-primary  ">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${activePage eq 'About' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Register">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Jobs">Jobs</a>
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
            <li class="nav-item ${activePage eq 'Choose' ? ' active' : ''}">
              <a class="nav-link" href="${pageContext.request.contextPath}/Choose">Choose</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Select Language</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#"><i class="gb uk flag"></i>English</a>
                    <a class="dropdown-item" href="#"><i class="ro flag"></i>Romanian</a>
                    <a class="dropdown-item" href="#"><i class="de flag"></i>German</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav m1-auto">
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