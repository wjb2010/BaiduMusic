package com.example.dllo.baidumusic.Adapter.RecommendAdpater.BaseAdpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class GeshouViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> data;
    private String[] title={"","","",""};


    public void setData(ArrayList<Fragment> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public GeshouViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }
}
