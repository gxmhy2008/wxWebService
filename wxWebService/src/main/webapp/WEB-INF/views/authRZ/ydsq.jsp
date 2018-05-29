<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>诱导授权</title>
    <meta name="viewport" content="width=device-width"/>
</head>
<body>
    <div>
        <%--静默授权--%>
        <%--<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx74247184de3d1a8f&redirect_uri=http%3A%2F%2F2pgsr8.natappfree.cc%2Fauthrz%2FopenIdGet&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect">
            授权</a>--%>
            <%--手动授权--%>
        <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx74247184de3d1a8f&redirect_uri=http%3A%2F%2F2pgsr8.natappfree.cc%2Fauthrz%2FopenIdGet&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect">
            授权</a>
    </div>
    <%--引入微信jssdk接口文件--%>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    <script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">

    </script>
</body>
</html>
