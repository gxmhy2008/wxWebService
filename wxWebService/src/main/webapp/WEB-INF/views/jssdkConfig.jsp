<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>JSSDK配置</title>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <%--<script src="${pageContext.request.contextPath}/WEB-INF/static/js/jquery2.1.4.min.js"></script>--%>
    <script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
    <h2>欢迎光临！</h2>
    <script type="text/javascript">
        function jssdk() {
            $.ajax({
                url:"http://testwechat1.free.ngrok.cc/wechatconfig/jssdk",
                type:"post",
                dataType:"json",
                contentType:"application/x-www-form-urlencoded;charset=utf-8",
                data:{
                    "url":location.href.split('#')[0]
                },
                success:function(data){
                    wx.config({
                        debug:true,
                        appId:data.data.appId,
                        timestamp:data.data.timestamp,
                        nonceStr:data.data.nonceStr,
                        signature:data.data.signature,
                        jsApiList:[
                            'checkJsApi','onMenuShareTimeline',
                            'onMenuShareAppMessage', 'onMenuShareQQ',
                            'onMenuShareWeibo', 'hideMenuItems',
                            'showMenuItems', 'hideAllNonBaseMenuItem',
                            'showAllNonBaseMenuItem', 'translateVoice',
                            'startRecord', 'stopRecord', 'onRecordEnd',
                            'playVoice', 'pauseVoice', 'stopVoice',
                            'uploadVoice', 'downloadVoice', 'chooseImage',
                            'previewImage', 'uploadImage', 'downloadImage',
                            'getNetworkType', 'openLocation', 'getLocation',
                            'hideOptionMenu', 'showOptionMenu', 'closeWindow',
                            'scanQRCode', 'chooseWXPay',
                            'openProductSpecificView', 'addCard', 'chooseCard',
                            'openCard'
                        ]
                    });
            }
            });
        }

        function isWeiXin5() {
            var ua = window.navigator.userAgent.toLowerCase();
            var reg = /MicroMessenger\/[5-9]/i;
            return reg.test(ua);
        }

        window.onload = function () {
            //     if (isWeiXin5() == false) {
            //           alert("您的微信版本低于 5.0，无法使用微信支付功能，请先升级！");
            //         }
            jssdk();
        }
    </script>
</body>
</html>
