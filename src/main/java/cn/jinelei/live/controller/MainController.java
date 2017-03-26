package cn.jinelei.live.controller;

import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Level;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);
    @RequestMapping(value = "/index")
    public String index(){
        logger.log(Level.INFO,"index info");
        return "index";
    }


}
