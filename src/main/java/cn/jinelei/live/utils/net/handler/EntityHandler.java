package cn.jinelei.live.utils.net.handler;

import cn.jinelei.live.model.nginx.RTMP;
import cn.jinelei.live.model.nginx.Server;
import cn.jinelei.live.model.nginx.live.Audio;
import cn.jinelei.live.model.nginx.live.Live;
import cn.jinelei.live.model.nginx.live.Video;
import cn.jinelei.live.model.nginx.vod.Vod;
import org.apache.commons.digester3.Digester;
import org.apache.http.HttpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Created by jinelei on 17-3-26.
 */
public class EntityHandler {

    private static final Logger logger = LoggerFactory.getLogger(EntityHandler.class);

    public RTMP handleEntity(HttpEntity entity) {
        RTMP rtmp = null;
        Digester digester = new Digester();
        digester.setValidating(false);

        digester.addObjectCreate("rtmp", RTMP.class);

        digester.addBeanPropertySetter("rtmp/nginx_version", "nginx_version");
        digester.addBeanPropertySetter("rtmp/nginx_rtmp_version", "nginx_rtmp_version");
        digester.addBeanPropertySetter("rtmp/compiler", "compiler");
        digester.addBeanPropertySetter("rtmp/built", "built");
        digester.addBeanPropertySetter("rtmp/pid", "pid");
        digester.addBeanPropertySetter("rtmp/uptime", "uptime");
        digester.addBeanPropertySetter("rtmp/naccepted", "naccepted");
        digester.addBeanPropertySetter("rtmp/bw_in", "bw_in");
        digester.addBeanPropertySetter("rtmp/bytes_in", "bytes_in");
        digester.addBeanPropertySetter("rtmp/bw_out", "bw_out");
        digester.addBeanPropertySetter("rtmp/bytes_out", "bytes_out");

        digester.addObjectCreate("rtmp/server", Server.class);

        digester.addObjectCreate("rtmp/server/application/play", Vod.class);

        digester.addObjectCreate("rtmp/server/application/play/stream", cn.jinelei.live.model.nginx.vod.Stream.class);

        digester.addBeanPropertySetter("rtmp/server/application/play/stream/name", "name");

        digester.addObjectCreate("rtmp/server/application/play/stream/client", cn.jinelei.live.model.nginx.vod.Client.class);

        digester.addBeanPropertySetter("rtmp/server/application/play/stream/client/id", "id");
        digester.addBeanPropertySetter("rtmp/server/application/play/stream/client/address", "address");
        digester.addBeanPropertySetter("rtmp/server/application/play/stream/client/time", "time");
        digester.addBeanPropertySetter("rtmp/server/application/play/stream/client/flashver", "flashver");
        digester.addBeanPropertySetter("rtmp/server/application/play/stream/client/timestamp", "timestamp");
        digester.addSetNext("rtmp/server/application/play/stream/client", "addClient");
        digester.addBeanPropertySetter("rtmp/server/application/play/stream/nclients", "nclients");

        digester.addSetNext("rtmp/server/application/play/stream", "addStream");

        digester.addBeanPropertySetter("rtmp/server/application/play/nclients", "nclients");

        digester.addSetNext("rtmp/server/application/play", "addApplication");

//        digester.addBeanPropertySetter("rtmp/server/application/play",);

        digester.addObjectCreate("rtmp/server/application/live", Live.class);

        digester.addObjectCreate("rtmp/server/application/live/stream", cn.jinelei.live.model.nginx.live.Stream.class);

        digester.addBeanPropertySetter("rtmp/server/application/live/stream/name", "name");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/time", "time");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/bw_in", "bw_in");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/bytes_in", "bytes_in");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/bw_out", "bw_out");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/bytes_out", "bytes_out");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/bw_audio", "bw_audio");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/bw_video", "bw_video");

        digester.addObjectCreate("rtmp/server/application/live/stream/client", cn.jinelei.live.model.nginx.live.Client.class);

        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/id", "id");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/address", "address");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/time", "time");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/flashver", "flashver");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/dropped", "dropped");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/avsync", "avsync");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/timestamp", "timestamp");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/publishing", "publishing");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/client/active", "active");

        digester.addSetNext("rtmp/server/application/live/stream/client", "addClient");

        digester.addObjectCreate("rtmp/server/application/live/stream/meta/video", Video.class);
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/video/width", "width");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/video/height", "height");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/video/frame_rate", "frame_rate");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/video/codec", "codec");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/video/profile", "profile");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/video/compat", "compat");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/video/level", "level");
        digester.addSetNext("rtmp/server/application/live/stream/meta/video", "setVideo");

        digester.addObjectCreate("rtmp/server/application/live/stream/meta/audio", Audio.class);
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/audio/codec", "codec");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/audio/profile", "profile");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/audio/channels", "channels");
        digester.addBeanPropertySetter("rtmp/server/application/live/stream/meta/audio/sample_rate", "sample_rate");
        digester.addSetNext("rtmp/server/application/live/stream/meta/audio", "setAudio");

        digester.addSetNext("rtmp/server/application/live/stream", "addStream");

        digester.addSetNext("rtmp/server/application/live", "addApplication");

        digester.addSetNext("rtmp/server", "setServer");


        try {
            rtmp = digester.parse(entity.getContent());
            logger.debug(rtmp.toString());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rtmp;
    }

}
