$(document).ready(function () {
    getDataFromServerAndPopulateDropdown();
});

function getDataFromServerAndPopulateDropdown() {
    $.getJSON("List1", function (json) {

        $("#dropdownDC").html("");
        $("#dropdownAccYear").html("");

        $.each(json.dcs, function (i, item) {
            var item = json.dcs[i];
            var elem = $('<option>').val(item.id).text(item.name)
            elem.appendTo('#dropdownDC');
        });

        $.each(json.accYears, function (i, item) {
            var item = json.accYears[i];
            var elem = $('<option>').val(item.id).text(item.name)
            elem.appendTo('#dropdownAccYear');
        });


        $("#slideDownbox1").show().slideDown('slow');

    });
}

function getDataFromServerAndPopulateGrid() {
    var selectedDC = $('#dropdownDC').val();
    var selectedAccYear = $('#dropdownAccYear').val();

    $('#list').jqGrid('GridUnload');  //this does the work of clearing out the table content and loading fresh data

    $("#list").jqGrid({
        url: "List3",
        datatype: "json",
        mtype: "GET",
        colNames: ["شماره سند", "تاریخ سند", "از انبار اصلی", "به انبار عطف", "کد کالا", "نام کالا", "سری ساخت", "تعداد"],
        colModel: [
            { name: "vocherNo", width: 100, align: "center"},
            { name: "vocherDate", width: 100, align: "center" },

            { name: "stockDCName1", width: 100, align: "right" },
            { name: "stockDCName2", width: 100, align: "right" },

            { name: "goodsCode", width: 100, align: "center" },
            { name: "goodsName", width: 300},

            { name: "batchNo", width: 100, align: "center"},
            { name: "totalQty", width: 100, align: "center"}
        ],
        pager: "#pager",
        rowNum: 100,
        rowList: [100, 200, 300],
        sortname: "vocherNo",
        sortorder: "asc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "لیست کالاهای دارای سری ساخت انبار به انبار شده بین شعب",
        direction: "rtl",
        height: "700px",
        postData: {dc: selectedDC, accYear: selectedAccYear},
        rownumbers: true,
        rownumWidth:"35px"
    });
}
