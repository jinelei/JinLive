package cn.jinelei.live.model.nginx.live;

import java.util.ArrayList;
import java.util.List;

public  class Stream {

    private String name;
    private long time;
    private long bw_in;
    private long bytes_in;
    private long bw_out;
    private long bytes_out;
    private long bw_audio;
    private long bw_video;
    private List<Client> clients = new ArrayList<Client>();
    private Video video;
    private Audio audio;
    private boolean publishing;
    private boolean active;

    public void addClient(Client client){
        clients.add(client);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getBw_in() {
        return bw_in;
    }

    public void setBw_in(long bw_in) {
        this.bw_in = bw_in;
    }

    public long getBytes_in() {
        return bytes_in;
    }

    public void setBytes_in(long bytes_in) {
        this.bytes_in = bytes_in;
    }

    public long getBw_out() {
        return bw_out;
    }

    public void setBw_out(long bw_out) {
        this.bw_out = bw_out;
    }

    public long getBytes_out() {
        return bytes_out;
    }

    public void setBytes_out(long bytes_out) {
        this.bytes_out = bytes_out;
    }

    public long getBw_audio() {
        return bw_audio;
    }

    public void setBw_audio(long bw_audio) {
        this.bw_audio = bw_audio;
    }

    public long getBw_video() {
        return bw_video;
    }

    public void setBw_video(long bw_video) {
        this.bw_video = bw_video;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
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
        return "Stream{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", bw_in=" + bw_in +
                ", bytes_in=" + bytes_in +
                ", bw_out=" + bw_out +
                ", bytes_out=" + bytes_out +
                ", bw_audio=" + bw_audio +
                ", bw_video=" + bw_video +
                ", clients=" + clients +
                ", video=" + video +
                ", audio=" + audio +
                ", publishing=" + publishing +
                ", active=" + active +
                '}';
    }
}
