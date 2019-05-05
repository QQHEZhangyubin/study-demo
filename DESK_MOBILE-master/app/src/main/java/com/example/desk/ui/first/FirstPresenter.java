package com.example.desk.ui.first;

import com.example.desk.api.APIWrapper;
import com.example.desk.entity.Seat;
import com.example.desk.mvp.BasePresenterImpl;
import com.example.desk.util.TLog;
import com.nostra13.universalimageloader.utils.L;

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

public class FirstPresenter extends BasePresenterImpl<FirstContract.View> implements FirstContract.Presenter{

    private List<Seat> seatList = new ArrayList<>();
    @Override
    public void getSeatData() {
        APIWrapper.getInstance().QuerySeatInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                /*.subscribe(new Subscriber<List<Seat>>() {
                    @Override
                    public void onCompleted() {
                        mView.Success(seatList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.Error("请求不到数据");
                    }

                    @Override
                    public void onNext(List<Seat> seats) {
                        for (Seat seat : seats){
                            seatList.add(seat);
                        }
                    }
                });*/
                .subscribe(new Observer<List<Seat>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Seat> seats) {
                        for (Seat seat : seats){
                            seatList.add(seat);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.Error("请求不到数据");
                    }

                    @Override
                    public void onComplete() {
                        mView.Success(seatList);
                    }
                });

    }
}
