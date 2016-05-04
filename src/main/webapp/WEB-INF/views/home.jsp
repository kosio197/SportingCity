<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="My Sport in My City">
    <jsp:body>
        <sec:authentication var="user" property="principal" />
        <sec:authorize var="loggedIn" access="isAuthenticated()" />
            <c:choose>
	            <c:when test="${loggedIn}">
	                   <c:if test="${not empty pageContext.request.userPrincipal}">
                           <h3> Hello  <c:out value="${pageContext.request.userPrincipal.name}" /> </h3>
                       </c:if>
	                 <a href="/logout"><button>* Logout *</button></a>
		        </c:when>
                <c:otherwise>
                      <form:form action="/login" method="post" modelAttribute="DataTransferModel">
                         <legend>Login or Register</legend><br />
                                   <b>username</b> <input name="username" type="text"><br /><br />
                                      <b>password</b> <input name="password" type="password"><br /><br />
                                   <input type="submit" value="Login"><br />
                                <b> _or_ </b> <br />
                              
                       </form:form>
                        <a href="/userRegister"><button>Register</button></a>
		        </c:otherwise>
	        </c:choose>
            <br /><br />
        <form>
          <fieldset>
                <legend>* Search *</legend>
                    <form:form action="/user/filter" method="post" modelAttribute="DataTransferModel">
                        <p><b>By Region</b>   <select name="byQuarter">
                                        <c:if test="${not empty quartersList}">
                                            <c:forEach var="q" items="${quartersList}">
                                                    <option value=""></option>
                                                    <option value='${q.quarter}'>${q.quarter}</option>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>

                         <p><b>By Club</b>   <select name="byClub" >
                                        <c:if test="${not empty clubsList}">
                                            <c:forEach var="q" items="${clubsList}">
                                                        <option selected value=""></option>
                                                        <option value='${q.clubName}'>${q.clubName}</option>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>
			
                        <p><b>By Sport</b>   <select name="bySport" >
                                       <c:if test="${not empty sportsList}">
                                           <c:forEach var="q" items="${sportsList}">
                                                       <option selected value=""></option>
                                                       <option value='${q.sportName}'>${q.sportName}</option>
                                           </c:forEach>
                                       </c:if>
                                   </select></p>
            
                        <p><b>By Level</b>   <select name="byLevel" >
                                       <c:if test="${not empty levelsList}">
                                           <c:forEach var="q" items="${levelsList}">
                                                       <option selected value=""></option>
                                                       <option value='${q.level}'>${q.level}</option>
                                           </c:forEach>
                                       </c:if>
                                   </select></p>                                   
                        <input type="submit" value="Search"><br />
                   </form:form>
           </fieldset>
        </form> 
           <br />    <br /> 
             <p>Offered Trainings </p>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Sport</th>
                            <th>Club</th>
                            <th>Instructor</th>
                            <th>City</th>
                            <th>Quarter</th>
                            <th>Street Number</th>
                            <th>Description</th>
                            <th>Date</th>
                            <th>Number of Persons</th>
                            <th>Level of Persons</th>
                          <sec:authorize  access="authenticated">
                            <th>* Join *</th>
                          </sec:authorize>
                        </tr>
                    </thead>
                    <c:if test="${not empty trainingsList}">
                        <tbody>
                            <c:forEach var="s" items="${trainingsList}">
                                <tr>
                                    <td> <a href="/currentSport/${s.sport.sportName}"><button>${s.sport.sportName}</button></a></td>
                                    <td> <a href="/currentClub/${s.club.clubName}"><button>${s.club.clubName}</button></a></td>
                                    <td>${s.instructor}</td>
                                    <td>${s.address.city}</td>
                                    <td>${s.address.quarter.quarter}</td>
                                    <td>${s.address.streetNumber}</td>
                                    <td>${s.address.description}</td>
                                    <td>${s.date}</td>
                                    <td>${s.numberOfPersons}</td>
                                    <td>${s.level.level}</td>
                                  <sec:authorize  access="authenticated">
                                         <c:if test="${s.numberOfPersons > 0}">
                                             <td> <a href="/selectTraining/${s.id}"><button>Join</button></a></td>
                                        </c:if>
                                  </sec:authorize>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table> 
             <br /><br />

        <sec:authorize  access="hasRole ('ROLE_MAIN_ADMIN')">
            <a href="/adminPanel"><button>################### ADMIN PANEL ###################</button></a>
        </sec:authorize>
        <form>
          <fieldset>
                <legend>Information for test program:</legend><br />
                 Username=kosio  password= 0000  <br />
           </fieldset>
        </form> 
    </jsp:body>
</ct:page>