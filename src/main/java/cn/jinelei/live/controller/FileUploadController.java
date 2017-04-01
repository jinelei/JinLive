package cn.jinelei.live.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by jinelei on 17-3-31.
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(method = RequestMethod.POST)
    public void fileuploadPost(@RequestPart("filename") byte[] img){
        logger.debug("length: " +  img.length);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String fileupload(){
        return "fileupload";
    }

    @RequestMapping(value = "/test.png")
    public String testFFmpeg(MultipartHttpServletRequest request){
//        logger.debug(requestBody.toString());
        logger.debug(request.toString());
        return "fileupload";
    }
}
