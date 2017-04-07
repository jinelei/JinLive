package cn.jinelei.live.exception;

/**
 * Created by jinelei on 17-4-7.
 */
public class TagCategoryException extends Throwable {

    public static final String TAGCATEGORY_NOT_EXIST = "0";
    public static final String TAGCATEGORY_NOT_UNIQUE = "1";
    public static final String TAGCATEGORY_WAS_EXIST = "2";
    public static final String TAGCATEGORY_INSERT_FAILED= "3";
    public static final String TAGCATEGORY_DELETE_FAILED= "4";

    public TagCategoryException(String message) {
        super(message);
    }

}
