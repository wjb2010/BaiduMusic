package com.example.dllo.baidumusic.Adapter.RecommendAdpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.baidumusic.Bean.RecommendBean;
import com.example.dllo.baidumusic.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/24.
 */

public class MusicRecommendAdapter extends RecyclerView.Adapter<MusicRecommendAdapter.DoubleItemViewHolder>{

    private RecommendBean.ResultBeanXXXXXXXXXXXXX.DiyBean data;
    private Context context;

    public void setData(RecommendBean.ResultBeanXXXXXXXXXXXXX.DiyBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public MusicRecommendAdapter(Context context) {
        this.context = context;
    }

    @Override
    public DoubleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DoubleItemViewHolder doubleItemViewHolder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.item_recommend_item_single,parent,false);
        doubleItemViewHolder=new DoubleItemViewHolder(view);
        return doubleItemViewHolder;
    }

    @Override
    public void onBindViewHolder(DoubleItemViewHolder holder, int position) {

        holder.tv.setText(data.getResult().get(position).getTitle());
        Picasso.with(context).load(data.getResult().get(position).getPic()).into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return 6;
    }


    class DoubleItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv;

        public DoubleItemViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_item_single);
            tv = (TextView) itemView.findViewById(R.id.tv_item_single);

        }
    }

}
