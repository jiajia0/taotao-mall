package com.taotao.common.pojo;

import java.util.List;

/**
 * EasyUI datagrid所使用的返回结果
 * @Author Leafage
 * @Date 2018/2/22 21:01
 **/
public class EUDataGridResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
