package com.example.desk.ui.tiyu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desk.R;
import com.example.desk.adapter.TiyuAdapter;
import com.example.desk.entity.TiYu;
import com.example.desk.mvp.MVPBaseActivity;
import com.example.desk.util.ShareUtils;
import com.example.desk.util.StaticClass;
import com.example.desk.util.TLog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class TiyuActivity extends MVPBaseActivity<TiyuContract.View, TiyuPresenter> implements TiyuContract.View {
    @BindView(R.id.tv_tiyu_xuehao)
    TextView tvTiyuXuehao;
    @BindView(R.id.tv_tiyu_avail)
    TextView tvTiyuAvail;
    @BindView(R.id.tv_tiyu_total)
    TextView tvTiyuTotal;
    @BindView(R.id.rycler_tiyu)
    RecyclerView ryclerTiyu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiyu);
        ButterKnife.bind(this);
        String xuehao = ShareUtils.getString(getApplicationContext(), StaticClass.userid, "");
        Intent intent = getIntent();
        if (intent == null){
            TLog.error("intent 是 null");
        }else {
            String k = intent.getStringExtra("p");
            switch (k){
                case "1":
                    mPresenter.getTiyuData(xuehao);
                    break;
                case "2":
                    mPresenter.getTiyuData1(xuehao);
                    break;
                case "3":
                    mPresenter.getTiyuData2(xuehao);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void success(List<TiYu> tiYuList) {
        String xuehao = tiYuList.get(0).getXuehao();
        tvTiyuXuehao.setText(xuehao);
        int k = 0;
        for (TiYu tiYu : tiYuList){
            if (tiYu.getIsvalid().equals("有效")){
                k++;
            }
        }
        tvTiyuAvail.setText(k+"");
        tvTiyuTotal.setText(tiYuList.size()+"");
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager
                (1,StaggeredGridLayoutManager.VERTICAL);
        ryclerTiyu.setLayoutManager(layoutManager);
        TiyuAdapter adapter = new TiyuAdapter(TiyuActivity.this,tiYuList);
        ryclerTiyu.setAdapter(adapter);
    }

    @Override
    public void onfail() {
        Toast.makeText(TiyuActivity.this,"拉取不到数据！",Toast.LENGTH_SHORT).show();
    }
}
