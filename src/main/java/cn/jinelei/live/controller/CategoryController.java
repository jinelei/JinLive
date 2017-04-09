package cn.jinelei.live.controller;

import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.Tag;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.service.CategoryService;
import cn.jinelei.live.service.TagCategoryService;
import cn.jinelei.live.service.TagService;
import cn.jinelei.live.service.ViRoomUserCategoryService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@PropertySource("classpath:/application.properties")
@RequestMapping(value = "/category")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private Environment environment;
    @Autowired
    private ViRoomUserCategoryService viRoomUserCategoryService;

    @Value("${tomcat_server_ip}")
    private String tomcat_server_ip;

    @RequestMapping(value = "/cid/{cid}", method = RequestMethod.GET)
    public String searchGet(@PathVariable int cid, ModelMap model) {
        logger.debug("search cid: " + cid);
        List<ViRoomUserCategory> viRoomUserCategoryByCategory = viRoomUserCategoryService.getAllViRoomUserCategoryByCategory(cid);
        if (viRoomUserCategoryByCategory.size() > 0) {
            model.addAttribute("byCategoryId", viRoomUserCategoryByCategory);
            model.addAttribute("categoryName", viRoomUserCategoryByCategory.get(0).getCategoryName());
        }
        return "category";
    }

}
