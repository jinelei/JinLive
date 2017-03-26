package cn.jinelei.live.model.nginx.live;

import java.sql.Date;

public  class Client {
    private int id;
    private String address;
    private long time;
    private String flashver;
    private int dropped;
    private int avsync;
    private long timestamp;
    private boolean publishing;
    private boolean active;

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

    public int getDropped() {
        return dropped;
    }

    public void setDropped(int dropped) {
        this.dropped = dropped;
    }

    public int getAvsync() {
        return avsync;
    }

    public void setAvsync(int avsync) {
        this.avsync = avsync;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isPublishing() {
        return publishing;
    }

    public void setPublishing(boolean publishing) {
        this.publishing = publishing;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", time=" + time +
                ", flashver='" + flashver + '\'' +
                ", dropped=" + dropped +
                ", avsync=" + avsync +
                ", timestamp=" + timestamp +
                ", publishing=" + publishing +
                ", active=" + active +
                '}';
    }
}
