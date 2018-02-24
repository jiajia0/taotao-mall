package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * @Author Leafage
 * @Date 2018/2/22 13:42
 **/
public interface ItemService {
    TbItem getItemById(Long itemId);
    EUDataGridResult getItemList(int page,int rows);
    TaotaoResult createItem(TbItem item);
}
