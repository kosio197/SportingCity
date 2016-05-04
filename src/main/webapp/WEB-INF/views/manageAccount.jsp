<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="Admin Panel">    
    <jsp:body>
        <ct:adminManagePanel manage="Account" /> 

                <td><a href = "adminUserRegister"><button>Add new Account</button></a></td>
              <br /> <br />
                <a href="/home"><button>Back to main page</button></a>
              <br /> <br />
                <table border="1">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Password</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Telephone</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Level</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <c:if test="${not empty accountsList}">
                        <tbody>
                            <c:forEach var="s" items="${accountsList}">
                                <tr>
                                    <td>${s.alias}</td>
                                    <td>${s.password}</td>
                                    <td>${s.firstName}</td>
                                    <td>${s.lastName}</td>
                                    <td>${s.userTel}</td>
                                    <td>${s.userEmail}</td>
                                    <td>${s.role.role}</td>
                                    <td>${s.level.level}</td>
                                    <td><a href="/account/edit/${s.accountId}"><button>Edit</button></a></td>
                                    <td><a href="/account/delete/${s.accountId}"><button>Delete</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table>
    </jsp:body>
</ct:page>