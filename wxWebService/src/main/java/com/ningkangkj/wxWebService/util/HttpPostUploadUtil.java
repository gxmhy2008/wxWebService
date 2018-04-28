package com.ningkangkj.wxWebService.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description 多媒体上传
 * @Author luckypt
 * @Date 2018/04/28
 */
public class HttpPostUploadUtil {
    public String urlStr;

    public HttpPostUploadUtil() {
        urlStr = GlobalConstants.getInterfaceUrl("mediaUrl")
                + GlobalConstants.getInterfaceUrl("access_token")
                + "&type=image";
    }

    /**
     * 上传图片
     * @param textMap
     * @param fileMap
     * @return
     */
    public String formUpload(Map<String, String> textMap, Map<String, String> fileMap) {
        String res = "";
        HttpURLConnection conn = null;
        //boundary 是request头和上传文件内容的分隔符
        String BOUNDARY = "-----------------------------------------------123456789";
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-TYpe", "multipart/form-data;boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            //文本信息
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator<?> iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry)iter.next();
                    String inputName = (String)entry.getKey();
                    String inputValue = (String)entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Dispostion:form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
