package com.example.dllo.baidumusic.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class MusicViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> data;
    private String[] title={"推荐","歌单","榜单","视频","K歌"};

    public void setData(ArrayList<Fragment> data) {
        this.data = data;
    }

    public MusicViewPagerAdapter(FragmentManager fm) {
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
