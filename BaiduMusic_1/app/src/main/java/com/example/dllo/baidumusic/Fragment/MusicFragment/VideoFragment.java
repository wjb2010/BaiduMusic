package com.example.dllo.baidumusic.Fragment.MusicFragment;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.MusicListAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.MusicListRightAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.VideoLeftAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.VideoRightAdapter;
import com.example.dllo.baidumusic.Bean.MusicListBean;
import com.example.dllo.baidumusic.Bean.MusicListNewBean;
import com.example.dllo.baidumusic.Bean.VideoLeftBean;
import com.example.dllo.baidumusic.Bean.VideoRightBean;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.R;
import com.example.dllo.baidumusic.VolleyPackage.NetHelper;
import com.example.dllo.baidumusic.VolleyPackage.NetListener;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/11/29.
 */

public class VideoFragment extends BaseFragment {

    private String url_left = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.0.0&channel=360safe&operator=3&provider=11%2C12&method=baidu.ting.mv.searchMV&format=json&order=1&page_num=1&page_size=20&query=%E5%85%A8%E9%83%A8";
    private String url_right = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.0.0&channel=360safe&operator=3&provider=11%2C12&method=baidu.ting.mv.searchMV&format=json&order=0&page_num=1&page_size=20&query=%E5%85%A8%E9%83%A8";
    private RecyclerView rv;

    private TextView tv_left, tv_right;

    @Override
    public int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void initView(View view) {

        rv = bindView(R.id.rv_musilist);
        tv_left = (TextView) view.findViewById(R.id.tv_musiclist_left);
        tv_right = (TextView) view.findViewById(R.id.tv_musiclist_right);
    }

    @Override
    public void initData() {
        tv_left.setTextColor(Color.argb(255, 36, 54, 255));

        /**
         * Volley封装
         */

        NetHelper.MyRequest(url_left, VideoLeftBean.class, new NetListener<VideoLeftBean>() {
            @Override
            public void successListener(VideoLeftBean response) {


                VideoLeftAdapter out = new VideoLeftAdapter(getContext());
                // rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                out.setData(response);
                rv.setAdapter(out);

                rv.setLayoutManager(new GridLayoutManager(getContext(), 2));

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });


        tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_left.setTextColor(Color.argb(255, 36, 54, 255));
                tv_right.setTextColor(Color.argb(255, 00, 00, 00));

                /**
                 * Volley封装
                 */

                NetHelper.MyRequest(url_left, VideoLeftBean.class, new NetListener<VideoLeftBean>() {
                    @Override
                    public void successListener(VideoLeftBean response) {
                        VideoLeftAdapter out = new VideoLeftAdapter(getContext());
                        // rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                        out.setData(response);
                        rv.setAdapter(out);

                        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));

                    }

                    @Override
                    public void errorListener(VolleyError error) {

                    }
                });


            }
        });

        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_right.setTextColor(Color.argb(255, 36, 54, 255));
                tv_left.setTextColor(Color.argb(255, 00, 00, 00));
                /**
                 * Volley封装
                 */
                NetHelper.MyRequest(url_right, VideoRightBean.class, new NetListener<VideoRightBean>() {
                    @Override
                    public void successListener(VideoRightBean response) {
                        VideoRightAdapter out = new VideoRightAdapter(getContext());
                        // rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                        out.setData(response);
                        rv.setAdapter(out);

                        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));


                    }

                    @Override
                    public void errorListener(VolleyError error) {

                    }
                });

            }
        });


    }
}
