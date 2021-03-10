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
<body>

<table width="50%" border="1">
    <tr>
        <td>
            This control get its data from Database 1 (Oracle)
        </td>

        <td style="color: indianred">
            Sale
        </td>

        <td>
            <form:select path="MapDc" items="${MapDc}" cssStyle="font-family: Tahoma; direction: rtl"/>
        </td>
    </tr>

    <tr>
        <td>
            This control get its data from Database 2 (MSSQL)
        </td>

        <td style="color: indianred">
            Accounting
        </td>

        <td>
            <form:select path="MapAccYear" items="${MapAccYear}" cssStyle="font-family: Tahoma; direction: rtl"/>
        </td>
    </tr>

    <tr>
        <td>
            This control get its data from Database 3 (MSACCESS)
        </td>

        <td style="color: indianred">
            HR
        </td>

        <td>
            <form:select path="MapPersonnel" items="${MapPersonnel}" cssStyle="font-family: Tahoma; direction: rtl"/>
        </td>
    </tr>
</table>

<br/>
<br/>

</body>
</html>