package com.beidou.ui.act;

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
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HydMxAct extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private BaseAdapter<String> adapter;
    private ArrayList list;

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("明细");
        list = new ArrayList();
        list.add("asdiajs");
        list.add("sss");
        list.add("dasd");


        recycler.setLayoutManager(new LinearLayoutManager(context));

        adapter = new BaseAdapter<>(R.layout.item_hyd, list, new BaseAdapter.ConVert<String>() {
            @Override
            public void convert(BaseViewHolder helper, String s) {

            }
        });



        // adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN );
        recycler.setAdapter(adapter);
    }

    @Override
    protected int initLayout() {
        return R.layout.act_hydmx;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }



    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
