package cn.jinelei.live.model.nginx.vod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinelei on 17-3-26.
 */
public class Stream {
    private String name;
    private boolean active;
    private int nclients;
    private List<Client> clientList = new ArrayList<Client>();

    public void addClient(Client client){
        clientList.add(client);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getNclients() {
        return nclients;
    }

    public void setNclients(int nclients) {
        this.nclients = nclients;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "name='" + name + '\'' +
                ", active=" + active +
                ", nclients=" + nclients +
                ", clientList=" + clientList +
                '}';
    }
}
