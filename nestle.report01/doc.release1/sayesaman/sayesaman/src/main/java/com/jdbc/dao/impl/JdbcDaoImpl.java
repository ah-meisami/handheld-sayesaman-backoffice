package com.jdbc.dao.impl;

import com.jdbc.dao.JdbcDao;
import com.jdbc.model.AccYear;
import com.jdbc.model.Dc;
import com.jdbc.model.Personnel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.LinkedList;
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
        String qry = " SELECT ID, AccYear FROM GNR.tblAccYear WHERE AccYear>='1383' ORDER BY AccYear DESC";
        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            AccYear accYear = new AccYear();
            accYear.setId(row.get("ID").toString());
            accYear.setName(row.get("AccYear").toString());
            accYearList.add(accYear);
        }
        return accYearList;
    }

    public List<Dc> getDc() {
        List<Dc> dcList = new ArrayList<>();
        String qry = "SELECT id, DCCode + ' : ' + DCName AS name FROM GNR.tblDC WHERE ID NOT IN (0) ORDER BY DCCode ";
        List<Map<String, Object>> rows = jdbcTemplate2.queryForList(qry);

        for (Map row : rows) {
            Dc dc = new Dc();
            dc.setId(row.get("id").toString());
            dc.setName((String) row.get("name"));
            dcList.add(dc);
        }
        return dcList;
    }
}