package com.jdbc.dao.impl;

import org.springframework.jdbc.core.*;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * An access class for the Cars stored procedures.
 * This interface expects the following args for the store procedures
 * <p/>
 * <ul>
 * <li> arg1 (in): make
 * <li> arg2 (in): model
 * <li> arg3 (in): year
 * <li> arg4 (in): max price
 * <p/>
 * <li> arg5 (out): return code
 * <li> arg6 (out): return message
 * </ul>
 * <p/>
 * </pre>
 */
public class CarsStoredProcedure extends StoredProcedure {

    /**
     * Constructor for this StoredProcedure class.
     */
    public CarsStoredProcedure(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "getCars");

        // Parameters should be declared in same order here that
        // they are declared in the stored procedure.
        //
        // Note: resultSet must be defined first!
        //
        // define params with syntax:  param_name, param_type
        //
        RowMapper rowMapper = new CarRowMapper();
        declareParameter(new SqlReturnResultSet(DAOConstants.RESULT_LIST, rowMapper));
        declareParameter(new SqlParameter(DAOConstants.CAR_MAKE, Types.VARCHAR));
        declareParameter(new SqlParameter(DAOConstants.CAR_MODEL, Types.VARCHAR));
        declareParameter(new SqlParameter(DAOConstants.CAR_YEAR, Types.INTEGER));
        declareParameter(new SqlParameter(DAOConstants.MAX_PRICE, Types.DOUBLE));
        declareParameter(new SqlOutParameter(DAOConstants.RETURN_CODE, Types.INTEGER));
        declareParameter(new SqlOutParameter(DAOConstants.RETURN_MESSAGE, Types.VARCHAR));

        // now compile stored proc
        compile();
    }

    /**
     * Execute stored procedure.
     *
     * @return Results of running stored procedure.
     */
    public Map getCars(String make, String model, int year, double maxPrice) {

        // set the input params
        Map inParameters = new HashMap();
        inParameters.put(DAOConstants.CAR_MAKE, make);
        inParameters.put(DAOConstants.CAR_MODEL, model));
        inParameters.put(DAOConstants.CAR_YEAR, new Integer(year));
        inParameters.put(DAOConstants.MAX_PRICE, new Double(maxPrice));

        // now execute
        Map out = execute(inParameters); // Call on parent class

        return out;
    }

}