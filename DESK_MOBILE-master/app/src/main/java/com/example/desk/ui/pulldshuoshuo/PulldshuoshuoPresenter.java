package com.example.desk.ui.pulldshuoshuo;

import android.content.Context;

import com.example.desk.api.APIWrapper;
import com.example.desk.entity.Status;
import com.example.desk.mvp.BasePresenterImpl;
import com.example.desk.util.TLog;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class PulldshuoshuoPresenter extends BasePresenterImpl<PulldshuoshuoContract.View> implements PulldshuoshuoContract.Presenter{

    @Override
    public void FabiaoShuoShuo(List<MultipartBody.Part> file, String data,String username) {
        APIWrapper.getInstance().uploadImgs(file,data,username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                /*.subscribe(new Subscriber<Status>() {
                    @Override
                    public void onCompleted() {
                        mView.FabiaoSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.FabiaoFail();
                    }

                    @Override
                    public void onNext(Status s) {
                        TLog.error("onNext " + s.getStatus());
                    }
                });*/
                .subscribe(new Observer<Status>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Status status) {
                        TLog.error("onNext " + status.getStatus());
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.FabiaoFail();
                    }

                    @Override
                    public void onComplete() {
                        mView.FabiaoSuccess();
                    }
                });
    }

    @Override
    public void FabiaoShuoShuoT(String text, String username) {
        APIWrapper.getInstance().uploadImgsT(text,username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               /* .subscribe(new Subscriber<Status>() {
                    @Override
                    public void onCompleted() {
                        mView.FabiaoSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.FabiaoFail();
                    }

                    @Override
                    public void onNext(Status status) {
                        TLog.error("onNext " + status.getStatus());
                    }
                });*/
               .subscribe(new Observer<Status>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(Status status) {
                       TLog.error("onNext " + status.getStatus());
                   }

                   @Override
                   public void onError(Throwable e) {
                       TLog.error(e.toString());
                       mView.FabiaoFail();
                   }

                   @Override
                   public void onComplete() {
                       mView.FabiaoSuccess();
                   }
               });
    }
}
