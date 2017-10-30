package com.dyx.arp.service;

import com.dyx.arp.model.NameInfo;
import com.dyx.arp.model.Person;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Author：dayongxin
 * Function：
 */
public interface ApiService {
    /**
     * @param name
     * @return
     * @function 动态配置URL地址
     */
    @GET("person/{name}")
    Call<Person> getPerson(@Path("name") String name);

    /**
     * @param id
     * @return
     * @function 动态指定查询条件
     */
    @GET("person")
    Call<Person> getPersonbyId(@Query("id") String id);

    /**
     * @param options
     * @return
     * @function 动态指定查询条件组
     */
    @GET("persons")
    Call<Person> getPersons(@QueryMap Map<String, String> options);

    /**
     * @param name
     * @return
     * @function 传输数据类型为键值对
     */
    @FormUrlEncoded
    @POST("person")
    Call<Person> postPerson(@Field("name") String name);

    /**
     * @param info
     * @return
     * @function 传输数据类型JSON字符串
     */
    @POST("person")
    Call<Person> postPerson(@Body NameInfo info);

    /**
     * @param img
     * @param description
     * @return
     * @function 单个文件上传
     */
    @Multipart
    @POST("person/img")
    Call<Person> postPersonImg(@Part MultipartBody.Part img, @Part("description") RequestBody description);


    /**
     * @param imgs
     * @param description
     * @return
     * @function 多个文件上传
     */
    @Multipart
    @POST("person/imgs")
    Call<Person> postPersonFiles(@QueryMap Map<String, RequestBody> imgs, @Part("description") RequestBody description);

    /**
     * @return
     * @function 静态添加消息报头
     */
    @GET("person/id")
    @Headers("Accept-Encoding:application/json")
    Call<ResponseBody> getPersonId();

    /**
     * @return
     * @function 静态添加多个消息报头
     */
    @GET("person/id")
    @Headers({
            "Accept-Encoding:application/json",
            "User-Agent:MyRetrofit"
    })
    Call<ResponseBody> getPersonIds();

    /**
     * @param location
     * @return
     * @function 动态添加消息报头
     */
    @GET("person/id")
    Call<ResponseBody> getPersonType(@Header("Location") String location);
}
