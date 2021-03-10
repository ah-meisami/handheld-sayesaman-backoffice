package org.sunich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.sunich.bo.BankBO;
import org.sunich.model.Bank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/12/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    @Autowired
    BankBO bankBO;

    @RequestMapping(method = RequestMethod.GET, value = "/example")
    public ModelAndView hello() {

/*
        UserBO userBO = (UserBO) ctx.getBean("userBOImpl");
        List<User> usersList = userBO.getUsers();
        Map<String , String> usersMap = new LinkedHashMap<String, String>();
        User user;
        for (int i = 0; i < usersList.size() ; i++) {
            user = usersList.get(i);
            usersMap.put(String.valueOf(user.getId()),user.getName());

        }
        return new ModelAndView("hello", "usersMap", usersMap);
*/

        List<Bank> banksList = bankBO.getBanks();
        Map<String, String> banksMap = new LinkedHashMap<String, String>();
        Bank bank;
        for (int i = 0; i < banksList.size(); i++) {
            bank = banksList.get(i);
            banksMap.put(String.valueOf(bank.getId()), bank.getName());

        }
        return new ModelAndView("hello", "banksMap", banksMap);
/*      User user = userBO.getUserById(1);
        System.out.println(user.getName());
        return new ModelAndView("hello", "user", user);
        <div>Hello ${user.name}</div>
*/


    }

}
