package com.example.desk.ui.publishvideo;

import android.content.Context;

import com.example.desk.api.APIWrapper;
import com.example.desk.been.ReturnMsg;
import com.example.desk.mvp.BasePresenterImpl;
import com.example.desk.util.StringUtils;
import com.example.desk.util.TLog;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static com.example.desk.api.APIService.TOLOGIN;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class PublishVideoPresenter extends BasePresenterImpl<PublishVideoContract.View> implements PublishVideoContract.Presenter{

    @Override
    public void addVideoPost(String userId, String content, int type, String videoPath, String videoImg, Observer<ReturnMsg> observer) {
        Map<String, RequestBody> request = new HashMap<>();
        request.put("content", RequestBody.create(null, content));
        request.put("userId", RequestBody.create(null, userId));
        request.put("type", RequestBody.create(null, type + ""));

        String VideoFileName = StringUtils.getURLFileName(videoPath);
        RequestBody video = RequestBody.create(MediaType.parse("'video/mpeg'"), new File(videoPath));
        request.put("video\"; filename=\"" + VideoFileName, video);

        String videoImgName = StringUtils.getURLFileName(videoImg);
        RequestBody photo = RequestBody.create(MediaType.parse("image/png"), new File(videoImg));
        request.put("videoImg\"; filename=\"" + videoImgName, photo);
        Observable<ReturnMsg> x = APIWrapper.getInstance().create("post", request);
        execute(x,observer);
    }

    private void execute(Observable<ReturnMsg> observeable, final Observer<ReturnMsg> observer) {
        /**
         * RxJava将这个操作符实现为repeat方法。它不是创建一个Observable，
         * 而是重复发射原始Observable的数据序列，这个序列或者是无限的，或者通过repeat(n)指定重复次数
         */
        observeable.repeat(1);
        observeable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReturnMsg>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReturnMsg returnMsg) {
                        TLog.error("onNext: 返回的数据+" + returnMsg.toString());
                        if (returnMsg.getIs() != TOLOGIN) {
                            Observable.just(returnMsg)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(observer);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.analytics("onError: 出错啦" + e.getMessage());
                        observer.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
