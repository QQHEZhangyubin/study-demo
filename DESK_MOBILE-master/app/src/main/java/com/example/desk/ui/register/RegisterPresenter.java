package com.example.desk.ui.register;

import android.util.Patterns;

import com.example.desk.api.APIWrapper;
import com.example.desk.entity.T3;
import com.example.desk.entity.User;
import com.example.desk.mvp.BasePresenterImpl;
import com.example.desk.util.TLog;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class RegisterPresenter extends BasePresenterImpl<RegisterContract.View> implements RegisterContract.Presenter{

    private String m;
    @Override
    public boolean validate(User user1) {
        //验证用户注册的信息是否符合要求
        boolean valid = true;
        User.DataBean databean = user1.getData();
        if(databean.getGender() == null){
            mView.erroremail("没有选择性别");
            valid = false;
            return valid;
        }
        if (!databean.getUserid().isEmpty() && !databean.getCollege().isEmpty() && !databean.getClasss().isEmpty()
                && !databean.getBirthday().isEmpty() && !databean.getEmail().isEmpty() && !databean.getPassword().isEmpty()
                ){
            if (databean.getUserid().length() == 10){
                Pattern  p = Pattern.compile("[0-9]*");
                Matcher isNum = p.matcher(databean.getUserid());
                if (!isNum.matches()){
                    mView.erroremail("内容不符合学号要求");
                    valid = false;
                    return valid;
                }
            }else {
                mView.erroremail("学号位数不符合要求");
                valid = false;
                return valid;
            }

            if (databean.getBirthday().length() != 10){
                mView.erroremail("生日格式不符合要求。");
                valid = false;
                return valid;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(databean.getEmail()).matches()){
                mView.erroremail("邮箱信息存在问题！");
                valid = false;
                return valid;
            }
            if (databean.getPassword().length()<4||databean.getPassword().length()>10){
                mView.errorpwd("密码需要在4-10位之间！");
                valid = false;
                return valid;
            }

        }else {
            mView.emptymessage("注册填写信息存在空项！");
            valid = false;
        }
        return valid;
    }

    @Override
    public void register(final User user) {
        User.DataBean dataBean = user.getData();
        APIWrapper.getInstance().registeruser(dataBean.getUserid(),dataBean.getPassword(),dataBean.getCollege(),dataBean.getClasss()
        ,dataBean.getBirthday(),dataBean.getEmail(),dataBean.getGender())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               /* .subscribe(new Subscriber<T3>() {
                    @Override
                    public void onCompleted() {
                        if (m.equals("success")){
                            mView.registersuccess(user);
                        }
                        if (m.equals("existed")){
                            mView.registerfaith("该账号已经注册！");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error(e.toString());
                        mView.registerfaith("注册失败，暂时连接不到服务器！");
                    }

                    @Override
                    public void onComplete() {
                        if (m.equals("success")){
                            mView.registersuccess(user);
                        }
                        if (m.equals("existed")){
                            mView.registerfaith("该账号已经注册！");
                        }
                    }

                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(T3 t3) {
                        TLog.log("注册情况" + t3.getMessage());
                        m = t3.getMessage();
                    }
                });
        */
               .subscribe(new Observer<T3>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(T3 t3) {
                       TLog.log("注册情况" + t3.getMessage());
                       m = t3.getMessage();
                   }

                   @Override
                   public void onError(Throwable e) {
                       TLog.error(e.toString());
                       mView.registerfaith("注册失败，暂时连接不到服务器！");
                   }

                   @Override
                   public void onComplete() {
                       if (m.equals("success")){
                           mView.registersuccess(user);
                       }
                       if (m.equals("existed")){
                           mView.registerfaith("该账号已经注册！");
                       }
                   }
               });
    }
}
