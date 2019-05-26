package com.example.desk.ui.second;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.desk.R;
import com.example.desk.mvp.MVPBaseFragment;
import com.example.desk.ui.tiyu.TiyuActivity;
import com.example.desk.util.TLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SecondFragment extends MVPBaseFragment<SecondContract.View, SecondPresenter> implements SecondContract.View {


    @BindView(R.id.iv_tiyu1)
    ImageView ivTiyu1;
    @BindView(R.id.iv_tiyu2)
    ImageView ivTiyu2;
    @BindView(R.id.iv_tiyu3)
    ImageView ivTiyu3;
    Unbinder unbinder;


    public SecondFragment() {
    }

    public static SecondFragment newInstance() {
        SecondFragment secondFragment = new SecondFragment();
        return secondFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onPause() {
        TLog.error("onPause");
        super.onPause();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        TLog.error("onDestroyView");
        super.onDestroyView();
        unbinder.unbind();

    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_tiyu1, R.id.iv_tiyu2, R.id.iv_tiyu3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_tiyu1:
                Intent intent = new Intent(getActivity(),TiyuActivity.class);
                intent.putExtra("p","1");
                getActivity().startActivity(intent);
                break;
            case R.id.iv_tiyu2:
                Intent intent1 = new Intent(getActivity(),TiyuActivity.class);
                intent1.putExtra("p","2");
                getActivity().startActivity(intent1);
                break;
            case R.id.iv_tiyu3:
                Intent intent2 = new Intent(getActivity(),TiyuActivity.class);
                intent2.putExtra("p","3");
                getActivity().startActivity(intent2);
                break;
        }
    }
}
