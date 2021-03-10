package org.sunich.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/13/13
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "tblBuyType", schema = "dbo", catalog = "Sale")
@Entity
public class BuyType {
    private long id;

    @javax.persistence.Column(name = "ID")
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String code;

    @javax.persistence.Column(name = "Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;

    @Column(name = "PUName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuyType that = (BuyType) o;

        if (id != that.id) return false;
        if (code != null ? !code.equals(that.code) : that.code != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
