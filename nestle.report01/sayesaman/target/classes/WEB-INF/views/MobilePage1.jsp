<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/includes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title><spring:message code="nestle.report01.title"/></title>

    <link rel="stylesheet" type="text/css" media="screen"
          href='<c:url value="/resources/jquery-ui-1.10.3.custom/css/ui-lightness/jquery-ui-1.10.3.custom.min.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/ui.jqgrid.css"/>'/>
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/style.css"/>'/>

    <script src='<c:url value="/resources/jquery/jquery-1.10.0.min.js"/>'></script>
    <script src='<c:url value="/resources/jqgrid/jquery.jqGrid.min.js"/>'></script>
    <script src='<c:url value="/resources/jqgrid/i18n/grid.locale-fa.js"/>'></script>
    <script src='<c:url value="/resources/MobilePage1.js"/>'></script>
</head>
<body dir="rtl">
<table width="100%" border="0">
    <tr>
        <th>گزارش لیست مشتریان</th>
    </tr>
    <tr>
        <td align="center" id="slideDownbox1"
            style="background-color: beige; display: none; border: solid 1px #000000;">
            <table width="100%" border="1" cellpadding="5" cellspacing="5">
                <tr>
                    <td width="20%" align="left">شعبه</td>
                    <td align="right">
                        <select id="cmbDC" class="inp" onchange="getSaleZone();"></select>
                    </td>
                </tr>
                <tr>
                    <td align="left"> منطقه</td>
                    <td align="right">
                        <select id="cmbSaleZone" class="inp" onchange="getSaleArea();"></select>
                    </td>
                </tr>
                <tr>
                    <td align="left">ناحیه</td>
                    <td align="right">
                        <select id="cmbSaleArea" class="inp" onchange="getSalePath();"></select>
                    </td>
                </tr>
                <tr>
                    <td align="left">مسیر</td>
                    <td align="right">
                        <select id="cmbSalePath" class="inp" onchange="getCustomer();"></select>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td colspan="10" align="right">
                        <input type="button" class="inp" value="جستجو" onclick="getCustomer();"/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="center" width="100%">
            <table id="list" width="100%">
                <tr>
                    <td></td>
                </tr>
            </table>
            <div id="pager"></div>
        </td>
    </tr>
</table>
</body>
</html>