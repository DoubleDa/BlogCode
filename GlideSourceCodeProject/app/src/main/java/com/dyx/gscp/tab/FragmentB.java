package com.dyx.gscp.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyx.gscp.R;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/21 下午3:20
 * alter person：dayongxin
 * alter time：2017/7/21 下午3:20
 * alter remark：
 */
public class FragmentB extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }
}
