package com.dyx.arja.service;

import com.dyx.arja.bean.TopicByIdBean;
import com.dyx.arja.constants.ApiConstants;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author：dayongxin
 * Function：
 */
public interface ApiService {

    @GET(ApiConstants.URL_CNODEJS_TOPIC)
    Observable<TopicByIdBean> getTopicById(@Path("id") String id);

    @GET(ApiConstants.URL_IMG)
    Observable<ResponseBody> downloadImgFromNet(@Path("imgUrl") String imgUrl);
}
