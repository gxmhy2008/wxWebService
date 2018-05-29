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
        vbt.setName("微信授权");
        vbt.setType("view");
        vbt.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx74247184de3d1a8f&redirect_uri=http%3a%2f%2f2pgsr8.natappfree.cc%2fopenid&response_type=code&scope=snsapi_base&state=http://2pgsr8.natappfree.cc/wx/h5/grzx#wechat_redirect");

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
        //每次生成公众号菜单时需要修改access_token
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
                + "10_H77CyRlVjffBtu2ckIm-TdbG0BAGpJfdvRgR9massWJNRZVYvL7PBkj7YricUUheQ2W2V9Z_MKH8VRBuXtmO9IYq95U_EH4f2EGsJS96bgz85aN_yjLLi_CvainboLfmYV47_W8XmNdipjDkGRHbAFAJUK";
        try {
            String rs = HttpUtils.sendPostJson(url, menujson.toString());
            System.out.println(rs);
        }catch (IOException e) {
            System.out.println("请求错误");
            e.printStackTrace();
        }
    }
}
