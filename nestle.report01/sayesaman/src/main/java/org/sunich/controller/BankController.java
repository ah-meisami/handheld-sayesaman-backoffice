package org.sunich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.sunich.bo.BankBO;
import org.sunich.model.Bank;
import org.sunich.validator.BankValidator;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/14/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class BankController {

    @Autowired
    private BankBO bankBO;

    @RequestMapping("/index")
    public String setupForm(Map<String, Object> map) {
        map.put("bankList", bankBO.getBanks());
        return "pageBankList";
    }


    BankValidator validator = null;

    public BankValidator getValidator() {
        System.out.println("*******************************2");
        return validator;
    }

    @Autowired
    public void setValidator(BankValidator validator) {
        System.out.println("*******************************1");
        this.validator = validator;
    }

    @RequestMapping(value = "/bank.do", method = RequestMethod.POST)
    public String processForm(
            @ModelAttribute @Valid Bank bank
            , BindingResult result
            , @RequestParam String action
            , Map<String, Object> map) {
        System.out.println("*******************************");
        System.out.println(action.toLowerCase());
        System.out.println("*******************************");
        validator.validate(bank, result);
        if (result.hasErrors()) {
            String bankId = String.valueOf(bank.getId());
            return "redirect: /bank/edit/" + bankId;
        } else {
            Bank bankResult = new Bank();
            switch (action.toLowerCase()) {    //only in Java7 you can put String in switch
                case "add":
                    bankBO.insertBank(bank);
                    bankResult = bank;
                    break;
                case "edit":
                    bankBO.updateBank(bank);
                    bankResult = bank;
                    break;
            }
            map.put("bankList", bankBO.getBanks());
            return "pageBankList";
        }
    }

    @RequestMapping(value = "/bank/delete/{bankId}")
    public String doDelete(@PathVariable long bankId, Map<String, Object> map) {
        bankBO.deleteBank(bankId);
        map.put("bankList", bankBO.getBanks());
        return "pageBankList";
    }

    @RequestMapping(value = "/bank/edit/{bankId}")
    public String doPreEdit(@PathVariable long bankId, Map<String, Object> map) {
        Bank searchedBank = bankBO.getBankById(bankId);

        map.put("bank", searchedBank);
        map.put("submitAddVisibility", "hidden");
        map.put("submitEditVisibility", "visible");
        map.put("inputIdReadOnle", Boolean.TRUE);
        map.put("inputIdBackColor", "#d3d3d3");
        return "pageBankCrud";
    }

    @RequestMapping(value = "/bank/new")
    public String doPreAdd(Map<String, Object> map) {
        Bank bank = new Bank();
        map.put("bank", bank);
        map.put("submitAddVisibility", "visible");
        map.put("submitEditVisibility", "hidden");
        map.put("inputIdReadOnle", Boolean.FALSE);
        map.put("inputIdBackColor", "#ffffff");
        return "pageBankCrud";
    }

}

