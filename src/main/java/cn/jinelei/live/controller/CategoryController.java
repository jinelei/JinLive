package cn.jinelei.live.controller;

import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.model.data.Category;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.service.CategoryService;
import cn.jinelei.live.service.ViRoomUserCategoryService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    private CategoryService categoryService;
    @Autowired
    private ViRoomUserCategoryService viRoomUserCategoryService;

    @Value("${live_item_page_limit}")
    private int LiveItemPageLimit;

    @RequestMapping(value = "/cid/{cid}", method = RequestMethod.GET)
    public ModelAndView searchGet(@PathVariable int cid, ModelAndView model) {
        logger.debug("search cid: " + cid);
        try {
            model.addObject("categoryName", categoryService.getCategory(cid).getCategoryName());
        } catch (CategoryException e) {
            e.printStackTrace();
        }
        List<ViRoomUserCategory> viRoomUserCategoryByCategory = viRoomUserCategoryService.getAllViRoomUserCategoryByCategory(cid);
        if (viRoomUserCategoryByCategory.size() > 0) {
            model.addObject("byCategoryId", viRoomUserCategoryByCategory);
        }
        model.setViewName("category");
        logger.debug(model.toString());
        return model;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView allCategory(ModelAndView model) {
        model.setViewName("category");
        model.addObject("categoryName","所有分类");
//        List<ViRoomUserCategory> viRoomUserCategories = null;
//        PageInfo<ViRoomUserCategory> viRoomUserCategoryPageInfo = viRoomUserCategoryService.getAllViRoomUserCategoryByStatusPageInfo(RoomStatus.ONLINE.ordinal());
//        if (viRoomUserCategoryPageInfo.getTotal() / LiveItemPageLimit > 0) {
//            viRoomUserCategories = viRoomUserCategoryService.getAllViRoomUserCategoryByStatusLimit(RoomStatus.ONLINE.ordinal(), 0, LiveItemPageLimit);
//        } else {
//            viRoomUserCategories = viRoomUserCategoryService.getAllViRoomUserCategoryByStatus(RoomStatus.ONLINE.ordinal());
//        }
//        model.addObject("byOnline", viRoomUserCategories);

        Map<Integer, List<ViRoomUserCategory>> result = new HashMap<Integer, List<ViRoomUserCategory>>();

        List<Category> categories = categoryService.getCategoryAll();
        categories.forEach(category -> {
            List<ViRoomUserCategory> viRoomUserCategories = viRoomUserCategoryService.getAllViRoomUserCategoryByCategory(category.getCategoryId());
            result.put(category.getCategoryId(), viRoomUserCategories);
        });

        model.addObject("status", result.isEmpty() ? 1 : 0);
        model.addObject("roomMap", result);
        model.addObject("categoryList", categories);
        logger.debug(result.toString());
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/list/json", method = RequestMethod.GET)
    public String getCategoryListJson() {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        List<Category> categoryList = categoryService.getCategoryAll();
        jsonObject.add("list", gson.toJsonTree(categoryList));
        return jsonObject.toString();
    }
}
