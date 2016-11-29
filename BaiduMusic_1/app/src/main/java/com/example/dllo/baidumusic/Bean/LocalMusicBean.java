package com.example.dllo.baidumusic.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dllo on 16/11/25.
 */

public class LocalMusicBean implements Parcelable {
    private String title,singer,url;

    public LocalMusicBean() {
    }

    public LocalMusicBean(String title, String singer, String url) {
        this.title = title;
        this.singer = singer;
        this.url = url;
    }

    protected LocalMusicBean(Parcel in) {
        title = in.readString();
        singer = in.readString();
        url = in.readString();
    }

    public static final Creator<LocalMusicBean> CREATOR = new Creator<LocalMusicBean>() {
        @Override
        public LocalMusicBean createFromParcel(Parcel in) {
            return new LocalMusicBean(in);
        }

        @Override
        public LocalMusicBean[] newArray(int size) {
            return new LocalMusicBean[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(singer);
        dest.writeString(url);
    }
}
