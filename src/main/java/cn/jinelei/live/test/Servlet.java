package cn.jinelei.live.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jinelei on 17-3-29.
 */
@WebServlet(name = "MineServlet")
public class Servlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Servlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("mineservlet do post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("mineservlet do get");
        Runtime runtime = Runtime.getRuntime();
//        runtime.exec("touch /usr/local/nginx/html/screenshot/asdf");
//        runtime.exec("rm -rf /usr/local/nginx/html/screenshot/asdf.png");
//        runtime.exec("ffmpeg -i rtmp://localhost:1935/live/video0 -vframes 1 /usr/local/nginx/html/screenshot/asdf.png");
        runtime.exec("curl -F 'filename=@/usr/local/nginx/html/screenshot/video0.png' http://192.168.31.169:8080/live/fileupload");
    }
}
