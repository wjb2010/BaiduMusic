package com.example.dllo.baidumusic.Fragment.MusicFragment.Recommend_One;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.baidumusic.Bean.GeshouVPBean;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/1.
 */

public class VP_ONE extends BaseFragment{
   private ArrayList<GeshouVPBean.ArtistBean> data;
    private ImageView iv1,iv2,iv3;
    private TextView tv1,tv2,tv3;

    public VP_ONE() {
    }

    @SuppressLint("ValidFragment")
    public VP_ONE(ArrayList<GeshouVPBean.ArtistBean> data) {
        this.data = data;
    }

    @Override
    public int setLayout() {
        return R.layout.item_recommend_geshou_vp;
    }

    @Override
    public void initView(View view) {
        iv1=bindView(R.id.iv_item_geshou_one);
        iv2=bindView(R.id.iv_item_geshou_two);
        iv3=bindView(R.id.iv_item_geshou_three);

        tv1=bindView(R.id.tv_item_geshou_one);
        tv2=bindView(R.id.tv_item_geshou_two);
        tv3=bindView(R.id.tv_item_geshou_three);

    }

    @Override
    public void initData() {

        Picasso.with(getContext()).load(data.get(0).getAvatar_big()).into(iv1);
        Picasso.with(getContext()).load(data.get(1).getAvatar_big()).into(iv2);
        Picasso.with(getContext()).load(data.get(2).getAvatar_big()).into(iv3);
        tv1.setText(data.get(0).getName());
        tv2.setText(data.get(1).getName());
        tv3.setText(data.get(2).getName());
    }
}
