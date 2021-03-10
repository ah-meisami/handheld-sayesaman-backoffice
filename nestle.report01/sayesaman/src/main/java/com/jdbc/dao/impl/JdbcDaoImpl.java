package com.jdbc.dao.impl;

import com.jdbc.dao.JdbcDao;
import com.jdbc.dao.impl.usp.acc.CHQDelete;
import com.jdbc.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 3/5/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class JdbcDaoImpl implements JdbcDao {
    private static Logger log = Logger.getLogger("DatabaseHandlerImpl");

    private DataSource dataSource1;
    private JdbcTemplate jdbcTemplate1 = new JdbcTemplate();

    public DataSource getDataSource1() {
        return dataSource1;
    }

    private DataSource dataSource2;
    private JdbcTemplate jdbcTemplate2 = new JdbcTemplate();

    @Autowired
    @Qualifier(value = "dataSource1")
    public void setDataSource1(DataSource dataSource1) {
        this.jdbcTemplate1 = new JdbcTemplate(dataSource1);
    }

    @Autowired
    @Qualifier(value = "dataSource2")
    public void setDataSource2(DataSource dataSource2) {
        this.jdbcTemplate2 = new JdbcTemplate(dataSource2);
    }

    public DataSource getDataSource2() {
        return dataSource2;
    }

    public JdbcTemplate getJdbcTemplate1() {
        return jdbcTemplate1;
    }

    public JdbcTemplate getJdbcTemplate2() {
        return jdbcTemplate2;
    }

    public void setJdbcTemplate1(JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }

    public void setJdbcTemplate2(JdbcTemplate jdbcTemplate2) {
        this.jdbcTemplate2 = jdbcTemplate2;
    }

    public List<Personnel> getPersonnel(String personnelRef, String supervisorRef, String dCRef, String personnelTypeRef) {
        List<Personnel> personnelList = new ArrayList();
        String qry = "exec dbo.gettblPersonnel '" + personnelRef + "','" + supervisorRef + "','" + dCRef + "','" + personnelTypeRef + "' ";
        List<Map<String, Object>> rows = jdbcTemplate1.queryForList(qry);

        for (Map row : rows) {
            Personnel personnel = new Personnel();
            personnel.setID(row.get("ID").toString());
            personnel.setPersonnelName((String) row.get("PersonnelName"));
            personnelList.add(personnel);
        }
        return personnelList;

    }

    public List<AccYear> getAccYear() {
        List<AccYear> accYearList = new ArrayList();
        String qry = " SELECT AccYear ID, AccYear FROM GNR.tblAccYear WHERE AccYear>='1383' ORDER BY AccYear DESC";
        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            AccYear accYear = new AccYear();
            accYear.setId(row.get("ID").toString());
            accYear.setName(row.get("AccYear").toString());
            accYearList.add(accYear);
        }
        return accYearList;
    }

    public List<Dc> getDc(boolean withRedbull) {
        List<Dc> dcList = new ArrayList<>();
        String qry;
        if (withRedbull == true)
            qry = "SELECT id, DCCode + ' : ' + DCName AS name FROM GNR.tblDC WHERE ID NOT IN (0) ORDER BY DCCode ";
        else
            qry = "SELECT id, DCCode + ' : ' + DCName AS name FROM GNR.tblDC WHERE ID NOT IN (0,2000000004) ORDER BY DCCode ";

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            Dc dc = new Dc();
            dc.setId(row.get("id").toString());
            dc.setName((String) row.get("name"));
            dcList.add(dc);
        }
        return dcList;
    }

    public List<SalePath> getSalePath(String DcRef, String SaleZoneRef, String SaleAreaRef, String SalePathRef) {
        List<SalePath> list = new ArrayList<>();

        String qry = "";
        if (SaleZoneRef.equals("0") && SaleAreaRef.equals("0") && SalePathRef.equals("0")) {
            qry = " SELECT DISTINCT SaleZoneRef id, SaleZoneName name FROM GNR.vwCust WHERE Status = 1 AND DCRef = " + DcRef + " ORDER BY SaleZoneRef";

        } else if (!SaleZoneRef.equals("0") && SaleAreaRef.equals("0") && SalePathRef.equals("0")) {
            qry = " SELECT DISTINCT SaleAreaRef id, SaleAreaName name FROM GNR.vwCust WHERE Status = 1 AND DCRef = " + DcRef + " AND SaleZoneRef = " + SaleZoneRef + " ORDER BY SaleAreaRef";

        } else if (!SaleZoneRef.equals("0") && !SaleAreaRef.equals("0") && SalePathRef.equals("0")) {
            qry = " SELECT DISTINCT SalePathRef id, SalePathName name FROM GNR.vwCust WHERE Status = 1 AND DCRef = " + DcRef + " AND SaleZoneRef = " + SaleZoneRef + " AND SaleAreaRef = " + SaleAreaRef + " ORDER BY SalePathRef";
        }

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            SalePath path = new SalePath();
            path.setId(row.get("id").toString());
            path.setName((String) row.get("name"));
            list.add(path);
        }
        return list;
    }

    public List<Customer> getCustomer(String DcRef, String SalePathRef) {
        List<Customer> list = new ArrayList<>();

        String qry = qry = "SELECT  " +
                "GNR.tblCust.ID" +
                ", GNR.tblCust.CustCode" +
                ", GNR.tblCust.FirstName" +
                ", GNR.tblCust.LastName" +
                ", GNR.tblCust.RealName" +
                ", GNR.tblCust.Phone" +
                ", GNR.tblCust.Mobile" +
                ", GNR.tblCust.Address" +
                ", GNR.tblCust.CustLevelRef" +
                ", GNR.tblCustlevel.Title AS CustLevelName" +
                ", ISNULL(GNR.tblCust.Pelak,'') Pelak " +
                ", ISNULL(GNR.tblCust.NationalCode,'') NationalCode " +
                " FROM " +
                " GNR.tblCust INNER JOIN" +
                " GNR.tblCustlevel ON GNR.tblCust.CustLevelRef = GNR.tblCustlevel.ID" +
                " WHERE     " +
                "     GNR.tblCust.Status = 1 " +
                " AND GNR.tblCust.DCRef = " + DcRef +
                " AND GNR.tblCust.SalePathRef = " + SalePathRef +
                " ORDER BY CAST(ISNULL(GNR.tblCust.Pelak, 0) AS BIGINT)";
        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            Customer customer = new Customer();
            customer.setId(row.get("ID").toString());
            customer.setCode(row.get("CustCode").toString());
            customer.setFirstName(row.get("FirstName").toString());
            customer.setLastName(row.get("LastName").toString());
            customer.setRealName(row.get("RealName").toString());
            customer.setPhone(row.get("Phone").toString());
            customer.setMobile(row.get("Mobile").toString());
            customer.setAddress(row.get("Address").toString());
            customer.setCustLevelRef(row.get("CustLevelRef").toString());
            customer.setCustLevelName(row.get("CustLevelName").toString());
            customer.setPelak(row.get("Pelak").toString());
            customer.setNationalCode(row.get("NationalCode").toString());
            list.add(customer);
        }
        return list;
    }

    public List<SaleHdr> getSaleHdr(String AccYear, String CustRef) {
        List<SaleHdr> list = new ArrayList<>();

        String qry =
                " SELECT  " +
                        "  SLE.vwSaleHdrFull.ID" +
                        ", SLE.vwSaleHdrFull.SaleDate" +
                        ", ISNULL(cast(SLE.vwSaleHdrFull.SaleVocherNo as varchar(50)), '-') AS SaleVocherNo" +
                        ", ISNULL(cast(SLE.vwSaleHdrFull.SaleNo as varchar(50)), '-') AS SaleNo" +
                        ", SLE.vwSaleHdrFull.TotalAmount" +
                        ", SLE.vwSaleHdrFull.DriverName" +
                        ", ISNULL(SLE.vwSaleHdrFull.RealDistributerName,'-') RealDistributerName" +
                        ", SLE.vwSaleHdrFull.DealerName" +
                        ", ISNULL(cast(SLE.vwSaleHdrFull.RetCauseRef as varchar(50)),'0') RetCauseRef" +
                        ", ISNULL(SLE.tblRetCause.Name,'-') RetCauseName" +
                        " FROM  SLE.vwSaleHdrFull LEFT OUTER JOIN SLE.tblRetCause ON SLE.vwSaleHdrFull.RetCauseRef = SLE.tblRetCause.ID" +
                        " WHERE     (SLE.vwSaleHdrFull.AccYear = " + AccYear + ") AND (SLE.vwSaleHdrFull.CustRef = " + CustRef + ")" +
                        " ORDER BY SLE.vwSaleHdrFull.SaleDate DESC";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            SaleHdr obj = new SaleHdr();
            obj.setId(row.get("ID").toString());
            obj.setSaleDate(row.get("SaleDate").toString());
            obj.setSaleVoucherNo(row.get("SaleVocherNo").toString());
            obj.setSaleNo(row.get("SaleNo").toString());
            obj.setTotalAmount(row.get("TotalAmount").toString().replace(".0000", ""));
            obj.setDriverName(row.get("DriverName").toString());
            obj.setDealerName(row.get("DealerName").toString());
            obj.setDistributerName(row.get("RealDistributerName").toString());
            obj.setRetCauseRef(row.get("RetCauseRef").toString());
            obj.setRetCauseName(row.get("RetCauseName").toString());
            list.add(obj);
        }
        return list;
    }

    public List<SaleItm> getSaleItm(String HdrRef) {
        List<SaleItm> list = new ArrayList<>();

        String qry = " SELECT " +
                " ID, GoodsId, GoodsCode, GoodsName, UnitName, UnitName2, UnitCapasity, UnitQty, TotalQty, Amount, Discount, AddAmount, AmountNut, RowOrder, " +
                " UnitRef, HdrRef, SupAmount, CustPrice, UserPrice, CPriceRef, PriceRef, PrizeType, MainQty, CartonType, tax, charge " +
                "  FROM SLE.vwSaleItm WHERE  HdrRef = " + HdrRef + " ORDER BY RowOrder";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            SaleItm obj = new SaleItm();
            obj.setId(row.get("ID").toString());
            obj.setGoodsRef(row.get("GoodsId").toString());
            obj.setGoodsCode(row.get("GoodsCode").toString());
            obj.setGoodsName(row.get("GoodsName").toString());
            obj.setAmountNut(row.get("AmountNut").toString().replace(".0000", ""));
            obj.setUnitQty(row.get("UnitQty").toString());
            obj.setTotalQty(row.get("TotalQty").toString());
            list.add(obj);
        }
        return list;
    }

    public List<SalePay> getSalePay(String HdrRef) {
        List<SalePay> list = new ArrayList<>();

        String qry = "SELECT     " +
                "   Acc.tblPayments.ID" +
                " , Acc.tblPayments.PayNo" +
                " , Acc.tblPayments.PayTypeRef" +
                " , Acc.tblPayType.Name AS PayTypeName" +
                " , Acc.tblPayments.ReceiptNo PayReceiptNo" +
                " , Acc.tblPayments.Amount PayAmount" +

                " , ISNULL(CAST(Acc.tblPayments.ChqRef AS VARCHAR(50)),'-') AS ChqRef" +
                " , ISNULL(CAST(Acc.TblCheque.ChqNo AS VARCHAR(50)),'-') AS ChqNo" +
                " , ISNULL(CAST(Acc.TblCheque.ChqAmount AS VARCHAR(50)),'-') AS ChqAmount" +
                " , ISNULL(CAST(Acc.TblCheque.ChqDate AS VARCHAR(50)),'-') AS ChqDate " +
                " , ISNULL(CAST(Acc.tblBanks.ID AS VARCHAR(50)),'-') AS ChqBankRef " +
                " , ISNULL(CAST(Acc.tblBanks.Name AS VARCHAR(50)),'-') AS ChqBankName" +
                " , ISNULL(CAST(Acc.TblCheque.BranchName AS VARCHAR(50)),'-') ChqBranchName" +
                " , ISNULL(CAST(Acc.TblCheque.AccNo AS VARCHAR(50)),'-') ChqAccNo" +

                " , ISNULL(CAST(Acc.tblChqStatus.ID AS VARCHAR(50)),'-') AS StatusRef" +
                " , ISNULL(CAST(Acc.tblChqStatus.Stat AS VARCHAR(50)),'-') AS StatusName " +
                " , ISNULL(CAST(Acc.tblChqHist.ChangeDate AS VARCHAR(50)),'-') AS StatusDate " +

                " , ISNULL(CAST(Acc.tblChqHist.DepBranchRef AS VARCHAR(50)),'-') AS DepBranchRef" +
                " , ISNULL(CAST(Acc.TblBankBranches.BranchName AS VARCHAR(50)),'-') AS DepBranchName" +

                " FROM  Acc.tblChqStatus INNER JOIN" +
                "      Acc.tblChqHist ON Acc.tblChqStatus.ID = Acc.tblChqHist.StatRef AND Acc.tblChqStatus.ID = Acc.tblChqHist.StatRef LEFT OUTER JOIN" +
                "      Acc.TblBankBranches ON Acc.tblChqHist.DepBranchRef = Acc.TblBankBranches.ID RIGHT OUTER JOIN" +
                "      Acc.tblBanks INNER JOIN" +
                "      Acc.TblCheque ON Acc.tblBanks.ID = Acc.TblCheque.BankRef AND Acc.tblBanks.ID = Acc.TblCheque.BankRef ON " +
                "      Acc.tblChqHist.ChqRef = Acc.TblCheque.ID RIGHT OUTER JOIN" +
                "      Acc.tblPayments INNER JOIN" +
                "      Acc.tblPayType ON Acc.tblPayments.PayTypeRef = Acc.tblPayType.ID ON Acc.TblCheque.ID = Acc.tblPayments.ChqRef" +
                " WHERE Acc.tblPayments.SaleRef = " + HdrRef;

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            SalePay obj = new SalePay();
            obj.setId(row.get("ID").toString());

            obj.setPayNo(row.get("payNo").toString());
            obj.setPayTypeRef(row.get("payTypeRef").toString());
            obj.setPayTypeName(row.get("payTypeName").toString());
            obj.setPayReceiptNo(row.get("payReceiptNo").toString());
            obj.setPayAmount(row.get("payAmount").toString().replace(".0000", ""));

            obj.setChqRef(row.get("chqRef").toString());
            obj.setChqNo(row.get("chqNo").toString());
            obj.setChqAmount(row.get("chqAmount").toString().replace(".0000", ""));
            obj.setChqDate(row.get("chqDate").toString());
            obj.setChqBankRef(row.get("chqBankRef").toString());
            obj.setChqBankName(row.get("chqBankName").toString());
            obj.setChqBranchName(row.get("chqBranchName").toString());
            obj.setChqAccNo(row.get("chqAccNo").toString());

            obj.setStatusRef(row.get("statusRef").toString());
            obj.setStatusName(row.get("statusName").toString());
            obj.setStatusDate(row.get("statusDate").toString());

            obj.setDepBranchRef(row.get("depBranchRef").toString());
            obj.setDepBranchName(row.get("depBranchName").toString());

            list.add(obj);
        }
        return list;
    }

    public List<RetSaleHdr> getRetSaleHdr(String AccYear, String CustRef) {
        List<RetSaleHdr> list = new ArrayList<>();

        String qry = "SELECT" +
                "    ID" +
                "    , RetSaleNo" +
                "    , RetSaleDate" +
                "    , DealerRef " +
                "    , PersCode DealerCode" +
                "    , DealerName" +
                "    , TotalAmount" +
                "    , UserRef" +
                "    , UserName" +
                " FROM" +
                "    SLE.vwRetSaleHdr" +
                " WHERE (RetCauseRef = 2000000021) AND (CancelFlag = 0) AND (CustRef = " + CustRef + ") AND (AccYear = " + AccYear + ")" +
                " ORDER BY RetSaleNo DESC";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            RetSaleHdr obj = new RetSaleHdr();
            obj.setId(row.get("ID").toString());

            obj.setRetSaleNo(row.get("RetSaleNo").toString());
            obj.setRetSaleDate(row.get("RetSaleDate").toString());

            obj.setDrealerRef(row.get("DealerRef").toString());
            obj.setDealerCode(row.get("DealerCode").toString());
            obj.setDealerName(row.get("DealerName").toString());

            obj.setTotalAmount(row.get("TotalAmount").toString().replace(".0000", ""));

            obj.setUserRef(row.get("UserRef").toString());
            obj.setUserName(row.get("UserName").toString());
            list.add(obj);
        }
        return list;
    }

    public boolean setCustomer(String CustRef, String Pelak, String NationalCode) {
        boolean result = true;
        String qry = "" +
                " UPDATE GNR.tblCust  SET " +
                "  Pelak = '" + Pelak + "' " +
                ", NationalCode = '" + NationalCode + "' " +
                " WHERE ID = " + CustRef;

        log.debug(qry);

        jdbcTemplate2.update(qry);

        return result;
    }

    public List<RetSaleItm> getRetSaleItm(String HdrRef) {
        List<RetSaleItm> list = new ArrayList<>();

        String qry = "SELECT" +
                "  SLE.tblRetSaleItm.ID" +
                ", SLE.tblRetSaleItm.RetCauseRef" +
                ", SLE.tblRetCause.Name AS RetCauseName" +

                ", SLE.tblRetSaleItm.GoodsRef" +
                ", GNR.tblGoods.GoodsCode" +
                ", GNR.tblGoods.GoodsName" +
                ", GNR.tblUnit.UnitName" +

                ", SLE.tblRetSaleItm.TotalQty" +
                ", SLE.tblRetSaleItm.AmountNut" +
                " FROM  " +
                " SLE.tblRetSaleItm INNER JOIN" +
                " GNR.tblGoods ON SLE.tblRetSaleItm.GoodsRef = GNR.tblGoods.ID INNER JOIN" +
                " SLE.tblRetCause ON SLE.tblRetSaleItm.RetCauseRef = SLE.tblRetCause.ID INNER JOIN" +
                " GNR.tblUnit ON GNR.tblGoods.UnitRef = GNR.tblUnit.ID AND GNR.tblGoods.UnitRef = GNR.tblUnit.ID" +
                " WHERE    " +
                " SLE.tblRetSaleItm.HdrRef = " + HdrRef +
                " ORDER BY" +
                " SLE.tblRetSaleItm.RowOrder";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            RetSaleItm obj = new RetSaleItm();
            obj.setId(row.get("ID").toString());

            obj.setGoodsRef(row.get("GoodsRef").toString());
            obj.setGoodsCode(row.get("GoodsCode").toString());
            obj.setGoodsName(row.get("GoodsName").toString());
            obj.setUnitName(row.get("UnitName").toString());

            obj.setTotalQty(row.get("TotalQty").toString());
            obj.setAmountNut(row.get("AmountNut").toString().replace(".0000", ""));
            list.add(obj);
        }
        return list;
    }

    public List<VocherHdr> getVocherHdr(String dc, String accYear, String rows, String page, String sidx, String sord) {
        if (sidx.equals("stockDCName1"))
            sidx = "StockDCName";

        if (sidx.equals("stockDCName2"))
            sidx = "TStockDCName ";

        List<VocherHdr> arrayList = new ArrayList<>();
        String qry = "" +
                " SELECT " +
                "   VH.VocherNo " +
                " , VH.VocherDate " +

                " , VH.StockDCName " +
                " , VH.TStockDCName " +

                " , VI.GoodsRef " +
                " , VI.GoodsCode " +
                " , VI.GoodsName " +
                " , VI.UnitQty " +
                " , VI.CartonType " +
                " , VI.Qty " +

                " , Batch.BatchNo " +
                " , VD.TotalQty " +
                " FROM " +
                " INV.vwVocherHdrFull AS VH INNER JOIN " +
                " INV.vwVocherItmFull AS VI ON VH.ID = VI.HdrRef INNER JOIN " +
                " INV.tblVocherItmDetail AS VD ON VI.ID = VD.ItmRef INNER JOIN " +
                " GNR.tblBatchNo AS Batch ON VD.BatchNoRef = Batch.ID " +
                " WHERE " +
                " VH.VocherTypeCode = 65 " +
                " AND VH.AccYear = " + accYear +
                " AND VH.DCRef = " + dc +
                " AND VD.TotalQty<> 0  " +
                " AND((Select DCRef From GNR.tblStockDC Where ID = VH.TStockDCRef) <>VH.DCRef) " +
                " ORDER BY " + sidx + " " + sord;

        List<Map<String, Object>> retRows = jdbcTemplate2.queryForList(qry);

        for (Map row : retRows) {
            VocherHdr vocherHdr = new VocherHdr();

            vocherHdr.setVocherNo(row.get("VocherNo").toString());
            vocherHdr.setVocherDate((String) row.get("VocherDate"));

            vocherHdr.setStockDCName1(row.get("StockDCName").toString());
            vocherHdr.setStockDCName2((String) row.get("TStockDCName"));

            vocherHdr.setGoodsRef(row.get("GoodsRef").toString());
            vocherHdr.setGoodsCode((String) row.get("GoodsCode"));
            vocherHdr.setGoodsName(row.get("GoodsName").toString());
            vocherHdr.setUnitQty((double) row.get("UnitQty"));

            vocherHdr.setCartonType(row.get("CartonType").toString());
            vocherHdr.setQty((int) row.get("Qty"));

            vocherHdr.setBatchNo(row.get("BatchNo").toString());
            vocherHdr.setTotalQty((int) row.get("TotalQty"));

            arrayList.add(vocherHdr);
        }
        return arrayList;
    }

    public List<StockDc> getStockDC(String AccYear, String DcRef) {
        List<StockDc> list = new ArrayList<>();

        String qry = "SELECT     " +
                "  GNR.tblStockGoods.StockDCRef" +
                ", GNR.tblStockDC.StockDCName" +
                ", COUNT(*) Qty" +
                " FROM         " +
                " GNR.tblStockGoods INNER JOIN" +
                " GNR.tblStockDC ON GNR.tblStockGoods.StockDCRef = GNR.tblStockDC.ID INNER JOIN" +
                " GNR.tblDC ON GNR.tblStockDC.DCRef = GNR.tblDC.ID" +
                " WHERE     " +
                "     GNR.tblStockGoods.OnHandQty <> 0" +
                " AND GNR.tblStockGoods.AccYear = " + AccYear +
                " AND GNR.tblDC.ID = " + DcRef +
                " GROUP BY" +
                "   GNR.tblStockGoods.StockDCRef" +
                " , GNR.tblStockDC.StockDCName" +
                " ORDER BY" +
                "  COUNT(*) DESC";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            StockDc obj = new StockDc();
            obj.setId(row.get("StockDCRef").toString());
            obj.setName(row.get("StockDCName").toString());
            obj.setQty(row.get("Qty").toString());
            list.add(obj);
        }
        return list;
    }

    public List<GoodsGroup> getStockGoodsGroup(String AccYear, String StockDCRef) {
        List<GoodsGroup> list = new ArrayList<>();

        String qry = " SELECT     " +
                "  GNR.tblGoods.GoodsGroupRef" +
                ", GNR.vwMainSubGroup.GoodsGroupName" +
                ", COUNT(*) AS GoodsQty" +
                " FROM         " +
                "  GNR.tblStockGoods INNER JOIN" +
                "  GNR.tblGoods ON GNR.tblStockGoods.GoodsRef = GNR.tblGoods.ID INNER JOIN" +
                "  GNR.vwMainSubGroup ON GNR.tblGoods.GoodsGroupRef = GNR.vwMainSubGroup.GoodsGroupRef" +
                " WHERE     " +
                "    GNR.tblStockGoods.OnHandQty <> 0" +
                " AND GNR.tblStockGoods.AccYear = " + AccYear +
                " AND GNR.tblStockGoods.StockDCRef =  " + StockDCRef +
                " GROUP BY " +
                "   GNR.tblGoods.GoodsGroupRef" +
                " , GNR.vwMainSubGroup.GoodsGroupName" +
                " ORDER BY GoodsQty DESC ";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            GoodsGroup obj = new GoodsGroup();
            obj.setId(row.get("GoodsGroupRef").toString());
            obj.setName(row.get("GoodsGroupName").toString());
            obj.setQty(row.get("GoodsQty").toString());
            list.add(obj);
        }
        return list;
    }

    public List<StockGoods> getStockGoods(String AccYear, String StockDCRef) {
        List<StockGoods> list = new ArrayList<>();

        String qry = " SELECT " +
                "   GNR.tblStockGoods.ID" +
                " , GNR.tblStockGoods.GoodsRef" +
                " , GNR.tblGoods.GoodsCode" +
                " , GNR.tblGoods.GoodsName" +
                " , GNR.tblStockGoods.OnHandQty" +
                " , GNR.tblStockGoods.IsBatch" +
                " FROM         " +
                " GNR.tblStockGoods INNER JOIN" +
                " GNR.tblGoods ON GNR.tblStockGoods.GoodsRef = GNR.tblGoods.ID" +
                " WHERE     " +
                "    GNR.tblStockGoods.OnHandQty <> 0" +
                " AND GNR.tblStockGoods.AccYear = " + AccYear +
                " AND GNR.tblStockGoods.StockDCRef = " + StockDCRef +
                " ORDER BY" +
                "  GNR.tblStockGoods.OnHandQty DESC";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            StockGoods obj = new StockGoods();
            obj.setId(row.get("ID").toString());
            obj.setGoodsRef(row.get("GoodsRef").toString());
            obj.setGoodsCode(row.get("GoodsCode").toString());
            obj.setGoodsName(row.get("GoodsName").toString());
            obj.setOnHandQty(row.get("OnHandQty").toString());
            obj.setBatch((Boolean) row.get("IsBatch"));
            list.add(obj);
        }
        return list;
    }

    public List<StockGoods> getStockGoodsByGoodsGroup(String AccYear, String StockDCRef, String GoodsGroupRef) {
        List<StockGoods> list = new ArrayList<>();

        String qry = " SELECT " +
                "   GNR.tblStockGoods.ID" +
                " , GNR.tblStockGoods.GoodsRef" +
                " , GNR.tblGoods.GoodsCode" +
                " , GNR.tblGoods.GoodsName" +
                " , GNR.tblStockGoods.OnHandQty" +
                " , GNR.tblStockGoods.IsBatch" +
                " FROM         " +
                " GNR.tblStockGoods INNER JOIN" +
                " GNR.tblGoods ON GNR.tblStockGoods.GoodsRef = GNR.tblGoods.ID" +
                " WHERE     " +
                "     GNR.tblStockGoods.OnHandQty <> 0" +
                " AND GNR.tblStockGoods.AccYear = " + AccYear +
                " AND GNR.tblStockGoods.StockDCRef = " + StockDCRef +
                " AND GNR.tblGoods.GoodsGroupRef = " + GoodsGroupRef +
                " ORDER BY" +
                "  GNR.tblStockGoods.OnHandQty DESC";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            StockGoods obj = new StockGoods();
            obj.setId(row.get("ID").toString());
            obj.setGoodsRef(row.get("GoodsRef").toString());
            obj.setGoodsCode(row.get("GoodsCode").toString());
            obj.setGoodsName(row.get("GoodsName").toString());
            obj.setOnHandQty(row.get("OnHandQty").toString());
            obj.setBatch((Boolean) row.get("IsBatch"));
            list.add(obj);
        }
        return list;
    }

    public List<StockGoodsDetail> getStockGoodsDetail(String HdrRef) {
        List<StockGoodsDetail> list = new ArrayList<>();

        String qry = "SELECT     " +
                "   GNR.tblStockGoodsDetail.ID" +
                " , GNR.tblStockGoodsDetail.BatchNoRef BatchRef" +
                " , GNR.tblBatchNo.BatchNo" +
                " , GNR.tblBatchNo.ExpDate BatchExpDate" +
                " , GNR.tblStockGoodsDetail.OnHandQty AS OnHandQty" +
                " FROM         " +
                " GNR.tblStockGoods INNER JOIN" +
                " GNR.tblStockGoodsDetail ON GNR.tblStockGoods.ID = GNR.tblStockGoodsDetail.HdrRef INNER JOIN" +
                " GNR.tblBatchNo ON GNR.tblStockGoodsDetail.BatchNoRef = GNR.tblBatchNo.ID" +
                " WHERE    " +
                "     GNR.tblStockGoodsDetail.OnHandQty <> 0" +
                " AND GNR.tblStockGoodsDetail.HdrRef = " + HdrRef +
                " ORDER BY GNR.tblStockGoodsDetail.OnHandQty DESC";

        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            StockGoodsDetail obj = new StockGoodsDetail();
            obj.setId(row.get("ID").toString());
            obj.setBatchRef(row.get("BatchRef").toString());
            obj.setBatchNo(row.get("BatchNo").toString());
            obj.setBatchExpDate(row.get("BatchExpDate").toString());
            obj.setOnHandQty(row.get("OnHandQty").toString());
            list.add(obj);
        }
        return list;
    }

    public boolean remove(String id) {
        CHQDelete chqDelete = new CHQDelete(jdbcTemplate2);
        chqDelete.remove(id);

        return true;
    }

    public List<Cheque> getAll(String accYear, String dcRef, String insertDate) {
        List<Cheque> list = new ArrayList<>();

        String qry = "SELECT     " +
                "   Acc.TblCheque.ID" +
                " , Acc.TblCheque.ChqNo" +
                " , Acc.TblCheque.ChqDate" +
                " , CAST(REPLACE(CAST(Acc.TblCheque.ChqAmount AS VARCHAR(50)),'.00','') AS BIGINT) ChqAmount" +

                " , Acc.TblCheque.BankRef" +
                " , Acc.tblBanks.Name BankName" +
                " , Acc.TblCheque.BranchName" +
                " , Acc.TblCheque.AccNo" +

                " , Acc.TblCheque.CustRef" +
                " , GNR.tblCust.CustCode" +
                " , GNR.tblCust.FirstName" +
                " , GNR.tblCust.LastName" +
                " , GNR.tblCust.RealName" +

                " , Acc.TblCheque.SaleOfficeRef" +
                " , GNR.tblSaleOffice.Name SaleOfficeName" +

                " , Acc.TblCheque.InsUser" +
                " , AppUser.Username" +

                " FROM         " +
                " Acc.TblCheque INNER JOIN" +
                " Acc.tblBanks ON Acc.TblCheque.BankRef = Acc.tblBanks.ID AND Acc.TblCheque.BankRef = Acc.tblBanks.ID INNER JOIN" +
                " GNR.tblCust ON Acc.TblCheque.CustRef = GNR.tblCust.ID INNER JOIN" +
                " GNR.tblSaleOffice ON Acc.TblCheque.SaleOfficeRef = GNR.tblSaleOffice.ID AND Acc.TblCheque.SaleOfficeRef = GNR.tblSaleOffice.ID INNER JOIN" +
                " AppUser ON Acc.TblCheque.InsUser = AppUser.AppUserId" +
                " WHERE     " +
                " Acc.TblCheque.ACCYear = " + accYear +
                " AND Acc.TblCheque.DCRef = " + dcRef +
                " AND Acc.TblCheque.InsDate = '" + insertDate + "'" +
                " ORDER BY Acc.TblCheque.ID DESC";
        log.debug(qry);

        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            Cheque obj = new Cheque();
            obj.setId(row.get("ID").toString());
            obj.setNo(row.get("ChqNo").toString());
            obj.setDate(row.get("ChqDate").toString());
            obj.setAmount(row.get("ChqAmount").toString());

            obj.setBankRef(row.get("BankRef").toString());
            obj.setBankName(row.get("BankName").toString());
            obj.setBankBranch(row.get("BranchName").toString());
            obj.setBankAccNo(row.get("AccNo").toString());

            obj.setCustRef(row.get("CustRef").toString());
            obj.setCustCode(row.get("CustCode").toString());
            obj.setCustFirstName(row.get("FirstName").toString());
            obj.setCustLastName(row.get("LastName").toString());
            obj.setCustRealName(row.get("RealName").toString());

            obj.setSaleOfficeRef(row.get("SaleOfficeRef").toString());
            obj.setSaleOfficeName(row.get("SaleOfficeName").toString());

            obj.setInsUserRef(row.get("InsUser").toString());
            obj.setInsUserName(row.get("Username").toString());

            list.add(obj);
        }
        return list;
    }
}