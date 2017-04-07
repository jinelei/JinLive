package cn.jinelei.live.exception;

/**
 * Created by jinelei on 17-4-7.
 */
public class RoomCategoryException extends Throwable {

    public static final String ROOMCATEGORY_NOT_EXIST = "0";
    public static final String ROOMCATEGORY_NOT_UNIQUE = "1";
    public static final String ROOMCATEGORY_WAS_EXIST = "2";
    public static final String ROOMCATEGORY_INSERT_FAILED = "3";
    public static final String ROOMCATEGORY_DELETE_FAILED = "4";
    public static final String ROOMCATEGORY_UPDATE_FAILED = "4";

    public RoomCategoryException(String message) {
        super(message);
    }
}
