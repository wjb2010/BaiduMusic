package com.example.dllo.baidumusic.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> data;
    private String[] title={"我的","音乐","动态","直播"};

    public void setData(ArrayList<Fragment> data) {
        this.data = data;
    }

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
