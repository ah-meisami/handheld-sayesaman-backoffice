package net.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/25/13
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/JSON")
public class JSONController {
    private static final Logger log = Logger.getLogger(JSONController.class);

    @RequestMapping("/List")
    public String setupForm() {
        return "pageJSON";
    }

    @RequestMapping(value = "/ajaxJsonRequest", method = {RequestMethod.GET, RequestMethod.POST})
    public
    @ResponseBody
    String ajaxJsonRequest(HttpServletRequest request) {
        String message = request.getParameter("message");

        log.debug("----------------------------------------------------------------------------");
        log.debug(message);
        log.debug("----------------------------------------------------------------------------");
        return "Salam " + message;
    }
}
