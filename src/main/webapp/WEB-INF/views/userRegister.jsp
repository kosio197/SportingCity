<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="My Sport in My City">    
    <jsp:body>
        <form:form action="/userRegister" method="post" modelAttribute="DataTransferModel">
            <input type="hidden" name = "Id" value="${account.accountId}" >
            <legend> User Register</legend>
                <p><b>Username</b> <input name="username" type="text"  value="${account.alias}"></p>
                <p><b>Password</b> <input name="password" type="password" value=""></p>
                <p><b>First Name</b> <input name="firstName" type="text"  value="${account.firstName}"></p>
                <p><b>Last Name</b> <input name="lastName" type="text" value="${account.lastName}"></p>
                <p><b>Telephone</b> <input name="userTel" type="text" value="${account.userTel}"></p>
                <p><b>Email</b> <input name="userEmail" type="text" value="${account.userEmail}"></p>
                
              <sec:authorize  access="hasRole ('ROLE_MAIN_ADMIN')"> 
                <p><b>Role</b> <select name="role" >
                                        <c:if test="${not empty rolesList}">
                                            <c:forEach var="l" items="${rolesList}">
                                                <c:choose>
                                                    <c:when test="${account.role.role == l.role}">
                                                         <option selected value='${l.role}'>${l.role}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                         <option value='${l.role}'>${l.role}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>
               <p><b>Level</b> <select name="level" >
                                        <c:if test="${not empty levelsList}">
                                            <c:forEach var="l" items="${levelsList}">
                                                <c:choose>
                                                    <c:when test="${account.level.level == l.level}">
                                                         <option selected value='${l.level}'>${l.level}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                         <option value='${l.level}'>${l.level}</option>

                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>
                </sec:authorize>
              
                <input type="submit" value="SUBMIT">

        </form:form>
        <br /><br />
            <a href="/home"><button>Back</button></a>
        <br /><br />
        <sec:authorize  access="hasRole ('ROLE_MAIN_ADMIN')">
            <a href="/adminPanel"><button>################### ADMIN PANEL ###################</button></a>
        </sec:authorize>

    </jsp:body>
</ct:page>