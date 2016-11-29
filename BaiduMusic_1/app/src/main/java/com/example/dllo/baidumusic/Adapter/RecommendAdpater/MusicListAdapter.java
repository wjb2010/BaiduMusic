package com.example.dllo.baidumusic.Adapter.RecommendAdpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.baidumusic.Bean.MusicListBean;
import com.example.dllo.baidumusic.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/29.
 */

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MusicListViewHolder> {

    private MusicListBean data;
    private Context context;


    public MusicListAdapter(Context context) {
        this.context = context;
    }

    public void setData(MusicListBean data) {

        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MusicListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MusicListViewHolder musicListViewHolder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.item_recommend_item_single,parent,false);
        musicListViewHolder=new MusicListViewHolder(view);


        return musicListViewHolder;
    }

    @Override
    public void onBindViewHolder(MusicListViewHolder holder, int position) {

        holder.tv.setText(data.getContent().get(position).getTitle());
        Picasso.with(context).load(data.getContent().get(position).getPic_w300()).into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return data.getContent().size();
    }

    class MusicListViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv;

        public MusicListViewHolder(View itemView) {
            super(itemView);

            iv = (ImageView) itemView.findViewById(R.id.iv_item_single);
            tv = (TextView) itemView.findViewById(R.id.tv_item_single);
        }
    }

}
