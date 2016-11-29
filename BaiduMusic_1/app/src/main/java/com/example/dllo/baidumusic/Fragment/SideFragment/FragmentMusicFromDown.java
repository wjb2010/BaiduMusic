package com.example.dllo.baidumusic.Fragment.SideFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.baidumusic.Adapter.MusicMainViewPagerAdapter;
import com.example.dllo.baidumusic.Adapter.MusicViewPagerAdapter;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.Fragment.MusicMainFragment.FragmentCenter;
import com.example.dllo.baidumusic.Fragment.MusicMainFragment.FragmentLeft;
import com.example.dllo.baidumusic.Fragment.MusicMainFragment.FragmentRight;
import com.example.dllo.baidumusic.R;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.ZoomInTransformer;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/11/22.
 */

public class FragmentMusicFromDown extends BaseFragment {


    private ViewPager vp;
   private ImageView iv_btn_music_main_back;

    @Override
    public int setLayout() {


        return R.layout.fragment_from_down_music_main;
    }



    @Override
    public void initView(View view) {
       // tv=bindView(R.i)
        vp=bindView(R.id.vp_music_main);
        iv_btn_music_main_back=bindView(R.id.iv_btn_music_main_back);
    }

    @Override
    public void initData() {


        MusicMainViewPagerAdapter musicMainViewPagerAdapter=new MusicMainViewPagerAdapter(getChildFragmentManager());
        ArrayList<Fragment> data=new ArrayList<>();
        data.add(new FragmentLeft());
        data.add(new FragmentCenter());
        data.add(new FragmentRight());
        musicMainViewPagerAdapter.setData(data);


        vp.setPageTransformer(true,new DepthPageTransformer());
        vp.setAdapter(musicMainViewPagerAdapter);
        vp.setCurrentItem(1);

        iv_btn_music_main_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击了返回", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.myanim_from_down_one,R.anim.myanim_from_down_two);
                fragmentTransaction.remove(fragmentManager.findFragmentByTag("fra_from_down"));
                fragmentTransaction.commit();
            }
        });





    }
}
