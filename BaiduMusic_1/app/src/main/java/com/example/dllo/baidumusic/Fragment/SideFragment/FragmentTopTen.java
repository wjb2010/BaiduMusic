package com.example.dllo.baidumusic.Fragment.SideFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dllo.baidumusic.Adapter.RecommendAdpater.BaseAdpater.GeshouAdapter;
import com.example.dllo.baidumusic.Adapter.TopTenItemAdapter;
import com.example.dllo.baidumusic.Bean.TopTenItemBean;
import com.example.dllo.baidumusic.Direction.DividerItemDecoration;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.Interface.MyClick;
import com.example.dllo.baidumusic.R;
import com.squareup.picasso.Picasso;


/**
 * Created by Administrator on 2016/11/22.
 */

public class FragmentTopTen extends BaseFragment {

   private ImageView iv_btn_from_right_more_back;
    private RecyclerView rv;
    private AppCompatActivity appCompatActivity;
 private TopTenItemBean data;
    private ImageView iv;



    public FragmentTopTen() {

    }

    @SuppressLint("ValidFragment")
    public FragmentTopTen(AppCompatActivity appCompatActivity,TopTenItemBean data) {
        this.appCompatActivity = appCompatActivity;
        this.data=data;
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_from_right_topten;
    }

    @Override
    public void initView(View view) {

        rv=bindView(R.id.rv_item_topten);
        iv=bindView(R.id.iv_item_topten);
    }

    @Override
    public void initData() {
        Picasso.with(getContext()).load(data.getBillboard().getPic_s210()).into(iv);
        TopTenItemAdapter topTenItemAdapter=new TopTenItemAdapter(getContext());
        topTenItemAdapter.setMyClick(new MyClick() {
            @Override
            public void MyClick(int position) {

            }

            @Override
            public void MyClickUrl(String url, int position) {

                Intent intent=new Intent("MY_MUSIC_CONTROL_BR");
                //Log.d("FragmentTopTen", url);
                intent.putExtra("play_net_music",url);
                getContext().sendBroadcast(intent);

            }
        });
        rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        topTenItemAdapter.setData(data);
        rv.setAdapter(topTenItemAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


    }



}
