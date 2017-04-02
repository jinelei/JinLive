package cn.jinelei.live.model;

/**
 * Created by jinelei on 17-4-1.
 */
public class Shout {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Shout{" +
                "message='" + message + '\'' +
                '}';
    }
}
