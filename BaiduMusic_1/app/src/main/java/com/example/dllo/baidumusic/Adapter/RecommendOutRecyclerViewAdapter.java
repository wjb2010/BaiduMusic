package com.example.dllo.baidumusic.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.ColumnAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.HotMVAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.HotSellAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.LeBoAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.MusicRecommendAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.NewDiskAdapter;
import com.example.dllo.baidumusic.Adapter.RecommendAdpater.OriMusicAdapter;
import com.example.dllo.baidumusic.Banner.GlideImageloader;
import com.example.dllo.baidumusic.Bean.RanPicBean;
import com.example.dllo.baidumusic.Bean.RecommendBean;
import com.example.dllo.baidumusic.Bean.RecommendMusicListBean;
import com.example.dllo.baidumusic.Direction.DividerItemDecoration;
import com.example.dllo.baidumusic.Fragment.MusicFragment.Recommend_One.GeShouFragment;
import com.example.dllo.baidumusic.Fragment.SideFragment.FragmentMore;
import com.example.dllo.baidumusic.Fragment.SideFragment.FragmentRecommendMusicList;
import com.example.dllo.baidumusic.Fragment.SideFragment.FragmentTopTen;
import com.example.dllo.baidumusic.Interface.MyClick;
import com.example.dllo.baidumusic.R;
import com.example.dllo.baidumusic.VolleyPackage.NetHelper;
import com.example.dllo.baidumusic.VolleyPackage.NetListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dllo on 16/11/24.
 */

public class RecommendOutRecyclerViewAdapter extends RecyclerView.Adapter {

    private Context context;
    /**
     * 此data包含第二个RV的listID
     */
    private RecommendBean data;
    public static final String url_ran = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.plaza.getFocusPic&format=json&from=ios&version=5.2.3&from=ios&channel=appstore";
    private AppCompatActivity appCompatActivity;
    public static final String PARTA="http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.diy.gedanInfo&from=ios&listid=";
    public static final String PARTC="&version=5.2.3&from=ios&channel=appstore";

    public void setData(RecommendBean data) {
        this.data = data;
        notifyDataSetChanged();
    }


    public RecommendOutRecyclerViewAdapter(Context context, AppCompatActivity appCompatActivity) {
        this.context = context;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;


        switch (viewType) {

            case 0:
                View view0 = LayoutInflater.from(context).inflate(R.layout.item_recommend_head, parent, false);

                viewHolder = new BlankViewHolder(view0);
                break;

            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_recommend_gedantuijian, parent, false);

                viewHolder = new MusicRecommendViewHolder(view1);
                break;

            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.item_recommend_xindieshangjia, parent, false);

                viewHolder = new NewMusicViewHolder(view2);
                break;
            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.item_recommend_rexiaozhuanji, parent, false);

                viewHolder = new HotSellViewHolder(view3);
                break;
            case 4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.item_recommend_ad, parent, false);

                viewHolder = new ADViewHolder(view4);
                break;
            case 5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.item_recommend_yuanchuangyinyue, parent, false);

                viewHolder = new OriMusicViewHolder(view5);
                break;
            case 6:
                View view6 = LayoutInflater.from(context).inflate(R.layout.item_recommend_zuiremvtuijian, parent, false);

                viewHolder = new HotMVViewHolder(view6);
                break;

            case 7:
                View view7 = LayoutInflater.from(context).inflate(R.layout.item_recommend_lebojiemu, parent, false);

                viewHolder = new LeBoViewHolder(view7);
                break;

            case 8:
                View view8 = LayoutInflater.from(context).inflate(R.layout.item_recommend_zhuanlan, parent, false);

                viewHolder = new ColumnViewHolder(view8);
                break;

        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        switch (getItemViewType(position)) {

            case 0:


                final BlankViewHolder blankViewHolder = (BlankViewHolder) holder;

                /**
                 * 点击歌手弹出右侧fragment
                 */
                blankViewHolder.iv_geshou.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        fragmentTransaction.setCustomAnimations(R.anim.myanim, R.anim.myanim2);

                        fragmentTransaction.add(R.id.fra, new GeShouFragment(appCompatActivity), "fra_geshou");
                        fragmentTransaction.addToBackStack("fra_geshou");

                        fragmentTransaction.commit();


                    }
                });

                /**
                 * Volley封装
                 */

                NetHelper.MyRequest(url_ran, RanPicBean.class, new NetListener<RanPicBean>() {
                    @Override
                    public void successListener(RanPicBean response) {

                        ArrayList<String> pics = new ArrayList<>();


                        for (int i = 0; i < response.getPic().size(); i++) {


                            pics.add(response.getPic().get(i).getRandpic());
                        }

                        initRanPics(pics, blankViewHolder.banner);

                    }

                    @Override
                    public void errorListener(VolleyError error) {

                    }
                });


                /**
                 *
                 */


                break;


            case 1:
                MusicRecommendViewHolder musicRecommendViewHolder = (MusicRecommendViewHolder) holder;
                Picasso.with(context).load(data.getModule().get(3).getPicurl()).into(musicRecommendViewHolder.iv);


                /**
                 *
                 * 响应点击事件,准备拼接ID
                 *
                 */

                MusicRecommendAdapter doubleItemAdapter = new MusicRecommendAdapter(context);
                doubleItemAdapter.setMyClick(new MyClick() {
                    @Override
                    public void MyClick(int position) {

                    }

                    @Override
                    public void MyClickUrl(String url, int position) {

                        /**
                         * 加入listID拼接
                         */
                        String final_url=PARTA+url+PARTC;
                        NetHelper.MyRequest(final_url, RecommendMusicListBean.class, new NetListener<RecommendMusicListBean>() {
                            @Override
                            public void successListener(RecommendMusicListBean response) {


                                FragmentManager fragmentManager=appCompatActivity.getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                                fragmentTransaction.setCustomAnimations(R.anim.myanim, R.anim.myanim2);
                                fragmentTransaction.add(R.id.fra, new FragmentRecommendMusicList(appCompatActivity,response), "fra_recommend_musiclist");
                                fragmentTransaction.addToBackStack("fra_recommend_musiclist");
                                fragmentTransaction.commit();



                            }

                            @Override
                            public void errorListener(VolleyError error) {

                            }
                        });






                    }
                });
                doubleItemAdapter.setData(data.getResult().getDiy());
                musicRecommendViewHolder.rv.setAdapter(doubleItemAdapter);
                musicRecommendViewHolder.rv.setLayoutManager(new GridLayoutManager(context, 3));


                break;

            case 2:
                NewMusicViewHolder newMusicViewHolder = (NewMusicViewHolder) holder;
                Picasso.with(context).load(data.getModule().get(5).getPicurl()).into(newMusicViewHolder.iv);

                NewDiskAdapter newDiskAdapter = new NewDiskAdapter(context);
                newDiskAdapter.setData(data.getResult().getMix_1());
                newMusicViewHolder.rv.setAdapter(newDiskAdapter);
                newMusicViewHolder.rv.setLayoutManager(new GridLayoutManager(context, 3));


                break;

            case 3:
                HotSellViewHolder hotSellViewHolder = (HotSellViewHolder) holder;
                Picasso.with(context).load(data.getModule().get(6).getPicurl()).into(hotSellViewHolder.iv);

                HotSellAdapter hotSellAdapter = new HotSellAdapter(context);
                hotSellAdapter.setData(data.getResult().getMix_22());
                hotSellViewHolder.rv.setAdapter(hotSellAdapter);
                hotSellViewHolder.rv.setLayoutManager(new GridLayoutManager(context, 3));

                break;

            case 4:
                ADViewHolder adViewHolder = (ADViewHolder) holder;
                Picasso.with(context).load(data.getResult().getAd_small().getResult().get(0).getPic()).into(adViewHolder.iv);
                break;


            case 5:
                OriMusicViewHolder oriMusicViewHolder = (OriMusicViewHolder) holder;
                Picasso.with(context).load(data.getModule().get(10).getPicurl()).into(oriMusicViewHolder.iv);

                OriMusicAdapter oriMusicAdapter = new OriMusicAdapter(context);
                oriMusicAdapter.setData(data.getResult().getMix_9());
                oriMusicViewHolder.rv.setAdapter(oriMusicAdapter);
                oriMusicViewHolder.rv.setLayoutManager(new GridLayoutManager(context, 3));

                break;


            case 6:
                HotMVViewHolder hotMVViewHolder = (HotMVViewHolder) holder;
                Picasso.with(context).load(data.getModule().get(11).getPicurl()).into(hotMVViewHolder.iv);


                HotMVAdapter hotMVAdapter = new HotMVAdapter(context);
                hotMVAdapter.setData(data.getResult().getMix_5());
                hotMVViewHolder.rv.setAdapter(hotMVAdapter);
                hotMVViewHolder.rv.setLayoutManager(new GridLayoutManager(context, 3));


                break;


            case 7:
                LeBoViewHolder leBoViewHolder = (LeBoViewHolder) holder;
                Picasso.with(context).load(data.getModule().get(12).getPicurl()).into(leBoViewHolder.iv);

                LeBoAdapter leBoAdapter = new LeBoAdapter(context);
                leBoAdapter.setData(data.getResult().getRadio());
                leBoViewHolder.rv.setAdapter(leBoAdapter);
                leBoViewHolder.rv.setLayoutManager(new GridLayoutManager(context, 3));


                break;
            case 8:

                ColumnViewHolder columnViewHolder = (ColumnViewHolder) holder;
                Picasso.with(context).load(data.getModule().get(13).getPicurl()).into(columnViewHolder.iv);

                ColumnAdapter columnAdapter = new ColumnAdapter(context);
                columnAdapter.setData(data.getResult().getMod_7());
                columnViewHolder.rv.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
                columnViewHolder.rv.setAdapter(columnAdapter);
                columnViewHolder.rv.setLayoutManager(new LinearLayoutManager(context));


                break;

        }


    }

    private void initRanPics(ArrayList<String> data_pics, Banner banner) {

        // 设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        // 设置图片加载器
        banner.setImageLoader(new GlideImageloader());
        // 设置图片集合
        banner.setImages(data_pics);
        // 设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        // 设置标题集合(当banner样式有显示title时)
        //banner.setBannerTitles(Arrays.asList("title1","title2","title3"));
        // 设置自动轮播 默认为true
        banner.isAutoPlay(true);
        // 设置轮播时间
        banner.setDelayTime(3500);
        // 设置指示器位置 (当banner模式中有指示器时)
        banner.setIndicatorGravity(BannerConfig.CENTER);
        // banner设置方法全部调用完毕时最后调用
        banner.start();


    }

    @Override
    public int getItemCount() {
        return 9;
    }


    class BlankViewHolder extends RecyclerView.ViewHolder {

        private Banner banner;
        private ImageView iv_geshou;


        public BlankViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
            iv_geshou = (ImageView) itemView.findViewById(R.id.iv_geshou);
        }
    }


    class MusicRecommendViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private RecyclerView rv;


        public MusicRecommendViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_recommend_gedantuijian);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_recommend_gedantuijian);
        }
    }


    class NewMusicViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private RecyclerView rv;

        public NewMusicViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_recommend_xindieshangjia);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_recommend_xindieshangjia);
        }
    }

    class HotSellViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private RecyclerView rv;

        public HotSellViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_recommend_rexiaozhuanji);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_recommend_rexiaozhuanji);
        }
    }

    class ADViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;

        public ADViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_recommend_ad);

        }
    }

    class OriMusicViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private RecyclerView rv;

        public OriMusicViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_recommend_yuanchuangyinyue);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_recommend_yuanchuangyinyue);
        }
    }


    class HotMVViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private RecyclerView rv;

        public HotMVViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_recommend_zuiremvtuijian);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_recommend_zuiremvtuijian);
        }
    }

    class LeBoViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private RecyclerView rv;

        public LeBoViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_recommend_lebojiemu);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_recommend_lebojiemu);
        }
    }


    class ColumnViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private RecyclerView rv;

        public ColumnViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_recommend_zhuanlan);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_recommend_zhuanlan);
        }
    }


}
