package cn.jinelei.live.controller;

import cn.jinelei.live.exception.RoomCategoryException;
import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.exception.UserSubscribeException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.data.ViRoomUserCategory;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.model.enumstatus.user.UserStatus;
import cn.jinelei.live.service.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired(required = false)
    private SimpMessagingTemplate template;
    @Autowired
    private RoomCategoryService roomCategoryService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;
    @Autowired
    private ViRoomUserCategoryService viRoomUserCategoryService;
    @Autowired
    private ViUserSubscribeService viUserSubscribeService;
    @Autowired
    private UserSubscribeService userSubscribeService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{roomId}",method = RequestMethod.GET)
    public ModelAndView roomPost(ModelAndView model, @PathVariable Integer roomId) {
        try {
            ViRoomUserCategory room = viRoomUserCategoryService.getViRoomUserCategoryByRoomId(roomId);
            model.addObject("room", room);
            model.addObject("status", 0);
            Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            logger.debug(object.toString());
            if (object instanceof String) {
                model.addObject("subscribeStatus", 2);
            } else {
                User user = (User) object;
                boolean res = viUserSubscribeService.getAllViUserSubscribeByRoomId(room.getRoomId()).stream().anyMatch(viUserSubscribe -> viUserSubscribe.getSubscriberId().equals(user.getUserId()));
                model.addObject("subscribeStatus", res ? 0 : 1);
            }
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
    @RequestMapping(value = "/info")
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
                jsonObject.addProperty("room", new Gson().toJson(roomUserCategory));
            }
        } catch (RoomException e) {
            jsonObject.addProperty("status", 1);
        }
        logger.debug(jsonObject.toString());
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String roomUpdate(@RequestParam(value = "userid", required = false) Integer userid,
                             @RequestParam(value = "type", required = false) String type,
                             @RequestParam(value = "value", required = false) String value) {
        JsonObject jsonObject = new JsonObject();
        List<Room> rooms = roomService.getAllRoomByUser(userid);
        if (rooms.size() != 1)
            jsonObject.addProperty("status", 1);
        else {
            Room updateRoom = rooms.get(0);
            boolean flag = false;
            if ("name".equals(type)) {
                updateRoom.setRoomName(value.trim());
                flag=true;
            } else if ("introduce".equals(type)) {
                updateRoom.setRoomIntroduce(value);
                flag=true;
            } else if ("category".equals(type)) {
                boolean res = roomCategoryService.insertOrUpdateRoomCategory(updateRoom.getRoomId(), Integer.valueOf(value));
                jsonObject.addProperty("status", res ? 0 : 1);
            }
            if (flag){
                try {
                    roomService.updateRoom(updateRoom);
                    jsonObject.addProperty("status", 0);
                } catch (RoomException e) {
                    jsonObject.addProperty("status", 1);
                }
            }
        }
        logger.debug(jsonObject.toString());
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/subscribe/{method}/roomid/{roomid}", method = RequestMethod.POST)
    public String handleSubscribeEvent(@PathVariable(value = "method") String method,
                                       @PathVariable(value = "roomid") Integer roomId) {
        JsonObject jsonObject = new JsonObject();
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.debug(object.toString());
        if (object instanceof String) {
            jsonObject.addProperty("status", 1);
        } else {
            User user = (User) object;
            if ("confirm".equals(method)) {
                boolean res = false;
                try {
                    try {
                        res = userSubscribeService.addSubscribe(user.getUserId(), roomId);
                        if (res)
                            jsonObject.addProperty("status", 0);
                        else
                            jsonObject.addProperty("status", 1);
                    } catch (RoomException e) {
                        jsonObject.addProperty("status", 2);
                    } catch (UserException e) {
                        jsonObject.addProperty("status", 3);
                    }
                } catch (UserSubscribeException e) {
                    jsonObject.addProperty("status", 1);
                }
            } else if ("cancel".equals(method)) {
                boolean res = false;
                try {
                    res = userSubscribeService.removeSubscribe(user.getUserId(), roomId);
                    if (res)
                        jsonObject.addProperty("status", 0);
                    else
                        jsonObject.addProperty("status", 1);

                } catch (UserSubscribeException e) {
                    jsonObject.addProperty("status", 1);
                } catch (RoomException e) {
                    jsonObject.addProperty("status", 2);
                } catch (UserException e) {
                    jsonObject.addProperty("status", 3);
                }
            } else {
                jsonObject.addProperty("status", 1);
            }
        }
        return jsonObject.toString();
    }

}
