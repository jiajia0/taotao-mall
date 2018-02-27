package com.taotao.rest.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品分类列表
 * @Author Leafage
 * @Date 2018/2/26 14:24
 **/
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

//    @RequestMapping(value = "/itemcat/list", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
//    @ResponseBody
//    public String getItemCatList(String callback) {
//        CatResult itemCatList = itemCatService.getItemCatList();
//        // 把pojo转换为字符串
//        String json = JsonUtils.objectToJson(itemCatList);
//        // 拼装返回值
//        String result = callback + "(" + json + ")";
//        return result;
//    }

    @RequestMapping("/itemcat/list")
    @ResponseBody
    public Object getItemCatList(String callback) {
        CatResult catResult = itemCatService.getItemCatList();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

}
