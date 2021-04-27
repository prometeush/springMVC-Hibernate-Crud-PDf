<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib  prefix="template" tagdir="/WEB-INF/tags"  %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <template:templates title="Studentlist">
	 <jsp:attribute name="content">
	    <div class="container-fluid">
	        <div class="row justify-content-center mt-2 mb-5">
	            <div class="col-8 mb-5">
	            <div class="col-4 mx-auto mb-2">
	                <form action="studentsearch" method="get">
	                    <div class="input-group">
	                         <input type="text" class="form-control" name="keyword">
	                       <div class="input-group-append">
	                         <button type="submit" class="btn btn-success">Search</button>
	                       </div>
	                    </div>
	                    
	                </form>
	            </div>
	            <div class="text-right mb-2">
	               <a href="exportpdf" class="btn btn-primary">exportPDF</a>
	            </div>
	                <table class="table table-hover">
	                   <tr>
	                      <th>Id</th>
	                      <th>Vorname</th>
	                      <th>Nachname</th>
	                      <th>Email</th>
	                      <th>Prog.Sprache</th>
	                      <th>GeburtsDatum</th>
	                      <th colspan="2">Action</th>
	                   </tr>
	                   
	                   <c:forEach items="${studentlist1}" var="student">
	                     <c:url value="delete" var="deleteLink">
	                        <c:param name="id" value="${student.id}"></c:param>
	                     </c:url>
	                     
	                      <c:url value="update" var="updateLink">
	                        <c:param name="id" value="${student.id}"></c:param>
	                     </c:url>
	                        <tr>
	                           <td>${student.id}</td>
	                           <td>${student.vorname}</td>
	                           <td>${student.nachname}</td>
	                           <td>${student.email}</td>
	                           <td>${student.progSprache}</td>
	                           <td>${student.geburtsDatum}</td>
	                           <td><a href="${deleteLink}" class="btn btn-danger">Delete</a></td>
	                           <td><a href="${updateLink}" class="btn btn-primary">Update</a></td>
	                        </tr>
	                   </c:forEach>
	                   
	                </table>
	            </div>
	        </div>
	    </div>
	 </jsp:attribute>
 
 </template:templates>
