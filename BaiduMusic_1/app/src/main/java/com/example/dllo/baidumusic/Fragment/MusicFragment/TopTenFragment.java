package com.example.dllo.baidumusic.Fragment.MusicFragment;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.TopTenAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendOutRecyclerViewAdapter;
import com.example.dllo.baidumusic.Bean.RecommendBean;
import com.example.dllo.baidumusic.Bean.TopTenBean;
import com.example.dllo.baidumusic.Bean.TopTenItemBean;
import com.example.dllo.baidumusic.Direction.DividerItemDecoration;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.Fragment.SideFragment.FragmentMore;
import com.example.dllo.baidumusic.Fragment.SideFragment.FragmentTopTen;
import com.example.dllo.baidumusic.Interface.MyClick;
import com.example.dllo.baidumusic.R;
import com.example.dllo.baidumusic.VolleyPackage.NetHelper;
import com.example.dllo.baidumusic.VolleyPackage.NetListener;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/11/24.
 */

public class TopTenFragment extends BaseFragment {

    public static final String url="http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.0.0&channel=musicsybutton&operator=3&method=baidu.ting.billboard.billCategory&format=json&kflag=2";
    private RecyclerView rv;
    public static final String PARTA="http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.0.0&channel=wandoujia&operator=3&method=baidu.ting.billboard.billList&format=json&type=";
    public static final String PARTC="&offset=0&size=100&fields=song_id%2Ctitle%2Cauthor%2Calbum_title%2Cpic_big%2Cpic_small%2Chavehigh%2Call_rate%2Ccharge%2Chas_mv_mobile%2Clearn%2Csong_source%2Ckorean_bb_song";

    private AppCompatActivity appCompatActivity;

    public TopTenFragment() {
    }

    @SuppressLint("ValidFragment")
    public TopTenFragment(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public int setLayout() {

        return R.layout.fragment_top_ten;

    }

    @Override
    public void initView(View view) {
        rv=bindView(R.id.rv_top_ten);

    }

    @Override
    public void initData() {







        /**
         * Volley封装
         */
        NetHelper.MyRequest(url, TopTenBean.class, new NetListener<TopTenBean>() {
            @Override
            public void successListener(final TopTenBean response) {

                TopTenAdapter out=new TopTenAdapter(getContext());
                out.setMyClick(new MyClick() {
                    @Override
                    public void MyClick(int position) {
                        int typePartB=response.getContent().get(position).getType();
                        String finalUrl=PARTA+typePartB+PARTC;
                        NetHelper.MyRequest(finalUrl, TopTenItemBean.class, new NetListener<TopTenItemBean>() {
                            @Override
                            public void successListener(TopTenItemBean response) {

                                FragmentManager fragmentManager=appCompatActivity.getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                                fragmentTransaction.setCustomAnimations(R.anim.myanim, R.anim.myanim2);
                                fragmentTransaction.add(R.id.fra, new FragmentTopTen(appCompatActivity,response), "fra_topten");
                                fragmentTransaction.addToBackStack("fra_topten");
                                fragmentTransaction.commit();
                            }

                            @Override
                            public void errorListener(VolleyError error) {

                            }
                        });
                    }

                    @Override
                    public void MyClickUrl(String url, int position) {

                    }
                });



















                rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                out.setData(response);
                rv.setAdapter(out);

                rv.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });




    }
}
