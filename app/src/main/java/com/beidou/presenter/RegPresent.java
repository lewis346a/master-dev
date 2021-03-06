package com.beidou.presenter;

import com.beidou.base.BasePresenterImpl;
import com.beidou.contact.RegContact;
import com.beidou.domain.ResultBean;
import com.beidou.domain.RegBean;
import com.beidou.http.RetrofitFactory;


import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class RegPresent extends BasePresenterImpl<RegContact.RegView> implements RegContact.Regpresenter{
    public RegPresent(RegContact.RegView view) {
        super(view);
    }

    @Override
    public void register(String mobie, String password, String code, String accessKey, String sign) {
        Map<String,String> map=new HashMap<>();
        map.put("mobie",mobie);
        map.put("password",password);
        map.put("code",code);
        map.put("accessKey",accessKey);
        map.put("sign",sign);
        RetrofitFactory.getInstance()
                .register(map)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        addDisposable(disposable);//请求加入管理
                        view.showLoadingDialog("");

                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegBean>() {
                    @Override
                    public void accept(@NonNull RegBean userModel) throws Exception {
                        view.dismissLoadingDialog();
                        view.setData(userModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
//                        ExceptionHelper.handleException(throwable);

                    }
                });
    }

    @Override
    public void getSmsCode(String mobie, String accessKey, String sign) {
        Map<String,String> map=new HashMap<>();
        map.put("mobie",mobie);
        map.put("accessKey",accessKey);
        map.put("sign",sign);
                RetrofitFactory.getInstance()
                .getCode(map)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        addDisposable(disposable);//请求加入管理
                        view.showLoadingDialog("");

                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResultBean>() {
                    @Override
                    public void accept(@NonNull ResultBean userModel) throws Exception {
                        view.dismissLoadingDialog();
                        view.setYzm(userModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
//                        ExceptionHelper.handleException(throwable);

                    }
                });
    }


//
//    @Override
//    public void register(String username, String password, String captcha, String cap) {
//        Map<String,String> map=new HashMap<>();
//        map.put("username",username);
//        map.put("password",password);
//        map.put("captcha",captcha);
//        map.put("cap",cap);
//
//        RetrofitFactory.getInstance()
//                .register(map)//测试接口
//                .subscribeOn(Schedulers.io())
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(@NonNull Disposable disposable) throws Exception {
//                        addDisposable(disposable);//请求加入管理
//                        view.showLoadingDialog("");
//
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<ResultBean<UserModel>>() {
//                    @Override
//                    public void accept(@NonNull ResultBean<UserModel> userModel) throws Exception {
//                        view.dismissLoadingDialog();
//                        view.setData(userModel);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        view.dismissLoadingDialog();
////                        ExceptionHelper.handleException(throwable);
//
//                    }
//                });
//    }


}
