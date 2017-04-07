package cn.jinelei.live.exception;

/**
 * Created by jinelei on 17-4-7.
 */
public class UserException extends Exception {

    public static final String USER_NOT_EXIST = "0";
    public static final String USER_NOT_UNIQUE = "1";
    public static final String USER_WAS_EXIST = "2";

    /***    error code
     * @param message
     * 1:user not exist
     * 2:user not unique
     */
    public UserException(String message) {
        super(message);
    }


}
