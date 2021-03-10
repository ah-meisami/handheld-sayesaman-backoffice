package org.sunich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sunich.bo.PersonBO;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/14/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class PersonController {

    @Autowired
    private PersonBO personBO;

    @RequestMapping("/Person")
    public String setupForm(Map<String, Object> map) {
        map.put("personList", personBO.getPersons());
        return "pagePersonList";
    }
}

