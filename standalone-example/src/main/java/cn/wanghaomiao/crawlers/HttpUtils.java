package cn.wanghaomiao.crawlers;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static final MediaType FORM = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    public static final MediaType PB = MediaType.parse("application/x-protobuf");


    private String snatchSource;
    private String issue;
    private boolean sendPageHandel;

    /**
     * 默认的编码格式
     */
    private static final String CHARSET = "UTF-8";

    /**
     * 默认的超时时间 60 S
     */
    private static final int TIMEOUT = 60000;

    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)//单位是秒
            .readTimeout(60, TimeUnit.SECONDS)
            .build();


    public static String get(String url) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(url).get();
        Response response = client.newCall(builder.build()).execute();
        return response.body().string();
    }


}
