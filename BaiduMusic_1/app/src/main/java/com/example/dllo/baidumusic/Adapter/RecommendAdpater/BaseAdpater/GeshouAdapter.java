package com.example.dllo.baidumusic.Adapter.RecommendAdpater.BaseAdpater;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Bean.GeshouVPBean;
import com.example.dllo.baidumusic.Bean.MusicListBean;
import com.example.dllo.baidumusic.Fragment.MusicFragment.Recommend_One.VP_FOUR;
import com.example.dllo.baidumusic.Fragment.MusicFragment.Recommend_One.VP_ONE;
import com.example.dllo.baidumusic.Fragment.MusicFragment.Recommend_One.VP_THREE;
import com.example.dllo.baidumusic.Fragment.MusicFragment.Recommend_One.VP_TWO;
import com.example.dllo.baidumusic.R;
import com.example.dllo.baidumusic.VolleyPackage.NetHelper;
import com.example.dllo.baidumusic.VolleyPackage.NetListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/29.
 */

public class GeshouAdapter extends RecyclerView.Adapter {


    private Context context;
    private String[] name = {"华语男歌手", "华语女歌手", "华语组合", "欧美男歌手", "欧美女歌手", "欧美组合", "韩国男歌手", "韩国女歌手", "韩国组合", "日本男歌手", "日本女歌手", "日本组合", "其他歌手"};
    private String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.artist.getList&format=json&order=1&limit=12&offset=0&area=0&sex=0&abc=&from=ios&version=5.2.1&from=ios&channel=appstore";

    private AppCompatActivity appCompatActivity;
    private ArrayList<Fragment> data_all;


    public GeshouAdapter(Context context, AppCompatActivity appCompatActivity) {
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder geshouViewHolder = null;


        switch (viewType) {
            case 0:
                View view0 = LayoutInflater.from(context).inflate(R.layout.item_recommend_geshou_first, parent, false);
                geshouViewHolder = new GeshouVPViewHolder(view0);
                break;

            default:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_recommend_geshou_second, parent, false);
                geshouViewHolder = new GeshouViewHolder(view1);
                break;

        }


        return geshouViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        switch (position) {

            case 0:
                /**
                 * 封装Volley
                 */
                NetHelper.MyRequest(url, GeshouVPBean.class, new NetListener<GeshouVPBean>() {
                    @Override
                    public void successListener(GeshouVPBean response) {


                        ArrayList<GeshouVPBean.ArtistBean> data_one = new ArrayList<>();
                        ArrayList<GeshouVPBean.ArtistBean> data_two = new ArrayList<>();
                        ArrayList<GeshouVPBean.ArtistBean> data_three = new ArrayList<>();
                        ArrayList<GeshouVPBean.ArtistBean> data_four = new ArrayList<>();

                        for (int i = 0; i < 3; i++) {
                            data_one.add(response.getArtist().get(i));
                            data_two.add(response.getArtist().get(i + 3));
                            data_three.add(response.getArtist().get(i + 6));
                            data_four.add(response.getArtist().get(i + 9));

                        }

                        data_all = new ArrayList<>();
                        data_all.add(new VP_ONE(data_one));
                        data_all.add(new VP_TWO(data_two));
                        data_all.add(new VP_THREE(data_three));
                        data_all.add(new VP_FOUR(data_four));


                        GeshouVPViewHolder geshouVPViewHolder = (GeshouVPViewHolder) holder;
                        GeshouViewPagerAdapter geshouViewPagerAdapter = new GeshouViewPagerAdapter(appCompatActivity.getSupportFragmentManager());

                        geshouViewPagerAdapter.setData(data_all);
                        geshouVPViewHolder.vp.setAdapter(geshouViewPagerAdapter);
                        geshouVPViewHolder.tab.setupWithViewPager(geshouVPViewHolder.vp);


                    }

                    @Override
                    public void errorListener(VolleyError error) {

                    }
                });


                //  vp id: vp_geshou_first


                break;
            default:
                GeshouViewHolder geshouViewHolder = (GeshouViewHolder) holder;
                geshouViewHolder.tv.setText(name[position - 1]);
                break;
        }
    }


    @Override
    public int getItemCount() {
        return 14;
    }

    class GeshouViewHolder extends RecyclerView.ViewHolder {


        private TextView tv;

        public GeshouViewHolder(View itemView) {
            super(itemView);


            tv = (TextView) itemView.findViewById(R.id.tv_geshou_singer);
        }
    }


    class GeshouVPViewHolder extends RecyclerView.ViewHolder {


        private ViewPager vp;
        private TabLayout tab;

        public GeshouVPViewHolder(View itemView) {
            super(itemView);


            vp = (ViewPager) itemView.findViewById(R.id.vp_geshou_first);
            tab = (TabLayout) itemView.findViewById(R.id.tab_geshou_first);
        }
    }


}
