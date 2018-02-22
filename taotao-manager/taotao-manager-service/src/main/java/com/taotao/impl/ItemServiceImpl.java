package com.taotao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 返回查询商品id的结果
 * @Author Leafage
 * @Date 2018/2/22 13:49
 **/

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(Long itemId) {
//        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);

        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        if( tbItems != null && tbItems.size() > 0) {
            TbItem item = tbItems.get(0);
            return item;
        }
        return null;
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        // 查询商品列表
        TbItemExample example = new TbItemExample();
        // 分页处理
        PageHelper.startPage(page, rows);
        List<TbItem> items = itemMapper.selectByExample(example);

        // 创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(items);
        // 请去除总条数
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);

        result.setTotal(pageInfo.getTotal());

        return result;
    }
}
