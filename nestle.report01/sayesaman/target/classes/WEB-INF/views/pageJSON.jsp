<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <script src='<c:url value="/resources/js/libs/jquery-1.10.0.min.js"/>'></script>
    <script>
        function start() {
            $.ajax({
                        type: "GET",
                        url: "ajaxJsonRequest",
                        data: $("#ajaxRestForm").serialize(),
                        success: function (data) {
                            $("#jsonMessage").text(data);
                        },
                        error: function (e) {
                        }
                    }
            )
            ;
        }
    </script>
</head>
<body>
با سلام
<HR/>
<form id="ajaxRestForm" name="ajaxRestForm" action="JSON/ajaxJsonRequest" method="post">
    <input type="text" name="message" id="message"/>
    <input type="button" value="AJAX REQUEST" onclick="start();"/>
</form>
<br/>

<div id="jsonMessage"></div>
</body>
</html>