package com.jdbc.controller;

import com.jdbc.bo.JdbcBo;
import com.jdbc.json.CustomResponse1;
import com.jdbc.json.CustomResponseVocherHdr;
import com.jdbc.model.AccYear;
import com.jdbc.model.Dc;
import com.jdbc.model.Personnel;
import com.jdbc.model.VocherHdr;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String List(Map<String, Object> map) {
        //************************************************************
        List<Dc> dcs = new LinkedList<Dc>();
        dcs = bo.getDc(false);

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

    @RequestMapping(value = "/List1", method = RequestMethod.GET)
    public
    @ResponseBody
    CustomResponse1 List1() {

        CustomResponse1 response = new CustomResponse1();

        //************************************************************
        List<Dc> dcs = new LinkedList<Dc>();
        dcs = bo.getDc(false);

        List<AccYear> accYears = new LinkedList<AccYear>();
        accYears = bo.getAccYear();
        //************************************************************

        response.setDcs(dcs);
        response.setAccYears(accYears);

        return response;
    }

    @RequestMapping(value = "/List3", method = RequestMethod.GET)
    public
    @ResponseBody
    CustomResponseVocherHdr List3(
            @RequestParam("dc") String dc,
            @RequestParam("accYear") String accYear,
            @RequestParam("_search") String _search,
            @RequestParam("rows") String rows,
            @RequestParam("page") String page, //page darkhast shode
            @RequestParam("sidx") String sidx,
            @RequestParam("sord") String sord
    ) {
        log.debug(accYear);

        CustomResponseVocherHdr response = new CustomResponseVocherHdr();

        List<VocherHdr> list = bo.getVocherHdr(dc, accYear, rows, page, sidx, sord);

        int totalRec = list.size();
        float totalPage = Math.round(totalRec / Integer.parseInt(rows));

        response.setRecords(String.valueOf(totalRec));
        response.setPage(page);
        response.setTotal(String.valueOf(totalPage));
        response.setRows(list);

        return response;
    }

    @RequestMapping("/List2")
    public String List2() {
        return "pageSale2";
    }

}

