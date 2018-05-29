package com.ningkangkj.wxWebService.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;



/**
 * @Description http请求工具类
 * @Author luckypt
 * @Date 2018/04/27
 */
public class HttpUtils {

    /**
     * @Description http get请求共用方法
     * @param reqUrl
     * @param params
     * @return
     */
    public static String sendGet(String reqUrl, Map<String, String> params) throws IOException {
        InputStream inputStream = null;
        HttpGet request = new HttpGet();

        try{
            String url = buildUrl(reqUrl, params);
            HttpClient client = HttpClientBuilder.create().build();
            //设置http协议请求头
            request.setHeader("Accept-Encoding", "gzip");
            request.setURI(new URI(url));
            //执行http get请求,得到服务器的响应
            HttpResponse response = client.execute(request);

            //解析response 响应体
            inputStream = response.getEntity().getContent();
            String result = getJsonStringFromGZIP(inputStream);
            return result;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
            request.releaseConnection();
        }

        return null;
    }

    /**
     * @Description http post 共用方法
     * @param reqUrl
     * @param params
     * @return
     */
    public static String sendPost(String reqUrl, Map<String, String> params) throws Exception {
        try {
            Set<String> set = params.keySet();
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (String key : set) {
                list.add(new BasicNameValuePair(key, params.get(key)));
            }
            if (list.size() > 0) {
                try {
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost requst = new HttpPost(reqUrl);

                    requst.setHeader("Accept-Encoding", "gzip");
                    requst.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));

                    HttpResponse response = client.execute(requst);
                    InputStream inputStream = response.getEntity().getContent();
                    try {
                        String result = getJsonStringFromGZIP(inputStream);
                        return result;
                    } finally {
                        inputStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception("网络连接失败,请连接网络后再试");
                }
            }else{
                throw new Exception("参数不全,请稍后重试");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("发送未知异常");
        }
    }


    /**
     * @Description http post 请求json 数据
     * @param urls
     * @param params
     * @return
     */
    public static String sendPostJson(String urls, String params) throws IOException {
        HttpPost request = new HttpPost(urls);
        StringEntity se = new StringEntity(params, HTTP.UTF_8);
        request.setEntity(se);

        //发送请求
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        //得到应答的字符串,这也是一个JSON格式保存的数据
        String retSrc = EntityUtils.toString(httpResponse.getEntity());
        request.releaseConnection();
        return retSrc;
    }

    /**
     * @Description http 请求发送xml内容
     * @param urlStr
     * @param xmlInfo 具体字符串
     * @return
     */
    public static String sendXmlPost(String urlStr, String xmlInfo) {
        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Pragma:", "no-cache");
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "text/xml");
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(new String(xmlInfo.getBytes("utf-8")));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String lines = "";
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                lines += line;
            }
            return lines;  //返回请求的xml结果
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "fail";
    }

    private static String getJsonStringFromGZIP(InputStream is) {
        String jsonString = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(is);
            //取前两个字节
            bis.mark(2);
            byte[] header = new byte[2];
            int result = bis.read(header);
            //reset 输入流的开始位置
            bis.reset();
            //判断是否是GZIP格式
            int headerData = getShort(header);
            //Gzip流的前两个字节是0x1f8b
            if (result != -1 && headerData == 0x1f8b) {
                is = new GZIPInputStream(bis);
            }else{
                is =bis;
            }

            InputStreamReader reader = new InputStreamReader(is,"utf-8");
            char[] data = new char[100];
            int readSize;
            StringBuffer sb = new StringBuffer();
            while ((readSize = reader.read(data)) > 0) {
                sb.append(data, 0, readSize);
            }
            jsonString = sb.toString();
            bis.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    /**
     * @Description 获取short型整数
     * @param data
     * @return
     */
    private static int getShort(byte[] data){
        return (data[0]<<8) | data[1] & 0XFF;
    }

    /**
     * @Description 构建get方式的url
     * @param reqUrl
     * @param params
     * @return
     */
    public static String buildUrl(String reqUrl, Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        if (params != null) {
            Set<String> set = params.keySet();
            for (String key : set) {
                query.append(String.format("%s=%s&", key, params.get(key)));
            }
            return reqUrl+ "?" + query.toString();
        }else{
            return reqUrl;
        }
    }

}
