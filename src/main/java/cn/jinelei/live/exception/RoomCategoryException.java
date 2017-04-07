package cn.jinelei.live.exception;

/**
 * Created by jinelei on 17-4-7.
 */
public class RoomCategoryException extends Throwable {

    public static final String ROOM_NOT_EXIST = "0";
    public static final String ROOM_NOT_UNIQUE = "1";
    public static final String ROOM_WAS_EXIST = "2";
    public static final String ROOM_INSERT_FAILED= "3";

    public RoomCategoryException(String message) {
        super(message);
    }
}
