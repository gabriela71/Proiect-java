<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Suggest Candidate">
    <h1><fmt:message key="Suggest"/></h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Suggest">
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="nume"><fmt:message key="surname"/></label>
                <input type="text" class="form-control" id="nume" name="nume" placeholder="<fmt:message key="surname"/>" value="${aplicant.nume}" disabled>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="prenume"><fmt:message key="forename"/></label>
                <input type="text" class="form-control" id="prenume" name="prenume" placeholder="<fmt:message key="forename"/>" value="${aplicant.prenume}" disabled>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="phone"><fmt:message key="phone"/></label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="<fmt:message key="phone"/>" value="${aplicant.nrTelefon}" disabled>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="mobile"><fmt:message key="mobile"/></label>
                <input type="text" class="form-control" id="mobile" name="mobile" placeholder="<fmt:message key="mobile"/>" value="${aplicant.nrMobil}" disabled>
            </div>    
        </div>
            <div class="row">
            <div class="col-md-8 mb-3">
                <label for="email"><fmt:message key="email"/></label>
                <input type="text" class="form-control" id="email" name="email" placeholder="<fmt:message key="email"/>" value="${acaplicant.email}" disabled>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="positionName"><fmt:message key="positionName"/></label>
                <input type="text" class="form-control" id="positionName" name="positionName" placeholder="<fmt:message key="positionName"/>" value="${acaplicant.denumire}" disabled>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="positionDepartment"><fmt:message key="positionDepartment"/></label>
                <input type="text" class="form-control" id="positionDepartment" name="positionDepartment" placeholder="<fmt:message key="positionDepartment"/>" value="${aplicant.departament}" disabled>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="dataInterviu"><fmt:message key="dataInterviu"/></label>
                <input type="date" class="form-control" id="dataInterviu" name="dataInterviu" required>
                <div class="invalid-feedback">
                    <fmt:message key="SelectDate"/>
                </div>
            </div>    
        </div>
        <input type="hidden" name="aplicant_id" value="${aplicant.id}" />
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