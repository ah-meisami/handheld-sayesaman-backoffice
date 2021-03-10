<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/includes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="application.title"/></title>
</head>
<body style="font-family: Tahoma; direction: rtl;">
<h1><spring:message code="bank.title"/></h1>
<form:form action="/bank.do" method="POST" commandName="bank">
    <table>
        <tr>
            <td colspan="2"><form:errors path="*" cssStyle="color : red;"/></td>
        </tr>

        <tr>
            <td align="left"><spring:message code="bank.id"/></td>
            <td><form:input path="id" readonly="${inputIdReadOnle}"
                            cssStyle="background-color: ${inputIdBackColor}"/></td>
        </tr>
        <tr>
            <td align="left"><spring:message code="bank.name"/></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td align="left"><spring:message code="bank.code"/></td>
            <td><form:input path="code"/></td>
        </tr>
        <tr>
            <td align="left"><spring:message code="bank.code2"/></td>
            <td><form:input path="code2"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add" style="visibility: ${submitAddVisibility}"/>
                <input type="submit" name="action" value="Edit" style="visibility: ${submitEditVisibility}"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>