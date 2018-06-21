package com.beidou.ui.act;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.beidou.R;
import com.beidou.base.BaseActivity;
import com.beidou.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HYDAct extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.rl)
    RelativeLayout rl;

    @Override
    protected void initView(Bundle savedInstanceState) {
            ivBack.setVisibility(View.VISIBLE);
            tvRight.setText("明细");
            tvRight.setVisibility(View.VISIBLE);
            rl.setVisibility(View.VISIBLE);
            tvTitle.setText("活跃度");
    }

    @Override
    protected int initLayout() {
        return R.layout.act_hyd;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }



    @OnClick({R.id.iv_back,R.id.tv_right, R.id.ll_jhhy, R.id.ll_gw, R.id.ll_sqft, R.id.ll_cwsh, R.id.ll_cjbgx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_right:
                jumpToClazz(HydMxAct.class);
                break;
                case R.id.iv_back:
                    finish();
                break;
            case R.id.ll_jhhy:
                break;
            case R.id.ll_gw:
                break;
            case R.id.ll_sqft:
                break;
            case R.id.ll_cwsh:
                break;
            case R.id.ll_cjbgx:
                break;
        }
    }
}
