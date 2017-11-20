package com.dyx.ais.service3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.dyx.ais.services3.IPerson;

/**
 * Author：dayongxin
 * Function：
 */
public class AIDLService extends Service {
    private IBinder binder = new PersonQueryBinder();
    private String[] strings = {"凯恩", "阿里", "埃里克森", "孙兴民", "罗斯", "洛丽"};

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private class PersonQueryBinder extends IPerson.Stub {
        @Override
        public String queryPerson(int num) throws RemoteException {
            return query(num);
        }
    }

    private String query(int num) {
        if (num >= 0 && num < 6) {
            return strings[num];
        }
        return null;
    }
}
