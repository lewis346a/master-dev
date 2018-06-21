package com.beidou.contact;


import com.beidou.base.BasePresenter;
import com.beidou.base.BaseView;
import com.beidou.domain.AreaModel;
import com.beidou.domain.CountryModel;
import com.beidou.domain.UserBean;

public interface LoginContact {
   interface LoginView extends BaseView {
        /**
         * 设置数据
         *
         * @param
         */
         void setData(UserBean userModel);
       void setAreaData(AreaModel userModel);
       void setCountryData(CountryModel userModel);
    }

     interface Loginpresenter extends BasePresenter {
        /**
         * 获取数据
         */
        void login(String mobie, String password, String accessKey, String sign);
         void getAreaData(String accessKey, String sign);
         void getCountryData(String area,String accessKey, String sign);

    }
}