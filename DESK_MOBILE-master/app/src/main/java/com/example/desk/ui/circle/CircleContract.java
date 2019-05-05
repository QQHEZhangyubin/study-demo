package com.example.desk.ui.circle;

import android.content.Context;

import com.example.desk.been.CommentBean;
import com.example.desk.been.CommentConfig;
import com.example.desk.been.FavortsBean;
import com.example.desk.been.PostBean;
import com.example.desk.mvp.BasePresenter;
import com.example.desk.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class CircleContract {

    interface View extends BaseView {

        void showErrorProgress(String msg);
        void showLoadProgress(String msg);
        /**
         * 关闭上下拉刷新界面
         *
         * @param msg
         */
        void closeSwipeView(String msg);

        /**
         * 删除说说的回调
         *
         * @param circlePosition
         */
        void updateDeleteCircle(int circlePosition);

        /**
         * 添加点赞的回调
         *
         * @param circlePosition
         * @param addItem
         */
        void updateAddFavorite(int circlePosition, FavortsBean addItem);

        /**
         * 删除点赞的回调
         *
         * @param circlePosition
         * @param favortId
         */
        void updateDeleteFavort(int circlePosition, int favortId);

        /**
         * 添加评价的回调
         *
         * @param circlePosition
         * @param addItem
         */
        void updateAddComment(int circlePosition, CommentBean addItem);

        /**
         * 删除评价的回调
         *
         * @param circlePosition
         * @param commentId
         */
        void updateDeleteComment(int circlePosition, int commentId);

        /**
         * 评价输入框
         *
         * @param visibility
         * @param commentConfig
         */
        void updateEditTextBodyVisible(int visibility, CommentConfig commentConfig);

        /**
         * 获取数据
         *
         * @param loadType
         * @param datas
         */
        void updateloadData(int loadType, List<PostBean> datas);

        void makeText(String s);
    }

    /**
     * 对应Presenter要处理的接口
     */
    interface Presenter extends BasePresenter<View> {

        /**
         * 获取数据
         *
         * @param loadType 获取类型，刷新/加载更多
         */
        void loadData(int loadType);

        /**
         * 删除说说
         *
         * @param circlePosition 说说位置
         * @param circleId       说说Id
         */
        void deleteCircle(final int circlePosition, final int circleId);

        /**
         * 删除点赞
         *
         * @param circlePosition 说说位置
         * @param postId         说说Id
         * @param userId         用户ID
         */
        void deleteFavort(final int circlePosition, final int postId, final int userId);

        /**
         * 添加点赞
         *
         * @param circlePosition 说说位置
         * @param circleId       说说Id
         */
        void addFavort(final int circlePosition, final int circleId);

        /**
         * 添加评价
         *
         * @param content 内容
         * @param config  评价配置
         */
        void addComment(final String content, final CommentConfig config);

        /**
         * 删除评价
         *
         * @param circlePosition 说说位置
         * @param commentId      评价Id
         */
        void deleteComment(final int circlePosition, final int commentId);
    }

}
