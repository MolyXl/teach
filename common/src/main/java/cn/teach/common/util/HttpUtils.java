package cn.teach.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUtils {
	
	/**
	 * post 请求
	 * @param url 请求地址
	 * @return
	 */
	public static String httpPost(String url) {
		return httpPost(url,null);
	}
	
	/**
	 * post 请求
	 * @param url 请求地址
	 * @param paramsMap post 参数
	 * @return
	 */
	public static String httpPost(String url,Map<String, Object>paramsMap) {
		return httpPost(url,null,paramsMap);
	}

    /**
     * get 请求
     * @param url 请求地址
     * @param paramsMap post 参数
     * @return
     */
    public static String httpGet(String url, Map<String, Object> paramsMap) {
        if(paramsMap==null||paramsMap.isEmpty()){
            return "";
        }
        // 设置请求的参数
        Iterator<Map.Entry<String, Object>> iterator = paramsMap.entrySet().iterator();
        List<String> list = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String para = next.getKey() + "=" + next.getValue();
            list.add(para);
        }
        HttpGet httpGet = new HttpGet(url + "?" + StringUtils.join(list,"&"));
        httpGet.addHeader("Content-Type", "application/json;charset=utf-8");
        return getResult(httpGet);
    }

	/**
	 * post 请求
	 * @param url 请求地址
	 * @param headMap head参数
	 * @param paramsMap post 参数
	 * @return
	 */
    public static String httpPost(String url, Map<String, String>headMap, Map<String, Object> paramsMap) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        //设置请求的HEAD 
        if(headMap!=null && !headMap.isEmpty()) {
        	for (Map.Entry<String, String> item : headMap.entrySet()) {
        		if(!StringHelper.IsNullOrEmpty(item.getKey())){
        			httpPost.addHeader(item.getKey(), item.getValue());
        		}
			}
        }
        // 设置请求的参数
        if(paramsMap!=null && !paramsMap.isEmpty()) {
        	JSONObject jsonObject = new JSONObject(paramsMap);
        	 StringEntity params = new StringEntity(jsonObject.toString(), Consts.UTF_8);
             httpPost.setEntity(params);
        }
        return getResult(httpPost);
    }

    public static String httpDelete(String url, Map<String, Object>headMap) {
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.addHeader("Content-Type", "application/json;charset=utf-8");
        //设置请求的HEAD
        if(headMap!=null && !headMap.isEmpty()) {
        	for (Map.Entry<String, Object> item : headMap.entrySet()) {
        		if(!StringHelper.IsNullOrEmpty(item.getKey())){
                    httpDelete.addHeader(item.getKey(), (String) item.getValue());
        		}
			}
        }
        return getResult(httpDelete);
    }

    public static String httpPut(String url,Map<String, String>headMap,Map<String, Object>paramsMap) {
        HttpPut httpPut = new HttpPut(url);
        httpPut.addHeader("Content-Type", "application/json;charset=utf-8");
        //设置请求的HEAD
        if(headMap!=null && !headMap.isEmpty()) {
        	for (Map.Entry<String, String> item : headMap.entrySet()) {
        		if(!StringHelper.IsNullOrEmpty(item.getKey())){
                    httpPut.addHeader(item.getKey(), item.getValue());
        		}
			}
        }
        // 设置请求的参数
        if(paramsMap!=null && !paramsMap.isEmpty()) {
            JSONObject jsonObject = new JSONObject(paramsMap);
            StringEntity params = new StringEntity(jsonObject.toString(), Consts.UTF_8);
            httpPut.setEntity(params);
        }
        return getResult(httpPut);
    }

    private static String getResult(HttpUriRequest request){
        String result = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try (CloseableHttpResponse response = httpclient.execute(request)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, "UTF-8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}