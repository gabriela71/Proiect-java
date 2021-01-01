<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="New account">
    <form action="">
        <h3>New Account?</h3>
        <div class="form-holder">
            <span class="lnr lnr-user"></span>
            <input type="text" class="form-control" placeholder="First Name">
        </div>
        <div class="form-holder">
            <span class="lnr lnr-user"></span>
            <input type="text" class="form-control" placeholder="Last Name">
        </div>
        <div class="form-holder">
            <span class="lnr lnr-phone-handset"></span>
            <input type="text" class="form-control" placeholder="Phone Number">
        </div>
        <div class="form-holder">
            <span class="lnr lnr-phone-handset"></span>
            <input type="text" class="form-control" placeholder="Mobil">
        </div>
        <div class="form-holder">
            <span class="lnr lnr-envelope"></span>
            <input type="text" class="form-control" placeholder="Email Address">
        </div>
        <div class="form-holder">
            <span class="lnr lnr-user"></span>
            <input type="text" class="form-control" placeholder="Address">
        </div>
        <div class="form-radio">
            <label for="relocare" class="radio-label">Relocare:</label>
            <div class="form-radio-item">
                <input type="radio" name="relocare" id="da" checked>
                <label for="da">DA</label>
                <span class="check"></span>
            </div>
            <div class="form-radio-item">
                <input type="radio" name="relocare" id="female">
                <label for="nu">NU</label>
                <span class="check"></span>
            </div>
        </div>
        <div class="form-holder">
            <span class="lnr lnr-lock"></span>
            <input type="password" class="form-control" placeholder="Password">
        </div>
        <div class="form-holder">
            <span class="lnr lnr-lock"></span>
            <input type="password" class="form-control" placeholder="Confirm Password">
        </div>


        <div class="form-holder">
            <div class="name"><h5 class="form-title">Upload CV</h5></div>
            <input class="input-file" type="file" name="file_cv" id="file">
            <label class="label--file" for="file"></label>
        </div>

        <div class="form-textbox">
            <input type="submit" name="submit" id="submit" class="submit" value="Create account" />
        </div>
    </form>
</t:pageTemplate>