package com.dyx.aac.api;

import android.arch.lifecycle.LiveData;

import com.dyx.aac.vo.Book;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;

/**
 * project name：AndroidArtiCom
 * class describe：
 * create person：dayongxin
 * create time：2017/6/22 下午4:41
 * alter person：dayongxin
 * alter time：2017/6/22 下午4:41
 * alter remark：
 */
public interface ServerService {
    /**
     * 获取Book列表
     */
    @GET("api/books")
    LiveData<ApiResponse<List<Book>>> getBooks();

    /**
     * 获取Book信息
     */
    @GET("api/books/{id}")
    LiveData<ApiResponse<Book>> getBook();

    /**
     * 添加Book信息
     */
    @POST("api/books")
    LiveData<ApiResponse<Book>> postBook(@Body Book book);

    /**
     * 更新Book信息
     */
    @PUT("api/books/{id}")
    LiveData<ApiResponse<Book>> putBook(String id, @Body Book book);

    /**
     * 删除Book信息
     */
    @DELETE("api/books/{id}")
    LiveData<ApiResponse<Book>> deleteBook(String id);
}
