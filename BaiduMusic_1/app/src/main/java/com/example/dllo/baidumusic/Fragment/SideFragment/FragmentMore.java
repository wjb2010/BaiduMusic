package com.example.dllo.baidumusic.Fragment.SideFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.R;


/**
 * Created by Administrator on 2016/11/22.
 */

public class FragmentMore extends BaseFragment {

   private ImageView iv_btn_from_right_more_back;





    @Override
    public int setLayout() {
        return R.layout.fragment_from_right_more;
    }

    @Override
    public void initView(View view) {
       // tv=bindView(R.i)
        iv_btn_from_right_more_back=bindView(R.id.iv_btn_from_right_more_back);

    }

    @Override
    public void initData() {

        iv_btn_from_right_more_back.setClickable(true);
        iv_btn_from_right_more_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.myanim,R.anim.myanim2);
                fragmentTransaction.remove(fragmentManager.findFragmentByTag("fra1"));
                fragmentTransaction.commit();
                //Toast.makeText(getContext(), "hh", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
