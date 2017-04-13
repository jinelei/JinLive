package cn.jinelei.live.controller;

import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.model.enumstatus.user.UserStatus;
import cn.jinelei.live.service.RoomService;
import cn.jinelei.live.service.UserService;
import cn.jinelei.live.service.ViRoomUserCategoryService;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;


/**
 * Created by jinelei on 17-3-26.
 */
@Controller
@PropertySource("classpath:/application.properties")
@RequestMapping(value = "/room")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;
    @Autowired
    private ViRoomUserCategoryService viRoomUserCategoryService;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView roomPost(ModelAndView model, @RequestParam(value = "stream_key") String streamKey) {
        model.addObject("stream_key", streamKey);
        try {
            ViRoomUserCategory room = viRoomUserCategoryService.getViRoomUserCategoryByStreamKey(streamKey.trim());
            model.addObject("status", 0);
            model.addObject("room", room);
        } catch (RoomException e) {
            model.addObject("status", 0);
        }
        logger.debug(model.toString());
        model.setViewName("room");
        return model;
    }

    @RequestMapping(value = "/roomset", method = RequestMethod.POST)
    public ModelAndView roomSet(@RequestParam(value = "room_name") String roomName,
                                @RequestParam(value = "room_introduce") String roomIntroduce,
                                @RequestParam(value = "phone") String phone,
                                @RequestParam(value = "email") String email) {
        ModelAndView model = new ModelAndView("userinfo");
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.debug(object.toString());
        if (object instanceof String) {
            model.addObject("status", 1);
        } else {
            User user = (User) object;
            try {
                Room room = roomService.insertRoom(roomName, RoomStatus.OFFLINE.ordinal(), "", roomIntroduce, user.getUserId(), UUID.randomUUID().toString());
                user.setUserStatus(user.getUserStatus() | Integer.valueOf(UserStatus.ANCHOR.toString()));
                userService.updateUser(user);
                model.addObject("status", 0);
                model.addObject("user", user);
            } catch (RoomException e) {
                model.addObject("status", 2);
            } catch (UserException e) {
                model.addObject("status", 3);
            }
        }
        logger.debug(model.toString());
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/stream_key")
    public String getStreamKey() {
        JsonObject jsonObject = new JsonObject();
        try {
            Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            logger.debug(object.toString());
            if (object instanceof String) {
                jsonObject.addProperty("status", 1);
            } else {
                ViRoomUserCategory roomUserCategory = viRoomUserCategoryService.getViRoomUserCategoryByUserId(((User) object).getUserId());
                jsonObject.addProperty("status", 0);
                jsonObject.addProperty("stream_key", roomUserCategory.getStreamKey());
            }
        } catch (RoomException e) {
            jsonObject.addProperty("status", 1);
        }
        logger.debug(jsonObject.toString());
        return jsonObject.toString();
    }

}
