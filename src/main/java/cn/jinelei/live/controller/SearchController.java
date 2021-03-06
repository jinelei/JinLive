package cn.jinelei.live.controller;

import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.Tag;
import cn.jinelei.live.model.data.TagCategory;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.service.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@PropertySource("classpath:/application.properties")
@RequestMapping(value = "/search")
public class SearchController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private Environment environment;
    @Autowired
    private ViRoomUserCategoryService viRoomUserCategoryService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagCategoryService tagCategoryService;
    @Autowired
    private TagService tagService;

    @Value("${tomcat_server}")
    private String tomcat_server;

    @RequestMapping(value = "/key/{key}", method = RequestMethod.GET)
    public ModelAndView searchPost(@PathVariable("key") String key) {
        ModelAndView model = new ModelAndView("search");
        String searchKey = String.format("%%%s%%", key);
        logger.debug("search key: " + searchKey);
        List<ViRoomUserCategory> viRoomUserCategoryFuzzyRoomName = viRoomUserCategoryService.getAllViRoomUserCategoryFuzzyRoomName(searchKey);
        List<ViRoomUserCategory> viRoomUserCategoryFuzzyUsername = viRoomUserCategoryService.getAllViRoomUserCategoryFuzzyUsername(searchKey);
        model.addObject("fuzzyUserName", viRoomUserCategoryFuzzyUsername);
        model.addObject("fuzzyRoomName", viRoomUserCategoryFuzzyRoomName);
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String searchGet() {
        Gson gson = new Gson();

        JsonObject resObj = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        List<Tag> tags = tagService.getTagAll();
        tags.forEach(tag -> {
            JsonObject itemJO = new JsonObject();
            JsonObject tagJO = new JsonObject();
            JsonObject categoryJO = new JsonObject();
            tagJO.add("tagName", gson.toJsonTree(tag));
            JsonArray array = new JsonArray();
            tagCategoryService.getTagCategoryByTagId(tag.getTagId()).forEach(tagCategory -> {
                try {
                    Category category = categoryService.getCategory(tagCategory.getCategoryId());
                    array.add(gson.toJson(category));
                } catch (CategoryException e) {
                    e.printStackTrace();
                }
            });
            categoryJO.add("categoryArray", array);
            itemJO.add("tag", tagJO);
            itemJO.add("category", categoryJO);
            jsonArray.add(itemJO);
        });

        resObj.add("array", jsonArray);

//        logger.debug(resObj.toString());
        return resObj.toString();
    }


}
