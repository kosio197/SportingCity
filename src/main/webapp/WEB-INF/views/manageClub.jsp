<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="Admin Panel">    
    <jsp:body>
        <ct:adminManagePanel manage="Clubs" /> 

                <td><a href = "/admin/manage/clubRegister"><button>Add new Club</button></a></td>
              <br /> <br />
                <a href="/home"><button>Back to main page</button></a>
              <br /> <br />
                <table border="1">
                    <thead>
                        <tr>
                            <th>Club Name</th>
                            <th>Sport</th>
                            <th>City</th>
                            <th>Quarter</th>
                            <th>Street Number</th>
                            <th>Description</th>
                            <th>Telephone</th>
                            <th>Email</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <c:if test="${not empty clubsList}">
                        <tbody>
                            <c:forEach var="s" items="${clubsList}">
                                <tr>
                                    <td>${s.clubName}</td>
                                    <td>${s.sport.sportName}</td>
                                    <td>${s.address.city}</td>
                                    <td>${s.address.quarter.quarter}</td>
                                    <td>${s.address.streetNumber}</td>
                                    <td>${s.address.description}</td>
                                    <td>${s.tel}</td>
                                    <td>${s.email}</td>
                                    <td><a href="/admin/manage/club/edit/${s.clubId}"><button>Edit</button></a></td>
                                    <td><a href="/admin/manage/club/delete/${s.clubId}"><button>Delete</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if> 
                </table>
               
    </jsp:body>
</ct:page>