package cn.jinelei.live.model.nginx.vod;

import cn.jinelei.live.model.nginx.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinelei on 17-3-26.
 */
public class Vod implements Application {

    private static String name = "vod";
    private List<Stream> streams = new ArrayList<Stream>();
    private int nclients;

    public void addStream(Stream stream){
        streams.add(stream);
    }

    public String getName() {
        return "vod";
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    public int getNclients() {
        return nclients;
    }

    public void setNclients(int nclients) {
        this.nclients = nclients;
    }

    @Override
    public String toString() {
        return "Vod{" +
                "name='" + name + '\'' +
                ", streams=" + streams +
                ", nclients=" + nclients +
                '}';
    }

}