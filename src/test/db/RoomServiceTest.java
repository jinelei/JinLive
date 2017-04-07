import cn.jinelei.live.dao.UserMapper;
import cn.jinelei.live.exception.RoomException;
import cn.jinelei.live.exception.UserException;
import cn.jinelei.live.model.data.Room;
import cn.jinelei.live.model.data.User;
import cn.jinelei.live.model.enumstatus.room.RoomStatus;
import cn.jinelei.live.service.RoomService;
import cn.jinelei.live.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by jinelei on 17-4-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:live-servlet.xml", "classpath:spring-config.xml"})
@WebAppConfiguration
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @Test
    public void testRoom() throws RoomException {
//        Room room = new Room();
//        room.setUserId(1);
//        room.setRoomName("console test");
//        room.setRoomStatus(RoomStatus.OFFLINE.ordinal());
//        room.setRoomScreenshot("null null");
//        room.setRoomIntroduce("there is nothing");
//        room.setStreamKey("asdfasdfasdfasdfasd");
//        Room room1 = roomService.insertRoom(room);
//        Room room2 = roomService.insertRoom("test roomservice1", RoomStatus.ONLINE.ordinal(), "", "", 1, "asdfasdfaasdfsdfasdfasd");
//
//        room1.setRoomIntroduce("from roomservice test mod");
//        roomService.updateRoom(room1);

//        System.out.println(roomService.getRoom(room1.getRoomId()));
        Room room5 = roomService.getRoom(10011);
        System.out.println(room5);

//        room5.setRoomScreenshot("new change");
//        roomService.updateRoom(room5);

        roomService.deleteRoom(room5);


//        roomService.getAllRoomByUser(1).forEach(room3 -> System.out.println(room3));
//        roomService.getAllRoom().forEach(room4 -> System.out.println(room4));

//        roomService.getAllRoomFuzzyName("%test%").forEach(room -> System.out.println(room));
//        roomService.getAllRoomLimit(0,3).forEach(room4 -> System.out.println(room4));
    }

}
