package cn.jinelei.live.model.nginx.vod;


import java.util.Date;

/**
 * Created by jinelei on 17-3-26.
 */
public class Client {
    private int id;
    private String address;
    private long time;
    private String flashver;
    private long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getFlashver() {
        return flashver;
    }

    public void setFlashver(String flashver) {
        this.flashver = flashver;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", time=" + time +
                ", flashver='" + flashver + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
