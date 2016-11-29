package com.example.dllo.baidumusic.Service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.dllo.baidumusic.Bean.LocalMusicBean;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dllo on 16/11/25.
 */

public class MusicControlService extends Service {


    MyBinder myBinder=new MyBinder();

    private ArrayList<LocalMusicBean> musicData;
    private int position = 0;//指定播放的歌曲 默认先播放第一首歌
    private MediaPlayer mPlayer;
    private Intent mServiceIntent;


    /**
     * 第一个服务的生命周期,初始化操作
     */
    @Override
    public void onCreate() {
        super.onCreate();
        musicData=new ArrayList<>();
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
                //获取音乐类型 0 代表不是音乐
                int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));
                //获取音乐的时长
                Long duringTime = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));

                if (isMusic != 0 && duringTime / 60 * 1000 > 1) {
                    LocalMusicBean bean = new LocalMusicBean(title, singer, url);
                    musicData.add(bean);
                }


            } while (cursor.moveToNext());

        }
        //关闭游标
        cursor.close();

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
        * 播放下一曲
        */
       public void playNext(){
           position++;
           if (position > musicData.size()-1){
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
               position = musicData.size() - 1;
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

    private void play() {

        try {
            if (!mPlayer.isPlaying()){
                mPlayer.setDataSource(musicData.get(position).getUrl());
                mPlayer.prepare();
                mPlayer.start();
                mServiceIntent.putExtra("key",musicData.get(position));
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
