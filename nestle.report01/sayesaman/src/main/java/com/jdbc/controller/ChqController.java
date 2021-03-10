package com.jdbc.controller;

import com.jdbc.bo.JdbcBo;
import com.jdbc.json.StatusResponse;
import com.jdbc.model.Cheque;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 5/14/13
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/chq")
public class ChqController {
    private static Logger Log = Logger.getLogger(ChqController.class);

    @Autowired
    private JdbcBo bo;

    //http://localhost:8080/Chq/getAll
    @RequestMapping("/getAll")
    public
    @ResponseBody
    List<Cheque>
    getAll(
            @RequestParam(value = "accYear", defaultValue = "1392") String accYear
            , @RequestParam(value = "dcRef", defaultValue = "1") String dcRef
            , @RequestParam(value = "insertDate", defaultValue = "92/08/18") String insertDate
    ) {
        List<Cheque> cheques = new LinkedList<Cheque>();
        cheques = bo.getAll(accYear, dcRef, insertDate);
        return cheques;
    }

    //http://localhost:8080/Chq/remove?id=50743717
    @RequestMapping("/remove")
    public
    @ResponseBody
    StatusResponse
    remove(
            @RequestParam(value = "id", defaultValue = "50743717") String id
    ) {
        bo.remove(id);
        return new StatusResponse(true, "Operation Completed Successfully!");
    }
}