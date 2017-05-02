package cn.jinelei.live.model.enumstatus.user;

/**
 * Created by jinelei on 17-4-7.
 */
public enum UserStatus {
    ACTIVE(2), ONLINE(4), ENABLE(8), LOCKED(16), ANCHOR(32), EXPIRED(64);
    private int value;

    UserStatus(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
