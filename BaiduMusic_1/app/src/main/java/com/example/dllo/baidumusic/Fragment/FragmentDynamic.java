package com.example.dllo.baidumusic.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Adapter.DynamicOutRecyclerViewAdapter;
import com.example.dllo.baidumusic.Bean.DynamicBean;
import com.example.dllo.baidumusic.Direction.DividerItemDecoration;
import com.example.dllo.baidumusic.R;
import com.example.dllo.baidumusic.VolleyPackage.NetHelper;
import com.example.dllo.baidumusic.VolleyPackage.NetListener;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/11/28.
 */

public class FragmentDynamic extends BaseFragment {

    private String url="http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.0.0&channel=wandoujia&operator=3&method=baidu.ting.ugcfriend.getList&format=json&param=MdQHiv%2F%2BBSYTl39VXcn8dESPvw4rM3naxQSdeb7JiGSv9pqRpzZMYcxA%2FqvopkR2NgdsRojMb6i2CxNCpB%2F98g%3D%3D&timestamp=1480142598&sign=462064952b8866d85f5c007d7a2cf674";

    private RecyclerView rv;
    @Override
    public int setLayout() {
        return R.layout.fragment_dynamic;
    }

    @Override
    public void initView(View view) {

        rv=bindView(R.id.rv_dynamic_base);
    }

    @Override
    public void initData() {
        /**
         * Volley封装
         */
        NetHelper.MyRequest(url, DynamicBean.class, new NetListener<DynamicBean>() {
            @Override
            public void successListener(DynamicBean response) {




                DynamicOutRecyclerViewAdapter dynamicOutRecyclerViewAdapter=new DynamicOutRecyclerViewAdapter(getContext());


                dynamicOutRecyclerViewAdapter.setData(response);
                rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
                rv.setAdapter(dynamicOutRecyclerViewAdapter);

                rv.setLayoutManager(new LinearLayoutManager(getContext()));

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });






    }
}
