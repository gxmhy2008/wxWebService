<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>基础接口</title>
    <meta name="viewport" content="width=device-width"/>
</head>
<body>
    <%--引入微信jssdk接口文件--%>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    <script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
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
                    /*配置微信接口*/
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
                    //微信jssdk配置成功后执行wx.ready
                    wx.ready(function () {
                        //1.判断当前版本是否支持指定的js接口,支持批量判断,只需要将需要判断的接口放入到jsApiList中即可
                        wx.checkJsApi({
                            jsApiList:['getNetworkType','previewImage'],
                            success:function(res){
                                //alert(JSON.stringify(res));
                            }
                        });
                        //2.分享接口
                        //2.1监听'分享给朋友',按钮点击、自定义分享内容及分享结果接口
                        wx.onMenuShareAppMessage({
                            title:'程序员成长日记',
                            desc:'关注程序员的学习成长',
                            link:"http://www.ningkangkj.com:18080/",
                            imgUrl:"http://app.ah122.cn/app3_0-cms/upload/image/20180425/20180425165617_58.jpg",
                            trigger:function (res) {
                                //不要尝试在trigger中使用ajax异步请求修改本次分享的内容,因为客户端分享操作是一个同步操作
                                //这时候使用ajax的回包还没有返回
                                alert('用户点击发送给朋友');
                            },
                            success:function (res) {
                                alert('已分享');
                            },
                            cancel:function (res) {
                                alert("已取消");
                            },
                            fail:function (res) {
                                alert(JSON.stringify(res));
                            }
                        });

                        //3、设备信息接口
                        //3.1获取当前网络状态
                        wx.getNetworkType({
                            success:function(res) {
                                //alert(res.networkType);
                                var networkType = res.networkType; //返回网络类型 2g,3g,4g,wifi
                                if(networkType == '3g'){
                                    alert("您好,您的网络状态是3g网络,这里播放视频文件会产生大流量")
                                }
                            },
                            fail:function(res){
                                alert(JSON.stringify(res));
                            }
                        });

                        //4.地理位置接口
                        //4.1查看地理位置
                        // wx.openLocation({
                        //     latitude:23.09994,
                        //     longitude:113.324520,
                        //     name:'TIT创意园',
                        //     address:'广州市海珠区新港中路',
                        //     scale:14,
                        //     infoUrl:'http://weixin.qq.com'
                        // });
                        //4.2获取当前地理位置
                        // wx.getLocation({
                        //     success:function (res) {
                        //         //alert(JSON.stringify(res));
                        //     },
                        //     cancel:function(res) {
                        //         alert('用户拒绝授权获取地理位置');
                        //     }
                        // });
                        //5.界面操作接口,这里说的界面操作其实就是在微信浏览器中操作和改名的
                        //右上角的‘三个点’,对这里隐藏的菜单进行操作和关闭微信浏览器
                        //5.1隐藏右上角菜单
                        //wx.hideOptionMenu();
                        //5.2显示右上角菜单
                        //wx.showOptionMenu();
                        //5.3批量隐藏菜单项
                        // wx.hideMenuItems({
                        //     menuList:[
                        //         'menuItem:readMode', //阅读模式
                        //         'menuItem:share:timeline', //分享到朋友圈
                        //         'menuItem:copyUrl'  //复制链接
                        //     ],
                        //     success:function(res) {
                        //         alert('hide some menu');
                        //     },
                        //     fail:function (res) {
                        //         alert(JSON.stringify(res));
                        //     }
                        // });
                        //5.4 批量显示菜单项
                        // wx.showMenuItems({
                        //     menuList: [
                        //         'menuItem:readMode', // 阅读模式
                        //         'menuItem:share:timeline', // 分享到朋友圈
                        //         'menuItem:copyUrl' // 复制链接
                        //     ],
                        //     success: function (res) {
                        //         alert('已显示“阅读模式”，“分享到朋友圈”，“复制链接”等按钮');
                        //     },
                        //     fail: function (res) {
                        //         alert(JSON.stringify(res));
                        //     }
                        // });
                        //5.5隐藏所有非基本菜单项
                        // wx.hideAllNonBaseMenuItem({
                        //    success:function () {
                        //        alert("已隐藏所有非基本菜单项");
                        //    }
                        // });
                        // 5.6 显示所有被隐藏的非基本菜单项
                        // wx.showAllNonBaseMenuItem({
                        //     success: function () {
                        //         alert('已显示所有非基本菜单项');
                        //     }
                        // });

                        //5.7关闭当前窗口
                        //wx.closeWindow();
                        //6 微信扫一扫接口
                        wx.scanQRCode({
                            needResult:0, //默认为0,扫描结果由微信处理,1 则直接返回扫描结果
                            scanType:["qrCode","barCode"], //可以知道扫描二维码还是一维码，默认二者都有
                            success:function(res) {
                                var result = res.resultStr;
                                alert(result);
                            }
                        });
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
