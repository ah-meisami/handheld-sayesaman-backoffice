package org;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sunich.bo.BankBO;
import org.sunich.bo.BuyTypeBO;
import org.sunich.bo.PersonBO;
import org.sunich.bo.UserBO;
import org.sunich.model.Bank;
import org.sunich.model.BuyType;
import org.sunich.model.Person;
import org.sunich.model.User;

import java.util.List;

public class MainSpringTest {
    private static final Logger log = Logger.getLogger(MainSpringTest.class);

    public static void main(String[] args) {
        //==============================================================================
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        //==============================================================================

        //==============================================================================
        UserBO userBo = (UserBO) ctx.getBean("userBOImpl");
        PersonBO personBOImpl = (PersonBO) ctx.getBean("personBOImpl");
        BuyTypeBO buyTypeBOImpl = (BuyTypeBO) ctx.getBean("buyTypeBOImpl");
        BankBO bankBOImpl = (BankBO) ctx.getBean("bankBOImpl");
        //==============================================================================

/*        //==============================================================================
        User user = new User();
        user.setUsername("johndoe");
        user.setName("امیر حسین میثمی");

        userBo.insertUser(user);
        log.debug("User inserted!");

        user = userBo.getUser("johndoe");
        log.debug("\nUser fetched by username!"
                + "\nId: " + user.getId()
                + "\nUsername: " + user.getUsername()
                + "\nName: " + user.getName());

        user = userBo.getUserById(user.getId());
        log.debug("\nUser fetched by ID!"
                + "\nId: " + user.getId()
                + "\nUsername: " + user.getUsername()
                + "\nName: " + user.getName());

        List<User> users = userBo.getUsers();
        log.debug("\nUser list fetched!" + "\nUser count: " + users.size());
        //==============================================================================

        //==============================================================================
        log.debug("**********************************************************************");
        List<Person> persons = personBOImpl.getPersonsBySP(0, 0, 1, 0);
        log.debug("\nPerson list fetched!" + "\nUser count: " + persons.size());
        log.debug("**********************************************************************");
        //==============================================================================
*/
        //==============================================================================
        List<BuyType> buyTypes = buyTypeBOImpl.getBuyTypes();
        log.debug("\nBuyType list fetched!" + "\nUser count: " + buyTypes.size());
        //==============================================================================

        //==============================================================================
        List<Bank> banks = bankBOImpl.getBanks();
        log.debug("\nBank list fetched!" + "\n count: " + banks.size());
        //==============================================================================
    }
}
