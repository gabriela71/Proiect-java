<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Register">
    <h1>Register</h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Register">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="prenume">First Name</label>
                <input type="text" class="form-control" id="prenume" placeholder=""  required name="prenume">
                <div class="invalid-feedback">
                    Please enter your First Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nume">Last Name</label>
                <input type="text" class="form-control" id="nume" placeholder=""  required name="nume">
                <div class="invalid-feedback">
                    Please enter your Last Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nrTelefon">Phone number</label>
                <input type="text" class="form-control" id="nrTelefon" placeholder=""  required name="nrTelefon">
                <div class="invalid-feedback">
                    Please enter your Mobile Number.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nrTelefon">Mobile number</label>
                <input type="text" class="form-control" id="nrMobil" placeholder=""  required name="nrMobil">
                <div class="invalid-feedback">
                    Please enter your Mobile.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" placeholder=""  required name="email">
                <div class="invalid-feedback">
                    Please enter your email.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" placeholder=""  required name="username">
                <div class="invalid-feedback">
                    Please enter your Username.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" placeholder=""  required name="address">
                <div class="invalid-feedback">
                    Please enter your Address.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder=""  required name="password">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Confirm Password</label>
                <input type="password" class="form-control" id="confirm_password" placeholder=""  required name="confirm_password">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cv">Upload your CV:</label>
                <input type="file" class="form-control" id="cv" placeholder=""  required name="file">
                <div class="invalid-feedback">
                    CV is required
                </div>
            </div>
        </div>


        <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>
    </form>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict'
            var check = function () {
                if (document.getElementById('password').value ==
                        document.getElementById('confirm_password').value) {
                    document.getElementById('message').style.color = 'green';
                    document.getElementById('message').innerHTML = 'matching';
                } else {
                    document.getElementById('message').style.color = 'red';
                    document.getElementById('message').innerHTML = 'not matching';
                }
            }
            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation')

                // Loop over them and prevent submission
                Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false && check===false) {
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