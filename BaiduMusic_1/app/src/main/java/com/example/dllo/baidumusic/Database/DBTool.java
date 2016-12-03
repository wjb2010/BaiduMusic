package com.example.dllo.baidumusic.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dllo.baidumusic.Bean.MyMusicList.MyMusicListBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/1.
 */

public class DBTool {
    private SQLiteDatabase db;
    private DB_Helper db_helper;

    public DBTool(Context context) {
       db_helper=new DB_Helper(context,"LocalMusicPlayList.db",null,1);
        db=db_helper.getWritableDatabase();
    }

    public void Insert(MyMusicListBean myMusicListBean){


        ContentValues contentValues=new ContentValues();
        contentValues.put(DBValues.MUSICNAME, myMusicListBean.getMusicName());
        contentValues.put(DBValues.SINGER, myMusicListBean.getSinger());
        contentValues.put(DBValues.SONGURL, myMusicListBean.getSong_url());
        contentValues.put(DBValues.LRCURL, myMusicListBean.getLrc_url());
        contentValues.put(DBValues.MUSICID, myMusicListBean.getMusicID());

        db.insert(DBValues.TABLE_NAME,null,contentValues);


    }



    public void Delete(MyMusicListBean myMusicListBean){

        db.delete(DBValues.TABLE_NAME,DBValues.MUSICID+"=?",new String[]{myMusicListBean.getMusicID()});

    }



    public ArrayList<MyMusicListBean> QueryAll(){
        Cursor cursor=db.query("select * from "+DBValues.TABLE_NAME,null,null,null,null,null,null);
        ArrayList<MyMusicListBean> myMusicListBeen =new ArrayList<>();
        //进行判断
        if (cursor!=null){

            cursor.moveToFirst();

            do {
                String musicname=cursor.getString(cursor.getColumnIndex(DBValues.MUSICNAME));
                String singer=cursor.getString(cursor.getColumnIndex(DBValues.SINGER));
                String song_url=cursor.getString(cursor.getColumnIndex(DBValues.SONGURL));
                String lrc_url=cursor.getString(cursor.getColumnIndex(DBValues.LRCURL));
                String musicid=cursor.getString(cursor.getColumnIndex(DBValues.MUSICID));
                MyMusicListBean myMusicListBean =new MyMusicListBean();
                myMusicListBean.setMusicName(musicname);
                myMusicListBean.setSinger(singer);
                myMusicListBean.setSong_url(song_url);
                myMusicListBean.setLrc_url(lrc_url);
                myMusicListBean.setMusicID(musicid);
                myMusicListBeen.add(myMusicListBean);
            }while (cursor.moveToNext());
            //使用游标后需要关闭游标
            cursor.close();
        }



        return myMusicListBeen;
    }

}
