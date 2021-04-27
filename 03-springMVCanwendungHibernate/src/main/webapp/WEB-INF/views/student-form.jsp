<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib  prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<template:templates title="Home">
 <jsp:attribute name="content">
      <div class="container-fluid">
        <div class="row text-center justify-content-center mt-2">
           <div class="col">
                <spring:form action="studentSave" modelAttribute="studentmodel" method="post">
	                
	                
	                   <div class="form-group row">
	                     
	                      <spring:hidden path="id" cssClass="form-control col-5"/>
	                   </div>
	                  
	                   <div class="form-group row">
	                      <spring:label path="vorname" cssClass="col-form-label col-2">Vorname</spring:label>
	                      <spring:input path="vorname" cssClass="form-control col-5"/>
	                   </div>
	                   
	                   <div class="form-group row">
	                      <spring:label path="nachname" cssClass="col-form-label col-2">Nachname</spring:label>
	                      <spring:input path="nachname" cssClass="form-control col-5"/>
	                   </div>	                
	                   
	                   <div class="form-group row">
	                      <spring:label path="email" cssClass="col-form-label col-2">Email</spring:label>
	                      <spring:input path="email" type="email" cssClass="form-control col-5"/>
	                   </div>
	                   
	                    <div class="form-group row">
	                      <spring:label path="email" cssClass="col-form-label col-2">Prog.Sprache</spring:label>
	                      <spring:select path="progSprache" cssClass="custom-select col-5">
	                         <spring:options items="${proglist}"/>
	                      </spring:select>
	                   </div>
	                   
	                    <div class="form-group row">
	                      <spring:label path="geburtsDatum" cssClass="col-form-label col-2">Email</spring:label>
	                      <spring:input path="geburtsDatum" type="date" cssClass="form-control col-5"/>
	                   </div>
	                   
	                    <div class="form-group row">
	                     <label class="col-2"></label>
	                     <button type="submit" class="btn btn-success">Anmelden</button>
	                   </div>
	                   	                	                
	                </spring:form>
           </div>
        </div>
      </div>
 
 </jsp:attribute>

</template:templates>
