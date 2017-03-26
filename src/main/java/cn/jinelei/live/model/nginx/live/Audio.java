package cn.jinelei.live.model.nginx.live;

/**
 * Created by jinelei on 17-3-26.
 */
public class Audio {
    private String codec;
    private String profile;
    private int channels;
    private int sample_rate;

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

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public int getSample_rate() {
        return sample_rate;
    }

    public void setSample_rate(int sample_rate) {
        this.sample_rate = sample_rate;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "codec='" + codec + '\'' +
                ", profile='" + profile + '\'' +
                ", channels=" + channels +
                ", sample_rate=" + sample_rate +
                '}';
    }
}
