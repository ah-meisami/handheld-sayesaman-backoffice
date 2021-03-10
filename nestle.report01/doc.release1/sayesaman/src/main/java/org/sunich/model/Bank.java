package org.sunich.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/13/13
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "ACC_Banks", schema = "dbo", catalog = "Sale")
@Entity
public class Bank {
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

    @javax.persistence.Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String code2;

    @javax.persistence.Column(name = "Code2")
    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank that = (Bank) o;

        if (id != that.id) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (code2 != null ? !code2.equals(that.code2) : that.code2 != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code2 != null ? code2.hashCode() : 0);
        return result;
    }
}
