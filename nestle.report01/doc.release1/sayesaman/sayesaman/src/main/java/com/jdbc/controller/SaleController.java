package com.jdbc.controller;

import com.jdbc.bo.JdbcBo;
import com.jdbc.model.AccYear;
import com.jdbc.model.Dc;
import com.jdbc.model.Personnel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/14/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/Sale")
public class SaleController {
    private static Logger log = Logger.getLogger(SaleController.class);

    @Autowired
    private JdbcBo bo;

    @RequestMapping("/List")
    public String setupForm(Map<String, Object> map) {
        //************************************************************
        List<Dc> dcs = new LinkedList<Dc>();
        dcs = bo.getDc();

        Map<String, String> linkedHashMapDc = new LinkedHashMap<String, String>();
        for (Dc dc : dcs)
            linkedHashMapDc.put(String.valueOf(dc.getId()), dc.getName());
        map.put("MapDc", linkedHashMapDc);
        //************************************************************

        //************************************************************
        List<AccYear> accYears = new LinkedList<AccYear>();
        accYears = bo.getAccYear();

        Map<String, String> linkedHashMapAccYear = new LinkedHashMap<String, String>();
        for (AccYear accYear : accYears)
            linkedHashMapAccYear.put(String.valueOf(accYear.getId()), accYear.getName());
        map.put("MapAccYear", linkedHashMapAccYear);
        //************************************************************

        //************************************************************
        List<Personnel> personnels = new LinkedList<Personnel>();
        personnels = bo.getPersonnel("0", "0", "1", "0");

        Map<String, String> linkedHashMapPersonnel = new LinkedHashMap<String, String>();
        for (Personnel personnel : personnels)
            linkedHashMapPersonnel.put(String.valueOf(personnel.getID()), personnel.getPersonnelName());

        map.put("MapPersonnel", linkedHashMapPersonnel);
        //************************************************************

        return "pageSale";
    }
}

