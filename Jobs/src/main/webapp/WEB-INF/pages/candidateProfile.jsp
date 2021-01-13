<%-- 
    Document   : candidateProfile
    Created on : Jan 12, 2021, 9:57:05 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Profile">
<h1><fmt:message key="profile"/></h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/CandidateProfile" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="prenume"><fmt:message key="forename"/></label>
                <input type="text" class="form-control" id="prenume" placeholder="" value="${candidate.prenume}"  required name="prenume">
                <div class="invalid-feedback">
                    Please enter your First Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nume"><fmt:message key="surname"/></label>
                <input type="text" class="form-control" id="nume" placeholder="" value="${candidate.nume}" required name="nume">
                <div class="invalid-feedback">
                    Please enter your Last Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nrTelefon"><fmt:message key="phone"/></label>
                <input type="text" class="form-control" id="nrTelefon" placeholder="" value="${candidate.nrTelefon}"  required name="nrTelefon">
                <div class="invalid-feedback">
                    Please enter your Mobile Number.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nrTelefon"><fmt:message key="mobile"/></label>
                <input type="text" class="form-control" id="nrMobil" placeholder="" value="${candidate.nrMobil}" required name="nrMobil">
                <div class="invalid-feedback">
                    Please enter your Mobile.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email"><fmt:message key="email"/></label>
                <input type="email" class="form-control" id="email" placeholder="" value="${candidate.email}" required name="email">
                <div class="invalid-feedback">
                    Please enter your email.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address"><fmt:message key="adress"/></label>
                <input type="text" class="form-control" id="address" placeholder="" value="${candidate.address}"  required name="address">
                <div class="invalid-feedback">
                    Please enter your Address.
                </div>
            </div>
        </div>
    
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cv"><fmt:message key="CV"/></label>
                <input type="file" class="form-control" id="cv" placeholder=""   name="file">
                <div class="invalid-feedback">
                    CV is required
                </div>
            </div>
        </div>

    <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="editProfile"/></button>
</form>
<script>
           /*     function checkPassword(form) { 
                password = form.password.value; 
                confirm_password = form.confirm_password.value; 
  
                // If password not entered 
                if (password == '') 
                    alert ("Please enter Password"); 
                      
                // If confirm password not entered 
                else if (confirm_password == '') 
                    alert ("Please enter confirm password"); 
                      
                // If Not same return False.     
                else if (password != confirm_password) { 
                    alert ("\nPassword did not match: Please try again...") 
                    return false; 
                } 
  
                // If same return True. 
                else{ 
                    alert("Password Match!") 
                    return true; 
                } 
            }
            */
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
        
                    // Function to check Whether both passwords 
            // is same or not. 
  /*   $(function () {
        $("#btnSubmit").click(function () {
            var password = $("#txtPassword").val();
            var confirm_password = $("#txtConfirmPassword").val();
            if (password != confirm_password) {
                alert("Passwords do not match.");
                return false;
            }
            return true;
        });
    });
         * 
   */
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
