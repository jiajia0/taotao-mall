package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.impl.ItemServiceImpl;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品查询Controller
 * @Author Leafage
 * @Date 2018/2/22 14:47
 **/

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {

        TbItem tbItem = itemService.getItemById(itemId);

        return tbItem;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(int page,int rows) {
        EUDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }
}
