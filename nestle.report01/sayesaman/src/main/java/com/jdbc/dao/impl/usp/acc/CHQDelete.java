package com.jdbc.dao.impl.usp.acc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 11/11/13
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class CHQDelete extends StoredProcedure {
    public CHQDelete(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, "Acc.uspCHQDelete");

        // Parameters should be declared in same order here that
        // they are declared in the stored procedure.
        //
        // Note: resultSet must be defined first!
        //
        // define params with syntax:  param_name, param_type
        //
        declareParameter(new SqlParameter(DAOConstants.ChqID, Types.INTEGER));
        declareParameter(new SqlOutParameter(DAOConstants.ErrorNum, Types.VARCHAR));
        declareParameter(new SqlOutParameter(DAOConstants.ErrorMessage, Types.VARCHAR));

        // now compile stored proc
        compile();
    }

    /**
     * Execute stored procedure.
     *
     * @return Results of running stored procedure.
     */
    public Map remove(String ChqID) {
        // set the input params
        Map inParameters = new HashMap();
        inParameters.put(DAOConstants.ChqID, ChqID);

        // now execute
        Map out = execute(inParameters); // Call on parent class

        return out;
    }
}
