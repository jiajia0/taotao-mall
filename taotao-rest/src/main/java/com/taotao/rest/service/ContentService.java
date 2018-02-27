package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * @Author Leafage
 * @Date 2018/2/27 13:51
 **/
public interface ContentService {
    List<TbContent> getContentList(long contentCid);
}
