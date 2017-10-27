package com.dyx.arja.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dyx.arja.R;
import com.dyx.arja.constants.ApiConstants;
import com.dyx.arja.rxbus.MyEvent;
import com.dyx.arja.rxbus.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Author：dayongxin
 * Function：
 */
public class RxBusFragment extends Fragment {
    private Unbinder mUnbinder;
    @BindView(R.id.btn_my_rxbus)
    Button btnMyRxbus;
    @BindView(R.id.btn_library_rxbus)
    Button btnLibraryRxbus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rx_bus, container, false);
        mUnbinder = ButterKnife.bind(getActivity());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btn_my_rxbus, R.id.btn_library_rxbus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_my_rxbus:
                RxBus.getInstance().post(new MyEvent("使用自实现RxBus发生消息！"));
                break;
            case R.id.btn_library_rxbus:
                com.hwangjr.rxbus.RxBus.get().post(ApiConstants.RXBUS, new MyEvent("使用RxBus库发生消息！"));
                break;
        }
    }
}
