package com.taotao.impl;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询商品分类
 * @Author Leafage
 * @Date 2018/2/23 14:23
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EUTreeNode> getCatList(long parentId) {
        // 创建查询条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        // 根据条件查询
        List<TbItemCat> itemCats = itemCatMapper.selectByExample(example);
        List<EUTreeNode> euTreeNodes = new ArrayList<>();

        // 把列表转换为treeNode类型
        for (TbItemCat tbItemCat : itemCats) {
            EUTreeNode node = new EUTreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            euTreeNodes.add(node);
        }

        return euTreeNodes;
    }
}
