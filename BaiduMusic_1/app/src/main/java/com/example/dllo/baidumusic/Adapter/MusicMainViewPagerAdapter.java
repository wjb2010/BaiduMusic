package com.example.dllo.baidumusic.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/26.
 */

public class MusicMainViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> data;

    public void setData(ArrayList<Fragment> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public MusicMainViewPagerAdapter(FragmentManager fm) {

        super(fm);



    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }


}
