package com.slt.test;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class HttpClientTest {

    @Test
    public void httptest() throws Exception{
        CloseableHttpClient client = new DefaultHttpClient();

        HttpGet httpGet=new HttpGet("http://www.hoapi.com/index.php/Home/Api/check?str=%E6%93%8D%E4%BD%A0%E5%A6%88&token=1bfc6c8a90c45c29ff4b8a3ec0d411ee");
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String json=getString(entity);

        change(json);

        HttpPost httpPost=new HttpPost("http://www.sdfeasdfagggggg.com");
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("text", "操"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httpPost.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse closeableHttpResponse =client.execute(httpPost);
        entity=closeableHttpResponse.getEntity();
        json=getString(entity);

        change(json);

    }

    private String getString(HttpEntity entity) throws Exception{
        String json="";
        if(entity!=null){
            InputStream inputStream=entity.getContent();
            json=IOUtils.toString(inputStream);
        }
        return json;

    }

    private void change(String json)throws Exception{
    }
}
