package cn.jinelei.live.model.nginx;

/**
 * Created by jinelei on 17-3-26.
 */
public class RTMP {
    private String nginx_version;
    private String nginx_rtmp_version;
    private String compiler;
    private String built;
    private int pid;
    private int uptime;
    private int naccepted;
    private int bw_in;
    private long bytes_in;
    private long bw_out;
    private long bytes_out;
    private Server server;

    public String getNginx_version() {
        return nginx_version;
    }

    public void setNginx_version(String nginx_version) {
        this.nginx_version = nginx_version;
    }

    public String getNginx_rtmp_version() {
        return nginx_rtmp_version;
    }

    public void setNginx_rtmp_version(String nginx_rtmp_version) {
        this.nginx_rtmp_version = nginx_rtmp_version;
    }

    public String getCompiler() {
        return compiler;
    }

    public void setCompiler(String compiler) {
        this.compiler = compiler;
    }

    public String getBuilt() {
        return built;
    }

    public void setBuilt(String built) {
        this.built = built;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUptime() {
        return uptime;
    }

    public void setUptime(int uptime) {
        this.uptime = uptime;
    }

    public int getNaccepted() {
        return naccepted;
    }

    public void setNaccepted(int naccepted) {
        this.naccepted = naccepted;
    }

    public int getBw_in() {
        return bw_in;
    }

    public void setBw_in(int bw_in) {
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

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "RTMP{" +
                "nginx_version='" + nginx_version + '\'' +
                ", nginx_rtmp_version='" + nginx_rtmp_version + '\'' +
                ", compiler='" + compiler + '\'' +
                ", built='" + built + '\'' +
                ", pid=" + pid +
                ", uptime=" + uptime +
                ", naccepted=" + naccepted +
                ", bw_in=" + bw_in +
                ", bytes_in=" + bytes_in +
                ", bw_out=" + bw_out +
                ", bytes_out=" + bytes_out +
                ", server=" + server +
                '}';
    }
}
