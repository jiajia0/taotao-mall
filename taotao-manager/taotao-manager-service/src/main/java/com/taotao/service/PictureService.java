package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author Leafage
 * @Date 2018/2/23 23:16
 **/
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
