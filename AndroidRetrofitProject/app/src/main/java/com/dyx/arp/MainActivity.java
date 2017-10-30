package com.dyx.arp;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.dyx.arp.constants.ApiConstants;
import com.dyx.arp.model.NameInfo;
import com.dyx.arp.model.Person;
import com.dyx.arp.service.ApiService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        /**
         * 1、动态配置URL地址
         */
        dynamicConfigurationUrl();
        /**
         * 2、动态指定查询条件
         */
        dynamicallySpecifiedQueryUrl();
        /**
         * 3、动态指定查询条件组
         */
        dynamicConfigurationUrls();
        /**
         * 4、传输数据类型为键值对
         */
        transportDataTypeKeyValuePairUrl();
        /**
         * 5、传输数据类型JSON字符串
         */
        transmitsDataTypeJSONStringUrl();
        /**
         * 6、单个文件上传
         */
        singleFileUploadUrl();
        /**
         * 7、多个文件上传
         */
        multipleFileUploadUrl();
        /**
         * 8、静态添加消息报头
         */
        staticAddMessageHeaderUrl();
        /**
         * 9、静态添加多个消息报头
         */
        staticAddMessagesHeaderUrl();
        /**
         * 10、动态添加消息报头
         */
        dynamicAddMessageHeaderUrl();
    }

    private void dynamicAddMessageHeaderUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.getPersonType("shanghai");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //The request failed
            }
        });
    }

    private void staticAddMessagesHeaderUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.getPersonIds();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //The request failed
            }
        });
    }

    private void staticAddMessageHeaderUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.getPersonId();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //The request failed
            }
        });
    }

    private void multipleFileUploadUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Person> call = apiService.postPersonFiles(getDatas(), RequestBody.create(null, "dayongxin"));
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                //The request failed
            }
        });
    }

    private Map<String, RequestBody> getDatas() {
        Map<String, RequestBody> map = new HashMap<>();
        File file1 = new File(Environment.getExternalStorageDirectory(), "dayongxin.png");
        RequestBody body1 = RequestBody.create(MediaType.parse("image/png"), file1);
        File file2 = new File(Environment.getExternalStorageDirectory(), "dayongxin.png");
        RequestBody body2 = RequestBody.create(MediaType.parse("image/png"), file2);
        File file3 = new File(Environment.getExternalStorageDirectory(), "dayongxin.png");
        RequestBody body3 = RequestBody.create(MediaType.parse("image/png"), file3);
        map.put("key1", body1);
        map.put("key2", body1);
        map.put("key3", body1);
        return map;
    }

    private void singleFileUploadUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        File file = new File(Environment.getExternalStorageDirectory(), "dayongxin.png");
        RequestBody body = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("imgs", "dayongxin.png", body);
        Call<Person> call = apiService.postPersonImg(part, RequestBody.create(null, "dayongxin"));
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                //The request failed
            }
        });
    }

    private void transmitsDataTypeJSONStringUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Person> call = apiService.postPerson(new NameInfo());
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                //The request failed
            }
        });
    }

    private void transportDataTypeKeyValuePairUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Person> call = apiService.postPerson("dayongxin");
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                //The request failed
            }
        });
    }

    private void dynamicConfigurationUrls() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Person> call = apiService.getPersons(getQueryMap());
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                //The request failed
            }
        });
    }

    private Map<String, String> getQueryMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        return map;
    }

    private void dynamicallySpecifiedQueryUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Person> call = apiService.getPersonbyId("192.168.1.2");
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                //The request failed
            }
        });
    }

    private void dynamicConfigurationUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Person> call = apiService.getPerson("dayongxin");
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                //The request is successful
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                //The request failed
            }
        });
    }
}
