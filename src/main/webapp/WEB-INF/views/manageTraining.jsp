<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="Admin Panel">    
    <jsp:body>
        <ct:adminManagePanel manage="Training" /> 

                <td><a href = "trainingRegister"><button>Add new Training</button></a></td>
              <br /> <br />
                <a href="/home"><button>Back to main page</button></a>
              <br /> <br />
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
                            <th>Edit</th>
                            <th>Delete</th>
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
                                    <td><a href="/admin/manage/training/edit/${s.id}"><button>Edit</button></a></td>
                                    <td><a href="/admin/manage/training/delete/${s.id}"><button>Delete</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table>
    </jsp:body>
</ct:page>