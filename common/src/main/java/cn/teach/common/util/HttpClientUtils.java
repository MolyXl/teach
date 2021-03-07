package cn.teach.common.util;

import com.alibaba.fastjson.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.net.URI;
import java.util.*;

/**
 * @author HeLiu
 * @Description 请求工具类（HttpClient）
 * @date 2018/11/16 10:09
 */
public class HttpClientUtils {

    /**
     * @Description 发送get请求（带参数）
     * @author HeLiu
     * @date 2018/11/16 11:02
     */
    public static String doGet(String url, Map<String, Object> params) {
        if (!StringUtils.hasText(url)) {
            return "";
        }
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for (String key : params.keySet()) {
                    pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, "UTF-8"));
            }
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            // 判断响应实体是否为空
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeableHttpClient.close();
            } catch (IOException e) {
            }
        }
        return null;
    }

    /**
     * @Description 发送post请求（带参数）
     * @author HeLiu
     * @date 2018/11/16 11:02
     */
    public static Map doPost(String url, Map<String, Object> param) {
        try {
            Client client = Client.create();
            URI u = new URI(url);
            WebResource resource = client.resource(u);
            MultivaluedMap<String, String> params = new MultivaluedMapImpl();

            Iterator i$ = param.entrySet().iterator();
            while (i$.hasNext()) {
                Map.Entry<String, List<String>> e = (Map.Entry) i$.next();
                params.add(e.getKey(), String.valueOf(e.getValue()));
            }

            String result = resource.type(MediaType.APPLICATION_FORM_URLENCODED).post(String.class, params);

            JSONObject jasonObject = JSONObject.parseObject(result);
            return (Map) jasonObject;

        } catch (Exception e) {
        }
        return null;
    }

}

