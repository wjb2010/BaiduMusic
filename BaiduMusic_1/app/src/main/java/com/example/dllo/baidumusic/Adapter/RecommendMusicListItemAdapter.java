package com.example.dllo.baidumusic.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.baidumusic.Bean.PlayNetMusicBean;
import com.example.dllo.baidumusic.Bean.RecommendMusicListBean;
import com.example.dllo.baidumusic.Bean.TopTenItemBean;
import com.example.dllo.baidumusic.Interface.MyClick;
import com.example.dllo.baidumusic.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/12/2.
 */

public class RecommendMusicListItemAdapter extends RecyclerView.Adapter<RecommendMusicListItemAdapter.TopTenItemViewHolder>{

    private RecommendMusicListBean data;
    private Context context;
    private MyClick myClick;
    public static final String PARTA="http://tingapi.ting.baidu.com/v1/restserver/ting?from=webapp_music&method=baidu.ting.song.play&format=json&callback=&songid=";
    public static final String PARTC="&_=1413017198449";

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    public void setData(RecommendMusicListBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public RecommendMusicListItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public TopTenItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        TopTenItemViewHolder viewHolder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.item_recommend_musiclist,parent,false);
        viewHolder=new TopTenItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TopTenItemViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RequestQueue requestQueue= Volley.newRequestQueue(context);
                StringRequest stringRequest=new StringRequest(PARTA + data.getContent().get(position).getSong_id() + PARTC, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Log.d("TopTenItemAdapter", response);
                        PlayNetMusicBean data=new PlayNetMusicBean();
                        Gson gson=new Gson();
                        data= gson.fromJson( response.substring(1, response.length() - 2),PlayNetMusicBean.class);
                        myClick.MyClickUrl(data.getBitrate().getFile_link(),position) ;


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {



                    }
                });
                requestQueue.add(stringRequest);


            }
        });

        holder.tv_up.setText(data.getContent().get(position).getTitle());
        holder.tv_down.setText(data.getContent().get(position).getAuthor());






    }

    @Override
    public int getItemCount() {
        return data.getContent().size();
    }


    class TopTenItemViewHolder extends RecyclerView.ViewHolder{


        private TextView tv_up,tv_down;




        public TopTenItemViewHolder(View itemView) {
            super(itemView);


            tv_up = (TextView) itemView.findViewById(R.id.tv_recommend_musiclist_up);
            tv_down = (TextView) itemView.findViewById(R.id.tv_recommend_musiclist_down);

        }
    }








}
