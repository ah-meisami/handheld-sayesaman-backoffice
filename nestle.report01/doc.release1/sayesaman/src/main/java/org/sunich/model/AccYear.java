package org.sunich.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/20/13
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "tblAccYear", schema = "GNR", catalog = "DSDB_TEH")
@Entity
public class AccYear {
    int id;
    String startDate;
    String endDate;
    int value;

    @javax.persistence.Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
