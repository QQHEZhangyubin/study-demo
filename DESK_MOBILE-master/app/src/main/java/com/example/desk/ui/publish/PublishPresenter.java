package com.example.desk.ui.publish;

import android.content.Context;

import com.example.desk.api.APIWrapper;
import com.example.desk.been.ReturnMsg;
import com.example.desk.mvp.BasePresenterImpl;
import com.example.desk.util.StringUtils;
import com.example.desk.util.TLog;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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

public class PublishPresenter extends BasePresenterImpl<PublishContract.View> implements PublishContract.Presenter{

    @Override
    public void addPost(String userId, String content, int type, List<String> imgs, Observer<ReturnMsg> observer) {
        Map<String, RequestBody> photos = new HashMap<>();
        photos.put("content", RequestBody.create(null, content));
        photos.put("userId", RequestBody.create(null, userId));
        photos.put("type", RequestBody.create(null, type + ""));
        if (imgs != null && imgs.size() > 0) {
            photos.put("haveimg", RequestBody.create(null, "have"));
            for (String url : imgs) {
                String urlFileName = StringUtils.getURLFileName(url);
                RequestBody photo = RequestBody.create(MediaType.parse("image/png"), new File(url));
                photos.put("photos\"; filename=\"" + urlFileName, photo);
            }
        } else {
            photos.put("haveimg", RequestBody.create(null, "done"));
        }

        Observable<ReturnMsg> z = APIWrapper.getInstance().create("post1", photos);
        execute(z,observer);
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
                        TLog.analytics("onNext: 返回的数据+" + returnMsg.toString());
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
