package com.example.desk.ui.tiyu;

import com.example.desk.api.APIWrapper;
import com.example.desk.entity.TiYu;
import com.example.desk.mvp.BasePresenterImpl;
import com.example.desk.util.TLog;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class TiyuPresenter extends BasePresenterImpl<TiyuContract.View> implements TiyuContract.Presenter{
    private List<TiYu> tiYuList = new ArrayList<>();
    @Override
    public void getTiyuData(String xuehao) {
       tiYuList.clear();
        APIWrapper.getInstance().getZaoCao(xuehao)
              .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<TiYu>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<TiYu> tiYus) {
                        tiYuList = tiYus;
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.onfail();
                    }

                    @Override
                    public void onComplete() {
                        mView.success(tiYuList);
                    }
                });
    }

    @Override
    public void getTiyuData1(String xuehao) {
        tiYuList.clear();
        APIWrapper.getInstance().getZiZhu(xuehao)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<TiYu>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<TiYu> tiYus) {
                        tiYuList = tiYus;
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.onfail();
                    }

                    @Override
                    public void onComplete() {
                        mView.success(tiYuList);
                    }
                });
    }

    @Override
    public void getTiyuData2(String xuehao) {
        tiYuList.clear();
        APIWrapper.getInstance().getTuoZhan(xuehao)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<TiYu>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<TiYu> tiYus) {
                        tiYuList = tiYus;
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.onfail();
                    }

                    @Override
                    public void onComplete() {
                        mView.success(tiYuList);
                    }
                });
    }
}
