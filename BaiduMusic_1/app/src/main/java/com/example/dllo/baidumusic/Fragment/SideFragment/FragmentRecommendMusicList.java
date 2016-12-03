package com.example.dllo.baidumusic.Fragment.SideFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.baidumusic.Adapter.RecommendMusicListItemAdapter;
import com.example.dllo.baidumusic.Adapter.TopTenItemAdapter;
import com.example.dllo.baidumusic.Bean.RecommendMusicListBean;
import com.example.dllo.baidumusic.Bean.TopTenItemBean;
import com.example.dllo.baidumusic.CustomizeView.BlurTransformation;
import com.example.dllo.baidumusic.Direction.DividerItemDecoration;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.Interface.MyClick;
import com.example.dllo.baidumusic.R;
import com.squareup.picasso.Picasso;


/**
 * Created by Administrator on 2016/11/22.
 */

public class FragmentRecommendMusicList extends BaseFragment {

   private ImageView iv_btn_from_right_more_back;
    private RecyclerView rv;
    private AppCompatActivity appCompatActivity;
    private RecommendMusicListBean data;

    private TextView tv_title; //tv_recommend_musiclist_title
    private TextView tag; //tv_recommend_musiclist_tag
    private ImageView iv_back; //iv_recommend_musiclist_back
    private ImageView iv_center; //tv_recommend_musiclist_center



    public FragmentRecommendMusicList() {

    }

    @SuppressLint("ValidFragment")
    public FragmentRecommendMusicList(AppCompatActivity appCompatActivity, RecommendMusicListBean data) {
        this.appCompatActivity = appCompatActivity;
        this.data=data;
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_from_right_recommend_musilist;
    }

    @Override
    public void initView(View view) {

        tv_title=bindView(R.id.tv_recommend_musiclist_title);
        tag=bindView(R.id.tv_recommend_musiclist_tag);
        iv_back=bindView(R.id.iv_recommend_musiclist_back);
        iv_center=bindView(R.id.iv_recommend_musiclist_center);
        rv=bindView(R.id.rv_recommend_musiclist_content);
    }

    @Override
    public void initData() {
        Picasso.with(getContext()).load(data.getPic_w700()).into(iv_center);
        Picasso.with(getContext()).load(data.getPic_w700()) .transform(new BlurTransformation(getContext())).into(iv_back);
        tv_title.setText(data.getTitle());
        tag.setText(data.getTag());
        /**
         * 歌单适配器
         */
        RecommendMusicListItemAdapter recommendMusicListItemAdapter=new RecommendMusicListItemAdapter(getContext());
        recommendMusicListItemAdapter.setMyClick(new MyClick() {
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


        recommendMusicListItemAdapter.setData(data);
        rv.setAdapter(recommendMusicListItemAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


    }



}
