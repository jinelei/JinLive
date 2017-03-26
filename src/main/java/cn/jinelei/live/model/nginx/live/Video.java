package cn.jinelei.live.model.nginx.live;

/**
 * Created by jinelei on 17-3-26.
 */
public class Video {
    private int width;
    private int height;
    private int frame_rate;
    private String codec;
    private String profile;
    private int compat;
    private double level;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getFrame_rate() {
        return frame_rate;
    }

    public void setFrame_rate(int frame_rate) {
        this.frame_rate = frame_rate;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getCompat() {
        return compat;
    }

    public void setCompat(int compat) {
        this.compat = compat;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Video{" +
                "width=" + width +
                ", height=" + height +
                ", frame_rate=" + frame_rate +
                ", codec='" + codec + '\'' +
                ", profile='" + profile + '\'' +
                ", compat=" + compat +
                ", level=" + level +
                '}';
    }
}
