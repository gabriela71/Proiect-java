<%-- 
    Document   : editUser
    Created on : Jan 15, 2021, 12:47:48 PM
    Author     : Gabriela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="EditUsers">
<h1><fmt:message key="edituser"/></h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="nume"><fmt:message key="surname"/></label>
                <input type="text" class="form-control" id="nume" name="nume" placeholder="<fmt:message key="surname"/>" value="${user.nume}" required>
                <div class="invalid-feedback">
                    Please enter your Last Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="prenume"><fmt:message key="forename"/></label>
                <input type="text" class="form-control" id="prenume" name="prenume" placeholder="<fmt:message key="forename"/>" value="${user.prenume}" required>
                <div class="invalid-feedback">
                    Please enter your First Name.
                </div>
            </div>
        </div>        
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="phone"><fmt:message key="phone"/></label>
                <input type="text" class="form-control" id="nrTelefon" name="nrTelefon" placeholder="<fmt:message key="phone"/>" value="${user.nrTelefon}" required>
                <div class="invalid-feedback">
                    Please enter your Phone Number.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="mobile"><fmt:message key="mobile"/></label>
                <input type="text" class="form-control" id="nrMobil" name="nrMobil" placeholder="<fmt:message key="mobile"/>" value="${user.nrMobil}" required>
                <div class="invalid-feedback">
                    Please enter your Mobile Number.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="email"><fmt:message key="email"/></label>
                <input type="text" class="form-control" id="email" name="email" placeholder="<fmt:message key="email"/>" value="${user.email}" required>
                <div class="invalid-feedback">
                    Please enter your Email.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="positionName"><fmt:message key="positionName"/></label>
                <input type="text" class="form-control" id="pozitie" name="pozitie" placeholder="<fmt:message key="positionName"/>" value="${user.pozitie}" required>
                <div class="invalid-feedback">
                    Please enter your Position.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="username"><fmt:message key="username"/></label>
                <input type="text" class="form-control" id="username" name="username" placeholder="<fmt:message key="username"/>" value="${user.username}" disabled>
            </div>
        </div>  
        <input type="hidden" name="users_ids" value="${user.id}" />
        <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="submit"/></button>        
    </form>
   <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () 
        {
            'use strict'

            window.addEventListener('load', function () 
            {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');

                // Loop over them and prevent submission
                Array.prototype.filter.call(forms, function (form) 
                {
                    form.addEventListener('submit', function (event) 
                    {
                        if (form.checkValidity() === false) 
                        {
                            event.preventDefault();
                            event.stopPropagation();
                        }

                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
         
</t:pageTemplate>