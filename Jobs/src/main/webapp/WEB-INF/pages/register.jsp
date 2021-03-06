<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Register">
    
    <h1><fmt:message key="register"/></h1>

    <form class="needs-validation" novalidate method="POST" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/Register">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="prenume"><fmt:message key="forename"/></label>
                <input type="text" class="form-control" id="prenume" placeholder=""  required name="prenume">
                <div class="invalid-feedback">
                    Please enter your First Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nume"><fmt:message key="surname"/></label>
                <input type="text" class="form-control" id="nume" placeholder=""  required name="nume">
                <div class="invalid-feedback">
                    Please enter your Last Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nrTelefon"><fmt:message key="phone"/></label>
                <input type="text" class="form-control" id="nrTelefon" placeholder=""  required name="nrTelefon">
                <div class="invalid-feedback">
                    Please enter your Mobile Number.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nrTelefon"><fmt:message key="mobile"/></label>
                <input type="text" class="form-control" id="nrMobil" placeholder=""  required name="nrMobil">
                <div class="invalid-feedback">
                    Please enter your Mobile.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email"><fmt:message key="email"/></label>
                <input type="email" class="form-control" id="email" placeholder=""  required name="email">
                <div class="invalid-feedback">
                    Please enter your email.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username"><fmt:message key="username"/></label>
                <input type="text" class="form-control" id="username" placeholder=""  required name="username">
                <div class="invalid-feedback">
                    Please enter your Username.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address"><fmt:message key="adress"/></label>
                <input type="text" class="form-control" id="address" placeholder=""  required name="address">
                <div class="invalid-feedback">
                    Please enter your Address.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password"><fmt:message key="password"/></label>
                <input type="password" class="form-control" id="password" placeholder=""  required name="password">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cv"><fmt:message key="CV"/></label>
                <input type="file" class="form-control" id="cv" placeholder=""  required name="file">
                <div class="invalid-feedback">
                    CV is required
                </div>
            </div>
        </div>
    


    <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="submit"/></button>
</form>
<script>

    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'
     /*   function check_pass() {
            if (document.getElementById('password').value ==
                    document.getElementById('confirm_password').value) {
                document.getElementById('submit').disabled = false;
            } else {
                document.getElementById('submit').disabled = true;
            }
        }*/

        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation')

            // Loop over them and prevent submission
            Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
        }, false)
    })()


</script>
     
          

        
</t:pageTemplate>