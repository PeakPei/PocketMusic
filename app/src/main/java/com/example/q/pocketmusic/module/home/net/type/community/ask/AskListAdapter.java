package com.example.q.pocketmusic.module.home.net.type.community.ask;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.q.pocketmusic.R;
import com.example.q.pocketmusic.callback.AbsOnClickItemHeadListener;
import com.example.q.pocketmusic.data.bean.MyUser;
import com.example.q.pocketmusic.data.bean.ask.AskSongPost;

import com.example.q.pocketmusic.config.pic.DisplayStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鹏君 on 2017/1/26.
 */

public class AskListAdapter extends RecyclerArrayAdapter<AskSongPost> {
    private DisplayStrategy displayStrategy;
    private Context context;
    private AbsOnClickItemHeadListener absOnClickItemHeadListener;

    public void setAbsOnClickItemHeadListener(AbsOnClickItemHeadListener absOnClickItemHeadListener) {
        this.absOnClickItemHeadListener = absOnClickItemHeadListener;
    }

    public AskListAdapter(Context context) {
        super(context);
        this.context = context;
        displayStrategy = new DisplayStrategy();
    }


    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(parent);
    }

    class MyViewHolder extends BaseViewHolder<AskSongPost> {
        TextView postUserHotTv;
        TextView postUserTitleTv;
        TextView postUserContentTv;
        TextView postUserNameTv;
        TextView postUserDateTv;
        TextView postUserCommentNumTv;
        ImageView postUserHeadIv;
        LinearLayout contentLl;

        public MyViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_ask_song);
            postUserTitleTv = $(R.id.post_user_title_tv);
            postUserContentTv = $(R.id.post_user_content_tv);
            postUserNameTv = $(R.id.post_user_name_tv);
            postUserHeadIv = $(R.id.post_user_head_iv);
            postUserDateTv = $(R.id.post_user_date_tv);
            postUserCommentNumTv = $(R.id.post_user_comment_num_tv);
            postUserHotTv = $(R.id.post_user_hot_tv);
            contentLl = $(R.id.content_ll);
        }

        @Override
        public void setData(final AskSongPost data) {
            super.setData(data);
            postUserTitleTv.setText("标题：" + data.getTitle());
            postUserContentTv.setText("描述：" + data.getContent());
            postUserNameTv.setText(data.getUser().getNickName());
            displayStrategy.displayCircle(context, data.getUser().getHeadImg(), postUserHeadIv);
            postUserDateTv.setText(data.getCreatedAt());
            postUserCommentNumTv.setText(String.valueOf(data.getCommentNum()));
            postUserHotTv.setText(String.valueOf(data.getIndex()));
            contentLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (absOnClickItemHeadListener != null) {
                        absOnClickItemHeadListener.onClickItem(getAdapterPosition());
                    }
                }
            });
            postUserHeadIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyUser other = data.getUser();
                    if (absOnClickItemHeadListener != null) {
                        absOnClickItemHeadListener.onClickHead(context, other);
                    }
                }
            });
        }



    }
}
