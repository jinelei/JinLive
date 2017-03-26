package cn.jinelei.live.model.nginx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinelei on 17-3-26.
 */
public class Server {

    List<Application> applications = new ArrayList<Application>();

    public void addApplication(Application application){
        applications.add(application);
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Server{" +
                "applications=" + applications +
                '}';
    }
}
