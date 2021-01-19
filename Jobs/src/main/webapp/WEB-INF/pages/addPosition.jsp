<%-- 
    Document   : addPosition
    Created on : Jan 9, 2021, 1:23:54 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Add Position">
    <form method="POST" action="${pageContext.request.contextPath}/Position/Create">
        <br>
        <h4 class="mb-3"><fmt:message key="addPosition"/></h4>

        <div class="row g-3">                 
            <div class="col-12">
                <label for="denumire" class="form-label"><fmt:message key="positionName"/></label>
                <div class="input-group">
                    <input type="text" class="form-control" name="denumire" id="denumire" placeholder="" required="">
                    <div class="invalid-feedback">
                        Field is required. 
                    </div>
                </div>
            </div>

            <div class="col-12">
                <label for="departament" class="form-label"><fmt:message key="positionDepartment"/></label>
                <div class="input-group">
                    <input type="text" class="form-control" name="departament" id="departament" placeholder="" required="">
                    <div class="invalid-feedback">
                        Field is required.
                    </div>
                </div>
            </div>

            <div class="col-12">
                <label for="cerinte" class="form-label"><fmt:message key="positionRequirements"/></label>
                <div class="input-group">
                    <input type="text" class="form-control" id="cerinte" name="cerinte" placeholder="" required="">
                    <div class="invalid-feedback">
                        Field is required.
                    </div>
                </div>
            </div>

            <div class="col-12">
                <label for="responsabilitati" class="form-label"><fmt:message key="positionResponsibilities"/></label>
                <div class="input-group">
                    <input type="text" class="form-control" id="responsabilitati" name="responsabilitati" placeholder="" required="">
                    <div class="invalid-feedback">
                        Field is required.
                    </div>
                </div>
            </div>

            <div class="col-12">
                <label for="beneficii" class="form-label"><fmt:message key="positionBenefits"/></label>
                <div class="input-group">             
                    <input type="text" class="form-control" id="beneficii" name="beneficii" placeholder="" required="">
                    <div class="invalid-feedback">
                        Field is required.
                    </div>
                </div>
            </div>

            <div class="col-sm-6">
                <label for="nrPersoaneCautate" class="form-label"><fmt:message key="positionNumber"/></label>
                <input type="text" class="form-control" id="nrPersoaneCautate" name="nrPersoaneCautate" placeholder=""  required="">
                <div class="invalid-feedback">
                    Field is required.
                </div>
            </div>

        </div>
        <br>
        <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="add"/></button>
    </form> 


    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict'

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
