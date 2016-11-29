package com.example.dllo.baidumusic.Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.baidumusic.Adapter.MusicViewPagerAdapter;
import com.example.dllo.baidumusic.Fragment.MusicFragment.RecommendFragment;
import com.example.dllo.baidumusic.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class FragmentMusic extends BaseFragment {

    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> data;

    @Override
    public int setLayout() {
        return R.layout.fragment_music;
    }

    @Override
    public void initView(View view) {

        tab=bindView(R.id.tab_music);
        vp=bindView(R.id.vp_music);


    }

    @Override
    public void initData() {

        data=new ArrayList<>();
        data.add(new RecommendFragment());
        data.add(new FragmentTest());
        data.add(new FragmentTest());
        data.add(new FragmentTest());
        data.add(new FragmentTest());

        MusicViewPagerAdapter musicViewPagerAdapter=new MusicViewPagerAdapter(getChildFragmentManager());
        musicViewPagerAdapter.setData(data);
        vp.setAdapter(musicViewPagerAdapter);
        tab.setupWithViewPager(vp);



    }
}
