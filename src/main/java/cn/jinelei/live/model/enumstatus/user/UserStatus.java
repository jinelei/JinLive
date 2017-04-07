package cn.jinelei.live.model.enumstatus.user;

/**
 * Created by jinelei on 17-4-7.
 */
public enum UserStatus {
    INACTIVE(1), ACTIVE(2), ONLINE(4), OFFLINE(8), DELETE(16);
    private int value;

    UserStatus(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
