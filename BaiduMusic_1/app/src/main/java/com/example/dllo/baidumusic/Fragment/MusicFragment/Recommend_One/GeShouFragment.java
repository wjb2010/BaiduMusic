package com.example.dllo.baidumusic.Fragment.MusicFragment.Recommend_One;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dllo.baidumusic.Adapter.RecommendAdpater.BaseAdpater.GeshouAdapter;
import com.example.dllo.baidumusic.Direction.DividerItemDecoration;
import com.example.dllo.baidumusic.Fragment.BaseFragment;
import com.example.dllo.baidumusic.R;


/**
 * Created by Administrator on 2016/11/22.
 */

public class GeShouFragment extends BaseFragment {

   private ImageView iv_btn_from_right_more_back;
    private RecyclerView rv;
    private AppCompatActivity appCompatActivity;

    public GeShouFragment() {
    }

    @SuppressLint("ValidFragment")
    public GeShouFragment(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_from_right_geshou;
    }

    @Override
    public void initView(View view) {
       // tv=bindView(R.i)
        iv_btn_from_right_more_back=bindView(R.id.iv_btn_from_right_more_back);

        rv=bindView(R.id.rv_geshou);
    }

    @Override
    public void initData() {


        GeshouAdapter geshouAdapter=new GeshouAdapter(getContext(),appCompatActivity);

        rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        rv.setAdapter(geshouAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));








        iv_btn_from_right_more_back.setClickable(true);
        iv_btn_from_right_more_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.myanim,R.anim.myanim2);
                fragmentTransaction.remove(fragmentManager.findFragmentByTag("fra_geshou"));
                fragmentTransaction.commit();
                //Toast.makeText(getContext(), "hh", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
