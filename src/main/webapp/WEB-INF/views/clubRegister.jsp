<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="My Sport in My City">    
    <jsp:body>
        <form:form action="/admin/manage/clubRegister" method="post" modelAttribute="DataTransferModel">
            <input type="hidden" name="Id" value="${club.clubId}">
            <legend> Club Register</legend>
                <p><b>Club Name</b> 
                <c:choose>
                    <c:when test="${club == null}">
                        <input name="clubName" type="text" value="${club.clubName}" />
                    </c:when>
                    <c:otherwise>
                        <input name="clubName" disabled type="text" value="${club.clubName}" />
                    </c:otherwise>
                </c:choose></p>
                
                <p><b>Club Sport</b> <input name="sport" type="text" value="${club.sport.sportName}"></p>
                <p><b>City</b> <input name="city" type="text" value="${club.address.city}"></p>
                <p><b>Quarter</b>   <select name="quarter">
                                        <c:if test="${not empty quartersList}">
                                            <c:forEach var="q" items="${quartersList}">
                                                <c:choose>
                                                    <c:when test="${q.quarter == club.address.quarter.quarter}">
                                                        <option selected value='${q.quarter}'>${q.quarter}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value='${q.quarter}'>${q.quarter}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>
                <p><b>Street Number</b> <input name="streetNumber" type="text" value="${club.address.streetNumber}"></p>
                <p><b>Address Description</b> <input name="description" type="text" value="${club.address.description}"></p>
                <p><b>Telephone</b> <input name="tel" type="text" value="${club.tel}"></p>
                <p><b>Email</b> <input name="email" type="text" value="${club.email}"></p>

                <input type="submit" value="SUBMIT">

        </form:form> 
           <br /><br />
                <a href="/home"><button>Back</button></a>

        <sec:authorize  access="hasRole ('ROLE_MAIN_ADMIN')">
            <a href="/adminPanel"><button>################### ADMIN PANEL ###################</button></a>
        </sec:authorize>

    </jsp:body>
</ct:page>