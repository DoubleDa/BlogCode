package com.dyx.arja.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyx.arja.R;

import rx.Observable;

/**
 * Author：dayongxin
 * Function：
 */
public class RxLifecycleFragment extends Fragment {
    private Observable mObservable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rx_lifecycle, container, false);
        return view;
    }
}
