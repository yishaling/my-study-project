package com.mashibing.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;

import java.util.Map;
import java.util.Set;
public class HttpClientUtil {
    public static JSONObject sendGet(String url, Map headers) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //请求头
        if (headers != null && headers.size() > 0) {
            Set keySet = headers.keySet();
            for (Object key : keySet) {
                httpGet.addHeader(new BasicHeader((String) key, (String) headers.get(key)));
            }
        }
        HttpResponse response = httpClient.execute(httpGet);
        return JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
    }

}
