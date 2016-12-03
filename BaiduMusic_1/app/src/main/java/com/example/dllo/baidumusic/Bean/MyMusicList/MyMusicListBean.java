package com.example.dllo.baidumusic.Bean.MyMusicList;

/**
 * Created by dllo on 16/11/30.
 */

public class MyMusicListBean {
    public MyMusicListBean(String musicName, String singer, String song_url, String lrc_url, String musicID) {
        this.musicName = musicName;
        this.singer = singer;
        this.song_url = song_url;
        this.lrc_url = lrc_url;
        this.musicID = musicID;
    }

    public MyMusicListBean() {
    }

    private String musicName;
    private String singer;
    private String song_url;
    private String lrc_url;
    private String musicID;

    public String getMusicID() {
        return musicID;
    }

    public void setMusicID(String musicID) {
        this.musicID = musicID;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    public String getLrc_url() {
        return lrc_url;
    }

    public void setLrc_url(String lrc_url) {
        this.lrc_url = lrc_url;
    }
}
