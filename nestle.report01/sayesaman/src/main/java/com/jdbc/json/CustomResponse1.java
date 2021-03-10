package com.jdbc.json;

import com.jdbc.model.AccYear;
import com.jdbc.model.Dc;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/30/13
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomResponse1 {
    private List<Dc> dcs;
    private List<AccYear> accYears;

    public List<Dc> getDcs() {
        return dcs;
    }

    public void setDcs(List<Dc> dcs) {
        this.dcs = dcs;
    }

    public List<AccYear> getAccYears() {
        return accYears;
    }

    public void setAccYears(List<AccYear> accYears) {
        this.accYears = accYears;
    }
}
