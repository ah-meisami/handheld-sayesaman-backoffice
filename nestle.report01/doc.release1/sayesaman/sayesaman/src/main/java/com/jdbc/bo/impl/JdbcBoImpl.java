package com.jdbc.bo.impl;

import com.jdbc.bo.JdbcBo;
import com.jdbc.dao.JdbcDao;
import com.jdbc.model.AccYear;
import com.jdbc.model.Dc;
import com.jdbc.model.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sunich.dao.AccYearDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/17/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class JdbcBoImpl implements JdbcBo {

    @Autowired
    private JdbcDao jdbcDao;

    @Override
    @Transactional(value = "transactionManager1")
    public List<Personnel> getPersonnel(String personnelRef, String supervisorRef, String dCRef, String personnelTypeRef) {
        return jdbcDao.getPersonnel(personnelRef, supervisorRef, dCRef, personnelTypeRef);
    }

    @Override
    @Transactional(value = "transactionManager1")
    public List<AccYear> getAccYear() {
        return jdbcDao.getAccYear();
    }

    @Override
    @Transactional(value = "transactionManager2")
    public List<Dc> getDc() {
        return jdbcDao.getDc();
    }

}
