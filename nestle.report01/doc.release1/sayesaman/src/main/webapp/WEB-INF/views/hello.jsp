<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Spring MVC Hello World</title>
</head>
<body style="font-family: Tahoma; direction: rtl">
<%--<div>Hello ${user.name}</div>--%>
<%--<div>Your personal message is: ${user.message}</div>--%>

<%--<form:select path="usersMap" items="${usersMap}" />--%>
<hr/>
<form:select path="banksMap" items="${banksMap}" cssStyle="font-family: Tahoma; direction: rtl"/>


</body>
</html>