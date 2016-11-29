package com.example.dllo.baidumusic.Fragment.MusicFragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Adapter.RecommendOutRecyclerViewAdapter;
import com.example.dllo.baidumusic.Bean.RecommendBean;
import com.example.dllo.baidumusic.Direction.DividerItemDecoration;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.R;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/11/24.
 */

public class RecommendFragment extends BaseFragment {

    public static final String url="http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.0.0&channel=musicsybutton&operator=3&method=baidu.ting.plaza.index&cuid=1D999D9D7637E5FD3633492941572AE7";
    private RecyclerView rv;

    @Override
    public int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView(View view) {
        rv=bindView(R.id.rv_recommend);

    }

    @Override
    public void initData() {

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                RecommendBean data=new RecommendBean();

                Gson gson=new Gson();
                data= gson.fromJson(response, RecommendBean.class);


                RecommendOutRecyclerViewAdapter out=new RecommendOutRecyclerViewAdapter(getContext());
                rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                out.setData(data);
                rv.setAdapter(out);

                rv.setLayoutManager(new LinearLayoutManager(getContext()));





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);




    }
}
