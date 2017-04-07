package cn.jinelei.live.exception;

/**
 * Created by jinelei on 17-4-7.
 */
public class TagException extends Throwable {

    public static final String TAG_NOT_EXIST = "0";
    public static final String TAG_NOT_UNIQUE = "1";
    public static final String TAG_WAS_EXIST = "2";
    public static final String TAG_INSERT_FAILED= "3";
    public static final String TAG_DELETE_FAILED= "4";
    public static final String TAG_UPDATE_FAILED= "4";

    public TagException(String message) {
        super(message);
    }
}
