package com.jdbc.dao.impl;

import com.jdbc.dao.JdbcDao;
import com.jdbc.model.AccYear;
import com.jdbc.model.Dc;
import com.jdbc.model.Personnel;
import com.jdbc.model.VocherHdr;
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
        if(withRedbull==true)
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

    public List<VocherHdr> getVocherHdr(String dc, String accYear, String rows, String page, String sidx, String sord) {
        if(sidx.equals("stockDCName1"))
            sidx = "StockDCName";

        if(sidx.equals("stockDCName2"))
            sidx = "TStockDCName ";

        List<VocherHdr> arrayList = new ArrayList<>();
        String qry = ""+
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

}