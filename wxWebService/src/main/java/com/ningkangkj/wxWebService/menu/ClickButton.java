package com.ningkangkj.wxWebService.menu;

/**
 * @Description 点击型菜单类型
 * @Author luckypt
 * @Date 2018/04/29
 */
public class ClickButton {
    //菜单类型
    private String type;
    //菜单名称
    private String name;
    //菜单key(键)
    private  String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
