<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<ct:page title="My Sport in My City">    
    <jsp:body>
        <form:form action="/competitionRegister" method="post"  modelAttribute="DataTransferModel">
            <legend> Competition Register</legend>
                <p><b>Sport Name</b> <input name="sport" type="text"></p>
                <p><b>Competition Name</b> <input name="competitionName" type="text"></p>
                 <p><b>Competition Level</b> <select name="level">
                                        <c:if test="${not empty levelsList}">
                                            <c:forEach var="l" items="${levelsList}">
                                                    <option value='${l.level}'>${l.level}</option>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>               
               
                <p><b>City</b> <input name="city" type="text"></p>
                <p><b>Quarter</b>   <select name="quarter">
                                        <c:if test="${not empty quartersList}">
                                            <c:forEach var="q" items="${quartersList}">
                                                    <option value='${q.quarter}'>${q.quarter}</option>
                                            </c:forEach>
                                        </c:if>
                                      </select> </p>
                <p><b>Street Number</b> <input name="streetNumber" type="text"></p>
                <p><b>Description</b> <input name="description" type="text"></p>
                <p><b>Date</b> <input name="date" type="text"></p>
             

                <input type="submit" value="SUBMIT">

                <b> _or_ </b>  
                <a href="/home"><button>Back</button></a>
        </form:form>    <br /><br /><br />


        <sec:authorize  access="hasRole ('MAIN_ADMIN')">
            <a href="/adminPanel"><button>################### ADMIN PANEL ###################</button></a>
        </sec:authorize>

    </jsp:body>
</ct:page>