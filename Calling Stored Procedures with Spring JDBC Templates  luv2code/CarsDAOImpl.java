package com.jdbc.dao.impl;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class CarsDAOImpl extends JdbcDaoSupport implements CarsDAO {

    private CarsStoredProcedure carsStoredProcedure;

    public CarsDAOImpl() {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        carsStoredProcedure = new CarsStoredProcedure(jdbcTemplate);
    }

    public List getCars(String make, String model, int year, double maxPrice) {
        List result = null;

        // Call the stored procedure
        Map data = carsStoredProcedure.getCars(make, model, year, maxPrice);

        // retrieve the list of objects
        result = (List) data.get(DAOConstants.RESULT_LIST);

        // retrieve the status info
        Integer code = (Integer) data.get(DAOConstants.RETURN_CODE);
        String message = (String) data.get(DAOConstants.RETURN_MESSAGE);

        // just print the code and message…should log this
        System.out.println(code + “ “ + message);

        return result;
    }
}