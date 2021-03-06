package com.example.q.pocketmusic.data.model;

import com.example.q.pocketmusic.callback.ToastQueryListener;
import com.example.q.pocketmusic.callback.ToastSaveListener;
import com.example.q.pocketmusic.config.constant.BmobConstant;
import com.example.q.pocketmusic.data.bean.CommunityState;
import com.example.q.pocketmusic.module.common.BaseModel;
import com.example.q.pocketmusic.util.UserUtil;

import cn.bmob.v3.BmobQuery;

/**
 * Created by 81256 on 2017/10/19.
 */
//动态
public class UserCommunityStateModel extends BaseModel<CommunityState> {

    @Override
    public void getList(Object equalsObject, int page, ToastQueryListener<CommunityState> listener) {
        super.getList(equalsObject, page, listener);
        BmobQuery<CommunityState> query = new BmobQuery<>();
        initDefaultListQuery(query, page);
        query.addWhereEqualTo("communityType", equalsObject);
        query.addWhereEqualTo("isHide", false);
        query.include(BmobConstant.BMOB_USER);
        query.findObjects(listener);
    }

    public void addCommunityState(int community, int state, String content, ToastSaveListener<String> listener) {
        if (UserUtil.user == null) {
            return;
        }
        CommunityState communityState = new CommunityState();
        communityState.setUser(UserUtil.user);
        communityState.setHide(false);
        communityState.setCommunityType(community);
        communityState.setStateType(state);
        communityState.setContent(content);
        communityState.save(listener);
    }
}
