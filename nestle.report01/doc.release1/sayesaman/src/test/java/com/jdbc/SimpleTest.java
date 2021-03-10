package com.jdbc;


import com.jdbc.bo.JdbcBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/17/13
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration(locations = {"classpath:spring-context-jdbc.xml"})
public class SimpleTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private JdbcBo bo;

    @BeforeClass
    protected void setUp() throws Exception {
        Assert.assertNotNull(applicationContext);
        Assert.assertNotNull(bo);
    }

    @Test
    public void testDc() {
        Assert.assertNotNull(bo.getDc(false));
    }

    @Test
    public void testAccYear() {
        Assert.assertNotNull(bo.getAccYear());
    }

    @Test
    public void testPersonnel() {
        Assert.assertNotNull(bo.getPersonnel("0", "0", "1", "0"));
    }


    @Test
    public void testVoucherHdr() {
        //Assert.assertNotNull(bo.getVocherHdr());
    }

}
