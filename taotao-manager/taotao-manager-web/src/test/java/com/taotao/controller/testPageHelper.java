package com.taotao.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试PageHelper
 * @Author Leafage
 * @Date 2018/2/22 17:53
 **/
public class testPageHelper {

    @Test
    public void testPageHelper() {
        // 创建一个Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        // 从spring容器中获得Mapper的代理对象
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
        // 执行查询并分页
        TbItemExample example = new TbItemExample();

        // 分页处理
        PageHelper.startPage(1, 10);
        List<TbItem> tbItems = mapper.selectByExample(example);

        for (TbItem tbItem : tbItems) {
            System.out.println(tbItem.getTitle());
        }

        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        System.out.println(pageInfo.getTotal());

    }

}
