package com.example.dllo.baidumusic.Service;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.dllo.baidumusic.Bean.LocalMusicBean;
import com.example.dllo.baidumusic.Bean.MyMusicList.MyMusicListBean;
import com.example.dllo.baidumusic.Database.DBTool;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dllo on 16/11/25.
 */

public class MusicControlService extends Service {

    private DBTool dbtool;
    MyBinder myBinder=new MyBinder();

    private ArrayList<LocalMusicBean> old_musicData;
    private ArrayList<MyMusicListBean> localMusicData=new ArrayList<>();
    private int position = 0;//指定播放的歌曲 默认先播放第一首歌
    private static MediaPlayer mPlayer;
    private Intent mServiceIntent;


    /**
     * 第一个服务的生命周期,初始化操作
     */
    @Override
    public void onCreate() {
        super.onCreate();
        old_musicData=new ArrayList<>();
        mPlayer=new MediaPlayer();
        mServiceIntent=new Intent("MY_MUSIC_CONTROL_BR");
        /**
         * 初始化本地音乐数据
         */
        initMusicData();

    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return myBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        mPlayer.stop();
        return super.onUnbind(intent);
    }



    private void initMusicData() {
        dbtool=new DBTool(this);
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                //获取音乐的名字
                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                //歌手名字
                String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                //获取歌曲的url
                String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                Log.d("MusicControlService", url);
                //获取音乐类型 0 代表不是音乐
                int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));
                //获取音乐的时长
                Long duringTime = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));


                if (isMusic != 0 && duringTime / 60 * 1000 > 1) {
                    LocalMusicBean bean = new LocalMusicBean(title, singer, url);
                    //MyMusicListBean bean=new MyMusicListBean(title,singer,url,"","");

                    old_musicData.add(bean);
                   // dbtool.Insert(bean);
                }


            } while (cursor.moveToNext());


        }
        Log.d("MusicControlService", "已读取音乐资料");
        //关闭游标
        cursor.close();

        /**
         * 将详细列表写入数据库
         *
         */




    }




   public class MyBinder extends Binder{
       /**
        * 播放完成监听
        */
       public void playNextWhenComplete(){
//
//           mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//               @Override
//               public void onCompletion(MediaPlayer mp) {
//                   mPlayer.setOnCompletionListener(null);
//                   myBinder.playNext();
//               }
//           });

       }

       /**
        * 播放音乐方法
        */
       public void playMusic(){
           play();
       }

       /**
        * 播放网络URL
        */
       public void playNetMusic(String url){
           playNetMusicM(url);
       }

       /**
        * 播放下一曲
        */
       public void playNext(){
           position++;
           if (position > old_musicData.size()-1){
               position = 0;
           }
           //重置播放器
           mPlayer.reset();


//           mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//               @Override
//               public void onCompletion(MediaPlayer mp) {
//                   mp.setOnCompletionListener(null);
//                   playNext();
//
//               }
//           });

           play();
       }

       /**
        * 播放上一曲
        */
       public void playLast(){
           position--;
           if (position < 0){
               position = old_musicData.size() - 1;
           }
           mPlayer.reset();
           play();
       }

       /**
        * 返回歌曲最大时长
        * @return
        */
       public int Max(){
           return mPlayer.getDuration();
       }


       /**
        * 即时返回歌曲进度
        * @return
        */
       public int progress(){
           if (mPlayer!=null) {
               return mPlayer.getCurrentPosition();
           }else {

               return 50;
           }
       }

       /**
        * 判断是否在播放
        * @return
        */
       public boolean isPlaying(){
           return mPlayer.isPlaying();
       }


       /**
        * 暂停播放
        */
       public boolean pause(){
           if (mPlayer.isPlaying()) {

               mPlayer.pause();
               return false;
           }else {
               mPlayer.start();
               return true;
           }



       }



    }

    private void playNetMusicM(String url) {

        try {
            if (!mPlayer.isPlaying()){
//                //mPlayer=new MediaPlayer();
//                Log.d("MusicControlService", "播放网络歌曲1");
//                mPlayer.release();
//
//                mPlayer.setDataSource("http://sc1.111ttt.com/2016/1/11/16/204161633478.mp3");
//                mPlayer.prepareAsync();
//                mPlayer.start();

                mPlayer.setDataSource(url);
                mPlayer.prepare();
                mPlayer.start();


            } else {
                Log.d("MusicControlService", "播放网络歌曲2");
                mPlayer.stop();
                mPlayer.reset();
                mPlayer.setDataSource(url);
                mPlayer.prepare();
                mPlayer.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }catch (IllegalStateException e){
            mPlayer=null;
           mPlayer=new MediaPlayer();

        }

    }




    private void play() {

        try {
            if (!mPlayer.isPlaying()){
                mPlayer.setDataSource(old_musicData.get(position).getUrl());
                mPlayer.prepare();
                mPlayer.start();
                mServiceIntent.putExtra("key",old_musicData.get(position));
                sendBroadcast(mServiceIntent);
            }
            else {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }catch (IllegalStateException e){
            mPlayer=null;
            mPlayer=new MediaPlayer();

//            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    mPlayer.setOnCompletionListener(null);
//                    myBinder.playNext();
//                }
//            });


        }

    }


}
