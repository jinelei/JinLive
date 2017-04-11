package cn.jinelei.live.controller;

import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.service.ViRoomUserCategoryService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @Value("${live_item_page_limit}")
    private int LiveItemPageLimit;

    @RequestMapping(value = "/cid/{cid}", method = RequestMethod.GET)
    public ModelAndView searchGet(@PathVariable int cid, ModelAndView model) {
        logger.debug("search cid: " + cid);
        List<ViRoomUserCategory> viRoomUserCategoryByCategory = viRoomUserCategoryService.getAllViRoomUserCategoryByCategory(cid);
        if (viRoomUserCategoryByCategory.size() > 0) {
            model.addObject("byCategoryId", viRoomUserCategoryByCategory);
            model.addObject("categoryName", viRoomUserCategoryByCategory.get(0).getCategoryName());
        }
        model.setViewName("category");
        return model;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView allCategory(ModelAndView model) {
        List<ViRoomUserCategory> viRoomUserCategories = null;
        PageInfo<ViRoomUserCategory> viRoomUserCategoryPageInfo = viRoomUserCategoryService.getAllViRoomUserCategoryByStatusPageInfo(RoomStatus.ONLINE.ordinal());
        if (viRoomUserCategoryPageInfo.getTotal() / LiveItemPageLimit > 0) {
            viRoomUserCategories = viRoomUserCategoryService.getAllViRoomUserCategoryByStatusLimit(RoomStatus.ONLINE.ordinal(), 0, LiveItemPageLimit);
        } else {
            viRoomUserCategories = viRoomUserCategoryService.getAllViRoomUserCategoryByStatus(RoomStatus.ONLINE.ordinal());
        }
        model.addObject("byOnline", viRoomUserCategories);
        model.setViewName("category");
        return model;
    }

}
