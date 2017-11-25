package com.dyx.aiw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dyx.aiw.simple.SimpleWebviewAct;

public class MainActivity extends AppCompatActivity {
    private static final String WEBSITE_URL = "http://www.dayongxin.com";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1、简单跳转
//                startActivity(new Intent(MainActivity.this, SimpleWebviewAct.class));
                /**
                 * 多进程之间传输数据
                 */
                //2、通过Bundle
                multiProcessCommuByBundle();
                /**
                 * 3、通过AIDL
                 */
                multiProcessCommuByAIDL();
                /**
                 * 4、通过ContentProvider
                 */
                multiProcessCommuByContentProvider();
                /**
                 * 5、通过Socket
                 */
                multiProcessCommuBySocket();
                /**
                 * 6、通过Binder
                 */
                multiProcessCommuByBinder();
                /**
                 * 7、通过共享文件
                 */
                multiProcessCommuByShareFile();
                /**
                 * 8、通过
                 */
                multiProcessCommuByMessenger();
            }
        });
    }

    private void multiProcessCommuByMessenger() {

    }

    private void multiProcessCommuByShareFile() {

    }

    private void multiProcessCommuByBinder() {

    }

    private void multiProcessCommuBySocket() {

    }

    private void multiProcessCommuByContentProvider() {

    }

    private void multiProcessCommuByAIDL() {

    }

    private void multiProcessCommuByBundle() {
        Intent intent = new Intent(this, SimpleWebviewAct.class);
        Bundle bundle = new Bundle();
        bundle.putString(SimpleWebviewAct.BUNDLE_KEY, WEBSITE_URL);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
