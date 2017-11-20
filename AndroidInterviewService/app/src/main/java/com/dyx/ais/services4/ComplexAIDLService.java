package com.dyx.ais.services4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Author：dayongxin
 * Function：
 */
public class ComplexAIDLService extends Service {
    private static final String TAG = "***ComplexAIDLService***";
    private SalaryBinder mSalaryBinder;
    private static Map<User, Salary> map = new HashMap<>();

    static {
        map.put(new User(1, "kaien"), new Salary("前锋", 10));
        map.put(new User(2, "luoli"), new Salary("守门员", 10));
        map.put(new User(3, "ali"), new Salary("中场", 5));
        map.put(new User(4, "alks"), new Salary("中场", 6));
        map.put(new User(5, "sxm"), new Salary("前锋", 2));
        map.put(new User(6, "dell"), new Salary("中卫", 5));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mSalaryBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSalaryBinder = new SalaryBinder();
    }

    public class SalaryBinder extends ISalary.Stub {

        @Override
        public Salary getMsg(User user) throws RemoteException {
            return map.get(user);
        }
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }
}
