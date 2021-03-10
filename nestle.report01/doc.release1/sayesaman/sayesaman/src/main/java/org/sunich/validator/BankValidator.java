package org.sunich.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.sunich.model.Bank;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/15/13
 * Time: 8:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class BankValidator implements Validator {
    @Override
    public boolean supports(Class<?> c) {
        return Bank.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object command, Errors errors) {
        System.out.println("******************************* validate");
        Bank bank = (Bank) command;

        if (String.valueOf(bank.getId()).equals("0") || String.valueOf(bank.getId()).equals(""))
            errors.rejectValue("id", "error.id");


        if (String.valueOf(bank.getName()).trim().equals(""))
            errors.rejectValue("name", "error.name");

        if (String.valueOf(bank.getCode()).trim().equals(""))
            errors.rejectValue("name", "error.code");

        if (String.valueOf(bank.getCode2()).trim().equals(""))
            errors.rejectValue("name", "error.code2");
    }
}
