package com.example.dllo.baidumusic.Activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.baidumusic.Adapter.MainViewPagerAdapter;
import com.example.dllo.baidumusic.Bean.LocalMusicBean;
import com.example.dllo.baidumusic.Fragment.FragmentDynamic;
import com.example.dllo.baidumusic.Fragment.FragmentMine;
import com.example.dllo.baidumusic.Fragment.SideFragment.FragmentMore;
import com.example.dllo.baidumusic.Fragment.FragmentMusic;
import com.example.dllo.baidumusic.Fragment.SideFragment.FragmentMusicFromDown;
import com.example.dllo.baidumusic.Fragment.SideFragment.FragmentMusicListFromRightDown;
import com.example.dllo.baidumusic.R;
import com.example.dllo.baidumusic.Service.MusicControlService;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> data;
    private TextView tv_marquee;
    private MyDestroySideFragmentBR myBR;
    private MyMusicControlBR myMusicBR;
    private ImageView iv_main_call_side_fragment;
    private RelativeLayout rl_down_music;
    private ServiceConnection musicSerCon;
    private MusicControlService.MyBinder musicCtrlBinder;
    private Intent connectMusicControlIntent;
    private ProgressBar pb_music_down;

    private ImageView btn_music_control_play_pause;
    private ImageView btn_music_control_next;
    private boolean flag_this_song = false;

    private TextView tv_music_name_marquee;
    private TextView tv_music_author;
    private Thread t_progressBar;
    private boolean pause=false;
    private boolean check=true;
    private boolean pause_or_play;

    private ImageView iv_btn_music_list_from_rightdown;


    @Override
    protected int setLayout() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        tab=bindView(R.id.tab_main);
        vp=bindView(R.id.vp_main);
        rl_down_music=bindView(R.id.rl_down_music);
        iv_main_call_side_fragment=bindView(R.id.iv_main_call_side_fragment);
        tv_marquee=bindView(R.id.tv_music_name_marquee);
        pb_music_down=bindView(R.id.pb_music_down);
        btn_music_control_play_pause=bindView(R.id.btn_music_control_play_pause);
        btn_music_control_next=bindView(R.id.btn_music_control_next);
        tv_music_name_marquee=bindView(R.id.tv_music_name_marquee);
        tv_music_author=bindView(R.id.tv_music_author);
        iv_btn_music_list_from_rightdown=bindView(R.id.iv_btn_music_list_from_rightdown);



        /**
         * 建立服务Intent
         * 建立服务连接
         */
        connectMusicControlIntent=new Intent(this,MusicControlService.class);
        musicSerCon=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                musicCtrlBinder= (MusicControlService.MyBinder) service;

                /**
                 * 初次设定最大时长
                 */
                if (musicCtrlBinder != null) {
                    //播放的时候我们的最大值就是第一首歌曲的时长
                    pb_music_down.setMax(musicCtrlBinder.Max());
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        bindService(connectMusicControlIntent,musicSerCon,BIND_AUTO_CREATE);

        initMusicControlBR();
        initDestroyFragmentBR();


    }

    private void initMusicControlBR() {

        myMusicBR = new MyMusicControlBR();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("MY_MUSIC_CONTROL_BR");
        registerReceiver(myMusicBR, intentFilter);

    }

    private void initDestroyFragmentBR() {
        myBR=new MyDestroySideFragmentBR();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("MyDestroySideFragmentBR");
        registerReceiver(myBR,intentFilter);
    }

    @Override
    protected void initData() {



        data=new ArrayList<>();
        data.add(new FragmentMine());
        data.add(new FragmentMusic());
        data.add(new FragmentDynamic());
        data.add(new FragmentMine());

        MainViewPagerAdapter mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.setData(data);
        tab.setTabTextColors(Color.argb(220,162,217,239),Color.WHITE);
        tab.setSelectedTabIndicatorColor(Color.argb(00,00,00,00));
        vp.setAdapter(mainViewPagerAdapter);
        tab.setupWithViewPager(vp);
        tv_marquee.setFocusable(true);
        tv_marquee.setSelected(true);

        /**
         * 下部音乐控制器向上弹出
         */
        rl_down_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (fragmentManager.findFragmentByTag("fra_from_down") == null) {
                    fragmentTransaction.setCustomAnimations(R.anim.myanim_from_down_one, R.anim.myanim_from_down_two);

                    fragmentTransaction.replace(R.id.fra_all_from_down, new FragmentMusicFromDown(), "fra_from_down");

                    fragmentTransaction.commit();

                }

            }
        });


        /**
         * 首页点击右侧弹出界面(更多)
         */
        iv_main_call_side_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                if (fragmentManager.findFragmentByTag("fra1")==null) {
                    fragmentTransaction.setCustomAnimations(R.anim.myanim, R.anim.myanim2);

                    fragmentTransaction.add(R.id.fra, new FragmentMore(), "fra1");

                    fragmentTransaction.commit();

                }
            }
        });


        /**
         * 控制歌单从右下点击弹出
         */
        iv_btn_music_list_from_rightdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                if (fragmentManager.findFragmentByTag("fra_music_list_from_rightdown")==null) {
                    fragmentTransaction.setCustomAnimations(R.anim.myanim_from_down_one, R.anim.myanim_from_down_two);

                    fragmentTransaction.add(R.id.fra, new FragmentMusicListFromRightDown(), "fra_music_list_from_rightdown");

                    fragmentTransaction.commit();

                }else {
                    fragmentTransaction.setCustomAnimations(R.anim.myanim_from_down_one, R.anim.myanim_from_down_two);
                    fragmentTransaction.remove(fragmentManager.findFragmentByTag("fra_music_list_from_rightdown"));
                    fragmentTransaction.commit();

                    Toast.makeText(MainActivity.this, "已经存在", Toast.LENGTH_SHORT).show();
                }

            }
        });


        /**
         * 播放.暂停 监听
         */
        btn_music_control_play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!flag_this_song&&!musicCtrlBinder.isPlaying()) {

                    if ( musicCtrlBinder!= null) {
                        musicCtrlBinder.playMusic();
                        musicCtrlBinder.playNextWhenComplete();
                        flag_this_song=true;
                        btn_music_control_play_pause.setImageResource(R.mipmap.bt_minibar_pause_normal);

                    }


                    if (!pause) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                while (check) {
                                    if (musicCtrlBinder != null)

                                        pb_music_down.setProgress(musicCtrlBinder.progress());
                                    pause=false;
                                }

                            }
                        }).start();

                    }





                }else {

                    if (musicCtrlBinder != null) {

                        pause_or_play = musicCtrlBinder.pause();

                        if (!pause_or_play){




                            btn_music_control_play_pause.setImageResource(R.mipmap.bt_minibar_play_normal);


                        }else {

                            btn_music_control_play_pause.setImageResource(R.mipmap.bt_minibar_pause_normal);

                        }

                    }

                }





                Toast.makeText(MainActivity.this, "点击了播放", Toast.LENGTH_SHORT).show();


            }
        });


        /**
         * 下一曲 监听
         */
        btn_music_control_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * 暂停时的下一曲
                 */
                if(flag_this_song&&!musicCtrlBinder.isPlaying()){

                  //  flag_play = true;


                    if (musicCtrlBinder != null) {
                        musicCtrlBinder.playNext();
                        if (musicCtrlBinder.isPlaying()){

                            btn_music_control_play_pause.setImageResource(R.mipmap.bt_minibar_pause_normal);

                        }


                        //flag_this_song=true;
                    }


                }
                //播放时的下一曲
                else {
                    if (musicCtrlBinder != null) {
                        musicCtrlBinder.playNext();
                       // flag_this_song=true;
                        if (musicCtrlBinder.isPlaying()){

                            btn_music_control_play_pause.setImageResource(R.mipmap.bt_minibar_pause_normal);

                        }

                    }



                }



            }
        });




    }

    class MyDestroySideFragmentBR extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {


            //  Toast.makeText(context, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show();

            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentManager.findFragmentByTag(intent.getStringExtra("key")));
            fragmentTransaction.commit();

        }
    }

    class MyMusicControlBR extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {


            if (musicCtrlBinder != null) {

                //取值
                LocalMusicBean bean = intent.getParcelableExtra("key");
                tv_music_name_marquee.setText(bean.getTitle());
                tv_music_author.setText(bean.getSinger());
                //设置新歌曲的时长
                pb_music_down.setMax(musicCtrlBinder.Max());
            }


            }


        }

    @Override
    protected void onDestroy() {

        if (musicSerCon!=null) {
            unbindService(musicSerCon);
        }

        unregisterReceiver(myBR);
        unregisterReceiver(myMusicBR);
        super.onDestroy();
    }

}
