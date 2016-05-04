<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="Admin Panel">    
    <jsp:body>
        <ct:adminManagePanel manage="Seminar" /> 

                <td><a href = "seminarRegister"><button>Add new Seminar</button></a></td>
              <br /> <br />
                <a href="/home"><button>Back to main page</button></a>
              <br /> <br />
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
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <c:if test="${not empty seminarsList}">
                        <tbody>
                            <c:forEach var="s" items="${seminarsList}">
                                <tr>
                                    <td>${s.sport}</td>
                                    <td>${s.competitionName}</td>
                                    <td>${s.level}</td>
                                    <td>${s.city}</td>
                                    <td>${s.quarter}</td>
                                    <td>${s.streetNumber}</td>
                                    <td>${s.description}</td>
                                    <td>${s.date}</td>
                                    <td><a href="/seminar/edit/${s.Id}"><button>Edit</button></a></td>
                                    <td><a href="/seminar/delete/${s.Id}}"><button>Delete</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table>
    </jsp:body>
</ct:page>