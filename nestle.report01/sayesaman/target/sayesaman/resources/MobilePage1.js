$(document).ready(function () {
    getDC();
    $("#slideDownbox1").show().slideDown('slow');
});

function getDC() {
    $.getJSON(getAbsolutePath()+"getDC", function (json) {
        $("#cmbDC").html("");

        var elem = $('<option>').val(0).text("لطفاً انتخاب کنید")
        elem.appendTo('#cmbDC');

        $.each(json, function (i, item) {
            var item = json[i];
            var elem = $('<option>').val(item.id).text(item.name)
            elem.appendTo('#cmbDC');
        });
    });
}

function getSaleZone() {
    var dcRef = $("#cmbDC").val();

    $.getJSON(getAbsolutePath()+"getSalePath?DcRef=" + dcRef, function (json) {
        $("#cmbSaleZone").html("");
        $("#cmbSaleArea").html("");
        $("#cmbSalePath").html("");
        $("#list").html("");

        var elem = $('<option>').val(0).text("لطفاً انتخاب کنید")
        elem.appendTo('#cmbSaleZone');

        $.each(json, function (i, item) {
            var item = json[i];
            var elem = $('<option>').val(item.id).text(item.name)
            elem.appendTo('#cmbSaleZone');
        });
    });
}

function getSaleArea() {
    var dcRef = $("#cmbDC").val();
    var saleZoneRef = $("#cmbSaleZone").val();

    $.getJSON(getAbsolutePath()+"getSalePath?DcRef=" + dcRef + "&SaleZoneRef=" + saleZoneRef, function (json) {
        $("#cmbSaleArea").html("");
        $("#cmbSalePath").html("");
        $("#list").html("");

        var elem = $('<option>').val(0).text("لطفاً انتخاب کنید")
        elem.appendTo('#cmbSaleArea');

        $.each(json, function (i, item) {
            var item = json[i];
            var elem = $('<option>').val(item.id).text(item.name)
            elem.appendTo('#cmbSaleArea');
        });
    });
}

function getSalePath() {
    var dcRef = $("#cmbDC").val();
    var saleZoneRef = $("#cmbSaleZone").val();
    var saleAreaRef = $("#cmbSaleArea").val();

    $.getJSON(getAbsolutePath()+"getSalePath?DcRef=" + dcRef + "&SaleZoneRef=" + saleZoneRef + "&SaleAreaRef=" + saleAreaRef, function (json) {
        $("#cmbSalePath").html("");
        $("#list").html("");

        var elem = $('<option>').val(0).text("لطفاً انتخاب کنید")
        elem.appendTo('#cmbSalePath');

        $.each(json, function (i, item) {
            var item = json[i];
            var elem = $('<option>').val(item.id).text(item.name)
            elem.appendTo('#cmbSalePath');
        });
    });
}

function getCustomer() {
    var dcRef = $("#cmbDC").val();
    var saleZoneRef = $("#cmbSaleZone").val();
    var saleAreaRef = $("#cmbSaleArea").val();
    var salePathRef = $("#cmbSalePath").val();

    $('#list').jqGrid('GridUnload');  //this does the work of clearing out the table content and loading fresh data

    $("#list").jqGrid({
        url: getAbsolutePath()+"getCustomer",
        datatype: "json",
        mtype: "GET",
        colNames: ["کد مشتری", "نام", "نام خانوادگی", "نام حقیقی", "تلفن", "موبایل", "آدرس", "نوع فعالیت"],
        colModel: [
            { name: "code", width: 100, align: "center"},
            { name: "firstName", width: 100, align: "right"},
            { name: "lastName", width: 100, align: "right" },
            { name: "realName", width: 100, align: "right" },
            { name: "phone", width: 100, align: "center" },
            { name: "mobile", width: 100, align: "center" },
            { name: "address", width: 300},
            { name: "custLevelName", width: 100, align: "center"}
        ],
        pager: "#pager",
        rowNum: 1000,
        rowList: [1000, 2000, 3000],
        sortname: "vocherNo",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "گزارش لیست مشتریان",
        direction: "rtl",
        height: "700px",
        postData: {DcRef: dcRef, SalePathRef: salePathRef},
        rownumbers: true,
        rownumWidth: "35px"
    });
}

function getAbsolutePath() {
    var loc = window.location;
    var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
    return loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
}
