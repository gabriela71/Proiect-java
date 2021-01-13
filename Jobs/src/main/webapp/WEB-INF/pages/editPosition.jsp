<%-- 
    Document   : editPosition
    Created on : Jan 9, 2021, 2:41:49 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="com.project.i18n.language" />

<t:pageTemplate pageTitle="Edit Position">
    <form method="POST" action="${pageContext.request.contextPath}/Position/Update">
              
        <div class="row g-3">                 
            <div class="col-12">
              <label for="denumire" class="form-label"><fmt:message key="positionName"/></label>
              <div class="input-group">
                <input type="text" class="form-control" name="denumire" id="denumire"  value="${position.denumire}" placeholder="" required="">
              <div class="invalid-feedback">
                  Va rog introduceti denumirea.
                </div>
              </div>
            </div>
            
            <div class="col-12">
              <label for="departament" class="form-label"><fmt:message key="positionDepartment"/></label>
              <div class="input-group">
                  <input type="text" class="form-control" name="departament" id="departament" value="${position.departament}" placeholder="" required="">
              <div class="invalid-feedback">
                  Va rog introduceti deparamentul.
                </div>
              </div>
            </div>
            
            <div class="col-12">
              <label for="cerinte" class="form-label"><fmt:message key="positionRequirements"/></label>
              <div class="input-group">
                  <input type="text" class="form-control" id="cerinte" name="cerinte" value="${position.cerinte}" placeholder="" required="">
              <div class="invalid-feedback">
                  Va rog introduceti cerintele.
                </div>
              </div>
            </div>
            
            <div class="col-12">
              <label for="responsabilitati" class="form-label"><fmt:message key="positionResponsibilities"/></label>
              <div class="input-group">
                  <input type="text" class="form-control" id="responsabilitati" name="responsabilitati" value="${position.responsabilitati}" placeholder="" required="">
              <div class="invalid-feedback">
                  Va rog introduceti responsabilitatiile.
                </div>
              </div>
            </div>
            
            <div class="col-12">
              <label for="beneficii" class="form-label"><fmt:message key="positionBenefits"/></label>
              <div class="input-group">             
                  <input type="text" class="form-control" id="beneficii" name="beneficii" value="${position.beneficii}" placeholder="" required="">
              <div class="invalid-feedback">
                  Va rog introduceti beneficiile.
                </div>
              </div>
            </div>

            <div class="col-sm-6">
              <label for="nrPersoaneCautate" class="form-label"><fmt:message key="positionNumber"/></label>
              <input type="text" class="form-control" id="nrPersoaneCautate" name="nrPersoaneCautate" value="${position.nrPersoaneCautate}" placeholder=""  required="">
              <div class="invalid-feedback">
                Va rog introduceti un numar valid.
              </div>
            </div>
               
          </div>
        <br>
        <input type="hidden" name="position_id" value="${position.id}"/>
        <input type="hidden" name="nume_pagina" value="${pagina}"/>
        <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="save"/></button>
    </form> 
</t:pageTemplate>
