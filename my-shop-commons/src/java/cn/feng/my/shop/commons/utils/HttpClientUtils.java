package cn.feng.my.shop.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @description: HttpClient工具类
 * @author:冯雨南
 * @createDate: 2020/5/16
 * @version:1.0.0
 */
public class HttpClientUtils {

    public static final String GET = "get";
    public static final String POST = "post";
    public static final String REQUSET_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";

    /**
     * @description: GET请求
     * @param: url 请求地址
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/5/16 17:58
     * @version:1.0.0
     **/
    public static String doGet(String url) {
        return creatRequest(url, GET, null);
    }

    /**
     * @description: GEt请求
     * @param: url 请求地址
     * @param: cookie Cookie
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/5/16 17:59
     * @version:1.0.0
     **/
    public static String doGet(String url, String cookie) {
        return creatRequest(url, GET, cookie);
    }


    /**
     * @description: POST请求
     * @param: url 请求地址
     * @param: params 请求参数（可选）
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/5/16 17:58
     * @version:1.0.0
     **/
    public static String doPost(String url, BasicNameValuePair... params) {
        return creatRequest(url, POST, null, params);
    }

    /**
     * @description: POST请求
     * @param: url 请求地址
     * @param: cookie Cookie
     * @param: params 请求参数（可选）
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/5/16 18:00
     * @version:1.0.0
     **/
    public static String doPost(String url, String cookie, BasicNameValuePair... params) {
        return creatRequest(url, POST, cookie, params);
    }


    /**
     * @description: 创建请求
     * @param: url 请求地址
     * @param: requestMethod 请求方式
     * @param: cookie cookie
     * @param: paprms 请求参数 POST请求用
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/5/16 16:33
     * @version:1.0.0
     **/
    private static String creatRequest(String url, String requestMethod, String cookie, BasicNameValuePair... params) {

        //创建HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //请求结果
        String result = null;

        //请求方式
        HttpGet httpGet = null;
        HttpPost httpPost = null;

        //响应
        CloseableHttpResponse httpResponse = null;
        try {
            //GET请求
            if (GET.equals(requestMethod)) {
                httpGet = new HttpGet(url);
                // 设置长连接
                httpGet.setHeader("Connection", REQUSET_HEADER_CONNECTION);
                // 设置代理（模拟浏览器版本）
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                httpGet.setHeader("Cookie", cookie);
                httpResponse = httpClient.execute(httpGet);
            }
            //POST请求
            else if (POST.equals(requestMethod)) {
                httpPost = new HttpPost(url);
                // 设置长连接
                httpPost.setHeader("Connection", REQUSET_HEADER_CONNECTION);
                // 设置代理（模拟浏览器版本）
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                httpPost.setHeader("Cookie", cookie);

                //有参数进来
                if (params != null && params.length > 0) {
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params), "UTF-8"));
                }

                httpResponse = httpClient.execute(httpPost);

            }
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }


}
