<%-- 
    Document   : menu
    Created on : 27-Dec-2020, 19:39:45
    Author     : Andrei
--%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Jobs Recruting</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${pageContext.request.requestURI eq '/JobsRecruting/about.jsp' ? ' active ' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About</a>
            </li>

            <li class="nav-item active">
                <a class="nav-link" href="#">New account</a>
            </li>
       
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Select Language</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">English</a>
                    <a class="dropdown-item" href="#">French</a>
                    <a class="dropdown-item" href="#">Romanian</a>
                    <a class="dropdown-item" href="#">Germany</a>
                    <a class="dropdown-item" href="#">Spanish</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav m1-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
            </li>
        </ul>
    </div>
</nav>