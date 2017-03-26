package cn.jinelei.live.controller;

import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Level;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = {"/index", "/"})
    public String index(){
        logger.log(Level.INFO,"index info");
        return "index";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("msg","this msg from server");
        logger.log(Level.INFO, model.toString());
        return "test";
    }


}
