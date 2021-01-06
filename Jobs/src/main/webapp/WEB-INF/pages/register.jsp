<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Register">
    <h1>Register</h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Register">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="prenume">First Name</label>
                <input type="text" class="form-control" id="prenume" placeholder="" value="" required name="prenume">
                <div class="invalid-feedback">
                    Please enter your First Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nume">Last Name</label>
                <input type="text" class="form-control" id="nume" placeholder="" value="" required name="nume">
                <div class="invalid-feedback">
                    Please enter your Last Name.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nrTelefon">Phone number</label>
                <input type="text" class="form-control" id="nrTelefon" placeholder="" value="" required name="nrTelefon">
                <div class="invalid-feedback">
                    Please enter your Mobile Number.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="nrTelefon">Mobile number</label>
                <input type="text" class="form-control" id="nrMobil" placeholder="" value="" required name="nrMobil">
                <div class="invalid-feedback">
                    Please enter your Mobile.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" placeholder="" value="" required name="email">
                <div class="invalid-feedback">
                    Please enter your email.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" placeholder="" value="" required name="username">
                <div class="invalid-feedback">
                    Please enter your Username.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="" value="" required name="password">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Confirm Password</label>
                <input type="password" class="form-control" id="password" placeholder="" value="" required name="password">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cv">Upload your CV:</label>
                <input type="file" class="form-control" id="cv" placeholder="" value="" required name="file">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>


        <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>
    </form>
</t:pageTemplate>