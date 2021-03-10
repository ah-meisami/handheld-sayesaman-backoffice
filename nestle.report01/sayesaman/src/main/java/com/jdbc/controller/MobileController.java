package com.jdbc.controller;

import com.jdbc.bo.JdbcBo;
import com.jdbc.json.StatusResponse;
import com.jdbc.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/14/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/Mobile")
public class MobileController {
    private static Logger Log = Logger.getLogger(MobileController.class);

    @Autowired
    private JdbcBo bo;

    //http://localhost:8080/Mobile/getDC
    @RequestMapping("/getDC")
    public
    @ResponseBody
    List<Dc>
    getDC() {
        List<Dc> dcs = new LinkedList<Dc>();
        dcs = bo.getDc(false);
        return dcs;
    }

    //http://localhost:8080/Mobile/getSalePath?DcRef=1&SaleZoneRef=2000000050&SaleAreaRef=2000000596
    @RequestMapping("/getSalePath")
    public
    @ResponseBody
    List<SalePath>
    getSaleZone(
            @RequestParam("DcRef") String DcRef
            , @RequestParam(value = "SaleZoneRef", defaultValue = "0") String SaleZoneRef
            , @RequestParam(value = "SaleAreaRef", defaultValue = "0") String SaleAreaRef
            , @RequestParam(value = "SalePathRef", defaultValue = "0") String SalePathRef
    ) {
        List<SalePath> salePaths = new LinkedList<SalePath>();
        salePaths = bo.getSalePath(DcRef, SaleZoneRef, SaleAreaRef, SalePathRef);
        return salePaths;
    }

    // http://localhost:8080/Mobile/getCustomer?DcRef=1&SalePathRef=2000000753
    @RequestMapping("/getCustomer")
    public
    @ResponseBody
    List<Customer>
    getCustomer(
            @RequestParam("DcRef") String DcRef
            , @RequestParam(value = "SalePathRef", defaultValue = "0") String SalePathRef
    ) {
        List<Customer> customers = new LinkedList<Customer>();
        customers = bo.getCustomer(DcRef, SalePathRef);
        return customers;
    }

    //http://localhost:8080/Mobile/getSaleHdr?AccYear=1392&CustRef=39022
    @RequestMapping("/getSaleHdr")
    public
    @ResponseBody
    List<SaleHdr>
    getSaleHdr(
            @RequestParam("AccYear") String AccYear
            , @RequestParam(value = "CustRef", defaultValue = "0") String CustRef
    ) {
        List<SaleHdr> saleHdrs = new LinkedList<SaleHdr>();
        saleHdrs = bo.getSaleHdr(AccYear, CustRef);
        return saleHdrs;
    }

    //http://localhost:8080/Mobile/getSaleItm?HdrRef=10000645
    @RequestMapping("/getSaleItm")
    public
    @ResponseBody
    List<SaleItm>
    getSaleItm(
            @RequestParam("HdrRef") String HdrRef
    ) {
        List<SaleItm> saleItms = new LinkedList<SaleItm>();
        saleItms = bo.getSaleItm(HdrRef);
        return saleItms;
    }

    //http://localhost:8080/Mobile/getSalePay?HdrRef=10000645
    @RequestMapping("/getSalePay")
    public
    @ResponseBody
    List<SalePay>
    getSalePay(
            @RequestParam("HdrRef") String HdrRef
    ) {
        List<SalePay> salePays = new LinkedList<SalePay>();
        salePays = bo.getSalePay(HdrRef);
        return salePays;
    }

    //http://localhost:8080/Mobile/getRetSaleHdr?AccYear=1392&CustRef=19458
    @RequestMapping("/getRetSaleHdr")
    public
    @ResponseBody
    List<RetSaleHdr>
    getRetSaleHdr(
            @RequestParam("AccYear") String AccYear
            , @RequestParam(value = "CustRef", defaultValue = "0") String CustRef
    ) {
        List<RetSaleHdr> retSaleHdrs = new LinkedList<RetSaleHdr>();
        retSaleHdrs = bo.getRetSaleHdr(AccYear, CustRef);
        return retSaleHdrs;
    }

    //http://localhost:8080/Mobile/getRetSaleItm?HdrRef=10010311
    @RequestMapping("/getRetSaleItm")
    public
    @ResponseBody
    List<RetSaleItm>
    getRetSaleItm(
            @RequestParam("HdrRef") String HdrRef
    ) {
        List<RetSaleItm> retSaleItms = new LinkedList<RetSaleItm>();
        retSaleItms = bo.getRetSaleItm(HdrRef);
        return retSaleItms;
    }

    @RequestMapping("/MobilePage1")
    public String List2() {
        return "MobilePage1";
    }

    //http://localhost:8080/Mobile/setCustomer?CustRef=19401&Pelak=1&NationalCode=2
    @RequestMapping("/setCustomer")
    public
    @ResponseBody
    StatusResponse
    setCustomer(
            @RequestParam("CustRef") String CustRef
            , @RequestParam(value = "Pelak", defaultValue = "0") String Pelak
            , @RequestParam(value = "NationalCode", defaultValue = "0") String NationalCode
    ) {
        bo.setCustomer(CustRef, Pelak, NationalCode);
        return new StatusResponse(true, "Operation Completed Successfully!");
    }

    //******************************************************************************************************************
    //******************************************************************************************************************
    //******************************************************************************************************************
    //http://localhost:8080/Mobile/getStockDC?DcRef=1
    @RequestMapping("/getStockDC")
    public
    @ResponseBody
    List<StockDc>
    getStockDC(
            @RequestParam("DcRef") String DcRef
            , @RequestParam(value = "AccYear", defaultValue = "1392") String AccYear
    ) {
        List<StockDc> list = new LinkedList<StockDc>();
        list = bo.getStockDC(AccYear, DcRef);
        return list;
    }

    //http://localhost:8080/Mobile/getStockGoodsGroup?StockDCRef=1
    @RequestMapping("/getStockGoodsGroup")
    public
    @ResponseBody
    List<GoodsGroup>
    getStockGoodsGroup(
            @RequestParam("StockDCRef") String StockDCRef
            , @RequestParam(value = "AccYear", defaultValue = "1392") String AccYear
    ) {
        List<GoodsGroup> list = new LinkedList<GoodsGroup>();
        list = bo.getStockGoodsGroup(AccYear, StockDCRef);
        return list;
    }

    //http://localhost:8080/Mobile/getStockGoods?StockDCRef=1
    @RequestMapping("/getStockGoods")
    public
    @ResponseBody
    List<StockGoods>
    getStockGoods(
            @RequestParam("StockDCRef") String StockDCRef
            , @RequestParam(value = "AccYear", defaultValue = "1392") String AccYear
    ) {
        List<StockGoods> list = new LinkedList<StockGoods>();
        list = bo.getStockGoods(AccYear, StockDCRef);
        return list;
    }

    //http://localhost:8080/Mobile/getStockGoodsByGoodsGroup?StockDCRef=1&GoodsGroupRef=1006
    @RequestMapping("/getStockGoodsByGoodsGroup")
    public
    @ResponseBody
    List<StockGoods>
    getStockGoodsByGoodsGroup(
            @RequestParam("StockDCRef") String StockDCRef
            , @RequestParam(value = "AccYear", defaultValue = "1392") String AccYear
            , @RequestParam(value = "GoodsGroupRef") String GoodsGroupRef
    ) {
        List<StockGoods> list = new LinkedList<StockGoods>();
        list = bo.getStockGoodsByGoodsGroup(AccYear, StockDCRef , GoodsGroupRef);
        return list;
    }

    //http://localhost:8080/Mobile/getStockGoodsDetail?HdrRef=50021098
    @RequestMapping("/getStockGoodsDetail")
    public
    @ResponseBody
    List<StockGoodsDetail>
    getStockGoodsDetail(
            @RequestParam("HdrRef") String HdrRef
    ) {
        List<StockGoodsDetail> list = new LinkedList<StockGoodsDetail>();
        list = bo.getStockGoodsDetail(HdrRef);
        return list;
    }
    //******************************************************************************************************************
    //******************************************************************************************************************
    //******************************************************************************************************************
}