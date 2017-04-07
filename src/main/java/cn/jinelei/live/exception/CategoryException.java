package cn.jinelei.live.exception;

/**
 * Created by jinelei on 17-4-7.
 */
public class CategoryException extends Throwable {

    public static final String CATEGORY_NOT_EXIST = "0";
    public static final String CATEGORY_NOT_UNIQUE = "1";
    public static final String CATEGORY_WAS_EXIST = "2";
    public static final String CATEGORY_INSERT_FAILED= "3";
    public static final String CATEGORY_DELETE_FAILED= "4";
    public static final String CATEGORY_UPDATE_FAILED= "4";

    public CategoryException(String message) {
        super(message);
    }
}
