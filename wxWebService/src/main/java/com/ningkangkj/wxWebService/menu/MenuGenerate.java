package com.ningkangkj.wxWebService.menu;

import com.ningkangkj.wxWebService.util.GlobalConstants;
import com.ningkangkj.wxWebService.util.HttpUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;

/**
 * @Description 生成微信公众号的菜单
 * @Author luckypt
 * @Date 2018/04/29
 */
public class MenuGenerate {
    public static void main(String[] args) {
        ClickButton cbt = new ClickButton();
        cbt.setKey("image");
        cbt.setName("回复图片");
        cbt.setType("click");

        ViewButton vbt = new ViewButton();
        vbt.setName("博客");
        vbt.setType("view");
        vbt.setUrl("http://www.ningkangkj.com:18080/index");

        //建立子菜单
        JSONArray sub_button = new JSONArray();
        sub_button.add(cbt);
        sub_button.add(vbt);
        JSONObject buttonOne = new JSONObject();
        buttonOne.put("name", "菜单");
        buttonOne.put("sub_button", sub_button);

        //把上面3个菜单组装
        JSONArray button = new JSONArray();
        button.add(vbt);
        button.add(buttonOne);
        button.add(cbt);

        JSONObject menujson = new JSONObject();
        menujson.put("button", button);
        System.out.println(menujson);

        //把自定义的菜单json串发送到微信服务器
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
                + "9_NhtIT44CJ9Q0aCfZBoQ_3DFDIHIJUj4pXIUHxaNJ-NlzYG65RKK4lQF4QoXl8BT_MNeTlBJTExx0l43mmUnsUEALkX61_tYJ3rb2P-LrPRvAeVj3fHYmMofWA47bUsU1-XDyZzphVcuX3cYGFRLhADAJVP";
        try {
            String rs = HttpUtils.sendPostBuffer(url, menujson.toString());
            System.out.println(rs);
        }catch (IOException e) {
            System.out.println("请求错误");
            e.printStackTrace();
        }
    }
}