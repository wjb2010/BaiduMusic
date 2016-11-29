package com.example.dllo.baidumusic.Fragment.MusicFragment;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.MusicListAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.MusicListRightAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendOutRecyclerViewAdapter;
import com.example.dllo.baidumusic.Bean.MusicListBean;
import com.example.dllo.baidumusic.Bean.MusicListNewBean;
import com.example.dllo.baidumusic.Bean.RecommendBean;
import com.example.dllo.baidumusic.Direction.DividerItemDecoration;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.R;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/11/29.
 */

public class MusicListFragment extends BaseFragment {

    private String url_left = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.diy.gedan&page_no=1&page_size=30&from=ios&version=5.2.3&from=ios&channel=appstore";
    private String url_right = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.0.0&channel=musicsybutton&operator=3&method=baidu.ting.ugcdiy.getChanneldiy&param=KCMEbowGs9x5xx60uhnTbuKh%2FJSHQO2cZoBMGjXmxtEbf5ooybFfTK2bHQYo71cyyqSqUD0iAoWKCW3Gc%2Fr4XKph39rVWd3u%2Fda4qBk0Xm2oORqSMzw6lIksZDl1HzjHEytMMDFZkQX4S0qjspGiFQ%3D%3D&timestamp=1480419423&sign=801e1d7e85140751da7b883375e81815";
    private RecyclerView rv;

    private TextView tv_left,tv_right;

    @Override
    public int setLayout() {
        return R.layout.fragment_musiclist;
    }

    @Override
    public void initView(View view) {

        rv = bindView(R.id.rv_musilist);
        tv_left = (TextView) view.findViewById(R.id.tv_musiclist_left);
        tv_right = (TextView) view.findViewById(R.id.tv_musiclist_right);
    }

    @Override
    public void initData() {
        tv_left.setTextColor(Color.argb(255,36,54,255));

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(url_left, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                MusicListBean data = new MusicListBean();

                Gson gson = new Gson();
                data = gson.fromJson(response, MusicListBean.class);


                MusicListAdapter out = new MusicListAdapter(getContext());
                // rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                out.setData(data);
                rv.setAdapter(out);

                rv.setLayoutManager(new GridLayoutManager(getContext(), 2));


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);



        tv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_left.setTextColor(Color.argb(255,36,54,255));
                tv_right.setTextColor(Color.argb(255,00,00,00));
                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                StringRequest stringRequest = new StringRequest(url_left, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        MusicListBean data = new MusicListBean();

                        Gson gson = new Gson();
                        data = gson.fromJson(response, MusicListBean.class);


                        MusicListAdapter out = new MusicListAdapter(getContext());
                        // rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                        out.setData(data);
                        rv.setAdapter(out);

                        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(stringRequest);

            }
        });

        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_right.setTextColor(Color.argb(255,36,54,255));
                tv_left.setTextColor(Color.argb(255,00,00,00));

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                StringRequest stringRequest = new StringRequest(url_right, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        MusicListNewBean data = new MusicListNewBean();

                        Gson gson = new Gson();
                        data = gson.fromJson(response, MusicListNewBean.class);


                        MusicListRightAdapter out = new MusicListRightAdapter(getContext());
                        // rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                        out.setData(data);
                        rv.setAdapter(out);

                        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(stringRequest);
            }
        });




    }
}
