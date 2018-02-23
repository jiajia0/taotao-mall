package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * @Author Leafage
 * @Date 2018/2/23 14:21
 **/
public interface ItemCatService {
    List<EUTreeNode> getCatList(long parentId);
}
