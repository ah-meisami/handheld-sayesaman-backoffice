package com.jdbc.dao;


import com.jdbc.model.AccYear;
import com.jdbc.model.Dc;
import com.jdbc.model.Personnel;
import com.jdbc.model.VocherHdr;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 3/10/13
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface JdbcDao {
    public List<Personnel> getPersonnel(String personnelRef, String supervisorRef, String dCRef, String personnelTypeRef);

    public List<AccYear> getAccYear();

    public List<Dc> getDc(boolean withRedbull);

    public List<VocherHdr> getVocherHdr(String dc, String accYear, String rows, String page, String sidx, String sord);
}
