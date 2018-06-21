package com.beidou.ui.act;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.beidou.R;
import com.beidou.adapter.BaseAdapter;
import com.beidou.base.BaseActivity;
import com.beidou.base.BasePresenter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LunTanAct extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<String> list;
    private BaseAdapter<String> adapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("论坛");
        list = new ArrayList();
        list.add("asdiajs");
        list.add("sss");
        list.add("dasd");

        recycler.setLayoutManager(new LinearLayoutManager(context));

        adapter = new BaseAdapter<>(R.layout.item_lt, list, new BaseAdapter.ConVert<String>() {
            @Override
            public void convert(BaseViewHolder helper, String s) {

            }
        });



        // adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN );
        recycler.setAdapter(adapter);

    }

    @Override
    protected int initLayout() {
        return R.layout.act_lt;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }



    @OnClick({R.id.iv_back, R.id.tv_sou, R.id.ll_bj})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sou:
                break;
            case R.id.ll_bj:
                break;
        }
    }
}
