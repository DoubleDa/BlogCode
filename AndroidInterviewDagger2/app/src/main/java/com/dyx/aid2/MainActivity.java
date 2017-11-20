package com.dyx.aid2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dyx.aid2.bean.Person;
import com.dyx.aid2.bean.Watch;
import com.dyx.aid2.component.DaggerActivityComponent;
import com.google.gson.Gson;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "***MainActivity***";
    @Inject
    Watch watch;
    @Inject
    Gson gson;
    private String jsonData = "{'name':'dayongxin','age':18}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.create().inject(this);
        /**
         *
         */
        watch.work();
        /**
         *
         */
        Person person = gson.fromJson(jsonData, Person.class);
        Log.i(TAG, person.getName());
        /**
         *
         */
    }
}
