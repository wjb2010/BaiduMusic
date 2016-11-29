package com.example.dllo.baidumusic.Banner;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by dllo on 16/11/24.
 */

public class GlideImageloader extends com.youth.banner.loader.ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
