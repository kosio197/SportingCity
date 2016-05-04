<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="currentSport">    
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
                               <a href="/userRegister"><button>Register</button></a><br /><br />
                       </form:form>
                </c:otherwise>
            </c:choose>
        <form:form action="/currentSport" method="post"  modelAttribute="DataTransferModel">
            <legend> ${sportName} </legend>
            <p>Clubs offering sport</p>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Club Name</th>
                            <th>City</th>
                            <th>Quarter</th>
                            <th>Street Number</th>
                            <th>Description</th>
                            <th>Telephone</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <c:if test="${not empty clubsList}">
                        <tbody>
                            <c:forEach var="s" items="${clubsList}">
                                <tr>
                                    <td>${s.clubName}</td>
                                    <td>${s.address.city}</td>
                                    <td>${s.address.quarter.quarter}</td>
                                    <td>${s.address.streetNumber}</td>
                                    <td>${s.address.description}</td>
                                    <td>${s.tel}</td>
                                    <td>${s.email}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table>
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
                            <th>*** Join ***</th>
                        </tr>
                    </thead>
                    <c:if test="${not empty trainingsList}">
                        <tbody>
                            <c:forEach var="s" items="${trainingsList}">
                                <tr>
                                    <td>${s.sport.sportName}</td>
                                    <td>${s.club.clubName}</td>
                                    <td>${s.instructor}</td>
                                    <td>${s.address.city}</td>
                                    <td>${s.address.quarter.quarter}</td>
                                    <td>${s.address.streetNumber}</td>
                                    <td>${s.address.description}</td>
                                    <td>${s.date}</td>
                                    <td>${s.numberOfPersons}</td>
                                    <td>${s.level.level}</td>
                                    <td> <a href="/"${s.id}><button>Join</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table> 
             <br /> <br /> 
             <p>Competition</p>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Sport</th>
                            <th>Competition Name</th>
                            <th>Competition Level</th>
                            <th>City</th>
                            <th>Quarter</th>
                            <th>Street Number</th>
                            <th>Description</th>
                            <th>Date</th>
                            <th>*** Join ***</th>
                        </tr>
                    </thead>
                    <c:if test="${not empty competitionsList}">
                        <tbody>
                            <c:forEach var="s" items="${competitionsList}">
                                <tr>
                                    <td>${s.sport}</td>
                                    <td>${s.competitionName}</td>
                                    <td>${s.level}</td>
                                    <td>${s.city}</td>
                                    <td>${s.quarter}</td>
                                    <td>${s.streetNumber}</td>
                                    <td>${s.description}</td>
                                    <td>${s.date}</td>
                                    <td> <a href="/"${s.Id}${username}><button>Join</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table>
             <br /> <br /> 
             <p>Offered Seminars </p>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Sport</th>
                            <th>Theme</th>
                            <th>Leading</th>
                            <th>City</th>
                            <th>Quarter</th>
                            <th>Street Number</th>
                            <th>Description</th>
                            <th>Date</th>
                            <th>*** Join ***</th>
                        </tr>
                    </thead>
                    <c:if test="${not empty seminarsList}">
                        <tbody>
                            <c:forEach var="s" items="${seminarsList}">
                                <tr>
                                    <td>${s.sport}</td>
                                    <td>${s.theme}</td>
                                    <td>${s.leadingName}</td>
                                    <td>${s.city}</td>
                                    <td>${s.quarter}</td>
                                    <td>${s.streetNumber}</td>
                                    <td>${s.description}</td>
                                    <td>${s.date}</td>
                                    <td> <a href="/"${s.Id}${username}><button>Join</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table>
        </form:form>
        <br /><br />
            <a href="/home"><button>Back</button></a>
        <br /><br />
        <sec:authorize  access="hasRole ('MAIN_ADMIN')">
            <a href="/adminPanel"><button>################### ADMIN PANEL ###################</button></a>
        </sec:authorize>

    </jsp:body>
</ct:page>