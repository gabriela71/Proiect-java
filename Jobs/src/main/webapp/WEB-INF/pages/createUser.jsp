<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Create user">
    <h1><fmt:message key="create"/></h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/CreateUser">
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="nume"><fmt:message key="surname"/></label>
                <input type="text" class="form-control" id="nume" name="nume" placeholder="<fmt:message key="surname"/>" value="${aplicant.nume}" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqNume"/>.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="prenume"><fmt:message key="forename"/></label>
                <input type="text" class="form-control" id="prenume" name="prenume" placeholder="<fmt:message key="forename"/>" value="${aplicant.prenume}" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqPrenume"/>.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="phone"><fmt:message key="phone"/></label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="<fmt:message key="phone"/>" value="${aplicant.nrTelefon}" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqPhone"/>.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="mobile"><fmt:message key="mobile"/></label>
                <input type="text" class="form-control" id="mobile" name="mobile" placeholder="<fmt:message key="mobile"/>" value="${aplicant.nrMobil}" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqMobile"/>.
                </div>
            </div>    
        </div>
            <div class="row">
            <div class="col-md-8 mb-3">
                <label for="email"><fmt:message key="email"/></label>
                <input type="text" class="form-control" id="email" name="email" placeholder="<fmt:message key="email"/>" value="${acaplicant.email}" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqEmail"/>.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="positionName"><fmt:message key="positionName"/></label>
                <input type="text" class="form-control" id="positionName" name="positionName" placeholder="<fmt:message key="positionName"/>" value="${acaplicant.denumire}" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqPosition"/>.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="username"><fmt:message key="username"/></label>
                <input type="text" class="form-control" id="username" name="username" placeholder="<fmt:message key="username"/>" value="?" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqUsername"/>.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="password"><fmt:message key="password"/></label>
                <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqPassword"/>.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="password"><fmt:message key="confirmpassword"/></label>
                <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
                <div class="invalid-feedback">
                    <fmt:message key="reqPassword"/>.
                </div>
            </div>    
        </div>
        <div class="row">
            <div class="col-md-8 mb-3">
                <label for="rol"><fmt:message key="rol"/></label>
                <select class="custom-select d-block w-100" id="rol" name="rol" required>
                    <option value=""><fmt:message key="rol"/><fmt:message key="choose"/></option>
                    <option value="ADMIN"><fmt:message key="admin"/></option>
                    <option value="USER"><fmt:message key="client"/></option>
                    <option value="DD"><fmt:message key="dd"/></option>
                    <option value="DG"><fmt:message key="dg"/></option>
                    <option value="HR"><fmt:message key="hr"/></option>
                    <option value="RECRUITER"><fmt:message key="recruiter"/></option>
                </select>
                <div class="invalid-feedback">
                    <fmt:message key="reqRol"/>
                </div>
            </div>
        </div>
        <input type="hidden" name="aplicant_id" value="${aplicant.id}" />
        <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="save"/></button>
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
