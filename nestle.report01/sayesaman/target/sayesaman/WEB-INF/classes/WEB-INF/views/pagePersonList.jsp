<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/includes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="application.title"/></title>
    <style>
        tr.odd {
            background-color: #fff8dc;
        }

        tr.even {
            background-color: #e0ffff;
        }
    </style>
</head>
<body style="font-family: Tahoma; direction: rtl;">
<h1><spring:message code="bank.title"/></h1>

<form:form action="/bank/new">
    <input type="submit" name="action" value="New"/>
</form:form>

<table border="1" align="center" width="100%">
    <th>
        <spring:message code="bank.id"/>
    </th>

    <th>
        <spring:message code="bank.name"/>
    </th>

    <th>
        <spring:message code="bank.code"/>
    </th>

    <th>
        <spring:message code="bank.code"/>
    </th>

    <th>
        Delete
    </th>

    <th>
        Edit
    </th>

    <c:forEach items="${personList}" var="person" varStatus="loopStatus">
        <tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
            <td> ${person.id} </td>
            <td>${person.name}</td>
            <td>${person.phone}</td>
            <td>${person.imei}</td>
            <td align="center">
                <a href="/bank/delete/${bank.id}">Delete</a>
            </td>
            <td align="center">
                <a href="/bank/edit/${bank.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>