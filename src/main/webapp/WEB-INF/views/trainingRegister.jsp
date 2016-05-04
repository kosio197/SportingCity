<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="My Sport in My City">    
    <jsp:body>
        <form:form action="/admin/manage/trainingRegister" method="post"  modelAttribute="DataTransferModel">
            <input name="Id" type = "hidden" value="${training.id}" />
            <legend> Training Register</legend>
                <p><b>Sport Name</b>   <select name="sport" >
                        <c:if test="${not empty sportsList}">
                            <c:forEach var="q" items="${sportsList}">
                                <c:choose>
                                    <c:when test="${training.sport.sportName == q.sportName}">
                                        <option selected value='${q.sportName}'>${q.sportName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value='${q.sportName}'>${q.sportName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </c:if>
                                      </select> </p>
                <p><b>Club Name</b>   <select name="club" >
                                        <c:if test="${not empty clubsList}">
                                            <c:forEach var="q" items="${clubsList}">
                                                <c:choose>
                                                    <c:when test="${training.club.clubName == q.clubName}">
                                                        <option selected value='${q.clubName}'>${q.clubName}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value='${q.clubName}'>${q.clubName}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>
                <p><b>Instructor Name</b> <input name="instructor" type="text" value="${training.instructor}"></p>
                <p><b>City</b> <input name="city" type="text" value="${training.address.city}"></p>
                <p><b>Quarter</b>   <select name="quarter" >
                                        <c:if test="${not empty quartersList}">
                                            <c:forEach var="q" items="${quartersList}">
                                                <c:choose>
                                                    <c:when test="${training.address.quarter.quarter == q.quarter}">
                                                        <option selected value='${q.quarter}'>${q.quarter}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value='${q.quarter}'>${q.quarter}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>
                <p><b>Street Number</b> <input name="streetNumber" type="text" value="${training.address.streetNumber}"></p>
                <p><b>Description</b> <input name="description" type="text" value="${training.club.address.description}"></p>
                <p><b>Date</b> <input name="date" type="text" value="${training.date}"></p>
                <p><b>Number of Persons</b> <input name="numberOfPersons" type="number" value="${training.numberOfPersons}"></p>
                <p><b>Level of Persons</b> <select name="level" >
                                        <c:if test="${not empty levelsList}">
                                            <c:forEach var="l" items="${levelsList}">
                                                <c:choose>
                                                    <c:when test="${training.level == l.level}">
                                                        <option selected value='${l.level}'>${l.level}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value='${l.level}'>${l.level}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                             </c:forEach>
                                        </c:if>
                                      </select> </p>
                <input type="submit" value="SUBMIT">
        </form:form>
        <br /><br />
                 <a href="/home"><button>Back</button></a>


    </jsp:body>
</ct:page>