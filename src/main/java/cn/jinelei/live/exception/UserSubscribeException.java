package cn.jinelei.live.exception;

/**
 * Created by jinelei on 17-4-7.
 */
public class UserSubscribeException extends Exception {

    public static final String USER_SUBSCRIBE_NOT_EXIST = "0";
    public static final String USER_SUBSCRIBE_NOT_UNIQUE = "1";
    public static final String USER_SUBSCRIBE_WAS_EXIST = "2";
    public static final String USER_SUBSCRIBE_INSERT_FAILED= "3";

    /***    error code
     * @param message
     * 1:user not exist
     * 2:user not unique
     */
    public UserSubscribeException(String message) {
        super(message);
    }


}
