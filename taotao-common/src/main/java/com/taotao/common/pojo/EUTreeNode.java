package com.taotao.common.pojo;

/**
 * easyUI 樹形控件結點格式
 * @Author Leafage
 * @Date 2018/2/23 13:52
 **/
public class EUTreeNode {
    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
