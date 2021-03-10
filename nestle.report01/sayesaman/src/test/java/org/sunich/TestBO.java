/*
package org.sunich;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sunich.bo.AccYearBO;
import org.sunich.bo.BankBO;
import org.sunich.bo.PersonBO;
import org.sunich.model.AccYear;
import org.sunich.model.Bank;
import org.sunich.model.Person;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

*/
/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/20/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestBO {

    @Autowired
    private BankBO bankBO;

    @Test
    public void testBankBO() {
        List<Bank> banks = bankBO.getBanks();
        System.out.println("count: " + banks.size());
        assertNotNull(banks);
    }

    @Autowired
    private PersonBO personBO;

    @Test
    public void testPersonBO() {
        List<Person> persons = personBO.getPersons();
        System.out.println("count: " + persons.size());
        assertNotNull(persons);
    }


    @Autowired
    private AccYearBO accYearBO;

    @Test
    public void testAccYearBO() {
        List<AccYear> accYears = accYearBO.getAll();
        System.out.println("count: " + accYears.size());
        assertNotNull(accYears);
    }
}
*/
