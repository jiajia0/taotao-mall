package com.taotao.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author Leafage
 * @Date 2018/2/23 23:36
 **/
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map pictureUpload(MultipartFile uploadFile) {
        Map result = pictureService.uploadPicture(uploadFile);
        // 为保证兼容性，需要把josn转换为字符串
        //String jsonResult = JsonUtils.objectToJson(result);
        return result;
    }

}
