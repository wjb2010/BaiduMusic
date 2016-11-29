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

public class ColumnAdapter extends RecyclerView.Adapter<ColumnAdapter.VerticalItemViewHolder>{

    private RecommendBean.ResultBeanXXXXXXXXXXXXX.Mod7Bean data;
    private Context context;

    public void setData(RecommendBean.ResultBeanXXXXXXXXXXXXX.Mod7Bean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ColumnAdapter(Context context) {
        this.context = context;
    }

    @Override
    public VerticalItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        VerticalItemViewHolder verticalItemViewHolder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.item_recommend_item_vertical,parent,false);
        verticalItemViewHolder=new VerticalItemViewHolder(view);
        return verticalItemViewHolder;
    }

    @Override
    public void onBindViewHolder(VerticalItemViewHolder holder, int position) {

        holder.tv_up.setText(data.getResult().get(position).getTitle());
        holder.tv_down.setText(data.getResult().get(position).getDesc());
        Picasso.with(context).load(data.getResult().get(position).getPic()).into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return 6;
    }


    class VerticalItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv_up;
        private TextView tv_down;

        public VerticalItemViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_item_vertical);
            tv_up = (TextView) itemView.findViewById(R.id.tv_item_vertical_one);
            tv_down = (TextView) itemView.findViewById(R.id.tv_item_vertical_two);

        }
    }

}
