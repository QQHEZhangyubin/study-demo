package com.example.desk.ui.second;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.example.desk.MainActivity;
import com.example.desk.api.APIWrapper;
import com.example.desk.entity.ShuoShuo;
import com.example.desk.mvp.BasePresenterImpl;
import com.example.desk.ui.comment.CommentActivity;
import com.example.desk.util.TLog;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class SecondPresenter extends BasePresenterImpl<SecondContract.View> implements SecondContract.Presenter{
    private ArrayList<ShuoShuo> shuoShuoList = new ArrayList<>();
    @Override
    public void initData2() {
        APIWrapper.getInstance().RequestData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                /*.subscribe(new Subscriber<ArrayList<ShuoShuo>>() {
                    @Override
                    public void onCompleted() {
                        mView.Success1(shuoShuoList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.Fail1();
                    }

                    @Override
                    public void onNext(ArrayList<ShuoShuo> shuoShuos) {
                        shuoShuoList = shuoShuos;
                    }
                });
                */
                .subscribe(new Observer<ArrayList<ShuoShuo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<ShuoShuo> shuoShuos) {
                        shuoShuoList = shuoShuos;
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.Fail1();
                    }

                    @Override
                    public void onComplete() {
                        mView.Success1(shuoShuoList);
                    }
                });
    }
}
