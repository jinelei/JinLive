package cn.jinelei.live.model.enumstatus.user;

/**
 * Created by jinelei on 17-4-7.
 */
public enum UserTreasure {
    DEFAULT(50000);
    private int value;

    UserTreasure(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
