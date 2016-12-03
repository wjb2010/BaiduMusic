package com.example.dllo.baidumusic.Adapter.RecommendAdpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.baidumusic.Bean.TopTenBean;
import com.example.dllo.baidumusic.Bean.VideoLeftBean;
import com.example.dllo.baidumusic.Interface.MyClick;
import com.example.dllo.baidumusic.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/29.
 */

public class TopTenAdapter extends RecyclerView.Adapter<TopTenAdapter.MusicListViewHolder> {

    private TopTenBean data;
    private Context context;
    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    public TopTenAdapter(Context context) {
        this.context = context;
    }

    public void setData(TopTenBean data) {

        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MusicListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MusicListViewHolder musicListViewHolder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.item_top_ten,parent,false);
        musicListViewHolder=new MusicListViewHolder(view);


        return musicListViewHolder;
    }

    @Override
    public void onBindViewHolder(MusicListViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick.MyClick(position);
            }
        });

        holder.tv1.setText(data.getContent().get(position).getContent().get(0).getTitle());
        holder.tv2.setText(data.getContent().get(position).getContent().get(1).getTitle());
        holder.tv3.setText(data.getContent().get(position).getContent().get(2).getTitle());
        holder.tv4.setText(data.getContent().get(position).getContent().get(3).getTitle());

        Picasso.with(context).load(data.getContent().get(position).getPic_s192()).into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return data.getContent().size();
    }

    class MusicListViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv1,tv2,tv3,tv4;

        public MusicListViewHolder(View itemView) {
            super(itemView);

            iv = (ImageView) itemView.findViewById(R.id.iv_item_vertical);
            tv1 = (TextView) itemView.findViewById(R.id.tv_item_vertical_one);
            tv2 = (TextView) itemView.findViewById(R.id.tv_item_vertical_two);
            tv3 = (TextView) itemView.findViewById(R.id.tv_item_vertical_three);
            tv4 = (TextView) itemView.findViewById(R.id.tv_item_vertical_four);
        }
    }

}
