package com.ningkangkj.wxWebService.menu;

/**
 * @Description 视图型菜单事件
 * @Author luckypt
 * @Date 2018/04/29
 */
public class ViewButton {
    //菜单类型
    private String type;
    //菜单名称
    private String name;
    //视图型菜单的跳转url
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
