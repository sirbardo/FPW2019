<%-- 
    Document   : header
    Created on : Apr 15, 2019, 9:18:41 AM
    Author     : bardoz
--%>


<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>

<json:array>
    <c:forEach var="libro" items="${libriList}">
        <json:object>
            <json:property name="titolo" value="${libro.getTitolo()}"/>
        </json:object>
    </c:forEach>
</json:array>