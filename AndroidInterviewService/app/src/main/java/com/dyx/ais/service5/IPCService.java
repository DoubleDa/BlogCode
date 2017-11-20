package com.dyx.ais.service5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Author：dayongxin
 * Function：
 */
public class IPCService extends Service {
    private static final String DESCRIPTOR = "IPCService";
    private String[] strings = {"凯恩", "阿里", "埃里克森", "孙兴民", "罗斯", "洛丽"};
    private MyBinder binder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private class MyBinder extends Binder {
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 0x001: {
                    data.enforceInterface(DESCRIPTOR);
                    int num = data.readInt();
                    reply.writeNoException();
                    reply.writeString(strings[num]);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    }
}
