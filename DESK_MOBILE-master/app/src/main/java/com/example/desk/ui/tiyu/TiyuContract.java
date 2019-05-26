package com.example.desk.ui.tiyu;

import com.example.desk.entity.TiYu;
import com.example.desk.mvp.BasePresenter;
import com.example.desk.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class TiyuContract {
    interface View extends BaseView {
        void success(List<TiYu> tiYuList);
        void onfail();
    }

    interface  Presenter extends BasePresenter<View> {
        void getTiyuData(String xuehao);//查早操
        void getTiyuData1(String xuehao);//查自主
        void getTiyuData2(String xuehao);//查拓展
    }
}
