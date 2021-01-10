<%-- 
    Document   : addPosition
    Created on : Jan 9, 2021, 1:23:54 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Add Position">
    <form method="POST" action="${pageContext.request.contextPath}/Position/Create">
        <br>
        <h4 class="mb-3">Adaugare Pozitie</h4>
        
        <div class="row g-3">                 
            <div class="col-12">
              <label for="denumire" class="form-label">Denumire</label>
              <div class="input-group">
                <input type="text" class="form-control" name="denumire" id="denumire" placeholder="" required="">
              <div class="invalid-feedback">
                  Your username is required.
                </div>
              </div>
            </div>
            
            <div class="col-12">
              <label for="departament" class="form-label">Departament</label>
              <div class="input-group">
                <input type="text" class="form-control" name="departament" id="departament" placeholder="" required="">
              <div class="invalid-feedback">
                  Your username is required.
                </div>
              </div>
            </div>
            
            <div class="col-12">
              <label for="cerinte" class="form-label">Cerinte</label>
              <div class="input-group">
                <input type="text" class="form-control" id="cerinte" name="cerinte" placeholder="" required="">
              <div class="invalid-feedback">
                  Your username is required.
                </div>
              </div>
            </div>
            
            <div class="col-12">
              <label for="responsabilitati" class="form-label">Responsabilitati</label>
              <div class="input-group">
                <input type="text" class="form-control" id="responsabilitati" name="responsabilitati" placeholder="" required="">
              <div class="invalid-feedback">
                  Your username is required.
                </div>
              </div>
            </div>
            
            <div class="col-12">
              <label for="beneficii" class="form-label">Beneficii</label>
              <div class="input-group">             
                <input type="text" class="form-control" id="beneficii" name="beneficii" placeholder="" required="">
              <div class="invalid-feedback">
                  Your username is required.
                </div>
              </div>
            </div>

            <div class="col-sm-6">
              <label for="nrPersoaneCautate" class="form-label">Numar pesoane cautate</label>
              <input type="text" class="form-control" id="nrPersoaneCautate" name="nrPersoaneCautate" placeholder=""  required="">
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>
               
          </div>
        <br>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Adauga</button>
    </form> 
</t:pageTemplate>
