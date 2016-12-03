package com.example.dllo.baidumusic.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.example.dllo.baidumusic.Bean.TopTenItemBean;
import com.example.dllo.baidumusic.Interface.MyClick;
import com.example.dllo.baidumusic.R;
import com.example.dllo.baidumusic.VolleyPackage.NetHelper;
import com.example.dllo.baidumusic.VolleyPackage.NetListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/12/2.
 */

public class TopTenItemAdapter extends RecyclerView.Adapter<TopTenItemAdapter.TopTenItemViewHolder>{

    private TopTenItemBean data;
    private Context context;
    private MyClick myClick;
    public static final String PARTA="http://tingapi.ting.baidu.com/v1/restserver/ting?from=webapp_music&method=baidu.ting.song.play&format=json&callback=&songid=";
    public static final String PARTC="&_=1413017198449";

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    public void setData(TopTenItemBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public TopTenItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public TopTenItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        TopTenItemViewHolder viewHolder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.item_topten,parent,false);
        viewHolder=new TopTenItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TopTenItemViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RequestQueue requestQueue= Volley.newRequestQueue(context);
                StringRequest stringRequest=new StringRequest(PARTA + data.getSong_list().get(position).getSong_id() + PARTC, new Response.Listener<String>() {
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


//                NetHelper.MyRequest(PARTA + data.getSong_list().get(position).getSong_id() + PARTC, PlayNetMusicBean.class, new NetListener<PlayNetMusicBean>() {
//                    @Override
//                    public void successListener(PlayNetMusicBean response) {
//
//                        Log.d("TopTenItemAdapter", "response:" + response);
//
//
//                        //myClick.MyClickUrl(response.getBitrate().getFile_link(),position) ;
//
//                    }
//
//                    @Override
//                    public void errorListener(VolleyError error) {
//
//                    }
//                });


            }
        });

        holder.tv_up.setText(data.getSong_list().get(position).getTitle());
        holder.tv_down.setText(data.getSong_list().get(position).getAuthor());
        Picasso.with(context).load(data.getSong_list().get(position).getPic_small()).into(holder.iv);





    }

    @Override
    public int getItemCount() {
        return data.getSong_list().size();
    }


    class TopTenItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv_up,tv_down;




        public TopTenItemViewHolder(View itemView) {
            super(itemView);

            iv = (ImageView) itemView.findViewById(R.id.iv_item_topten);
            tv_up = (TextView) itemView.findViewById(R.id.tv_item_topten_up);
            tv_down = (TextView) itemView.findViewById(R.id.tv_item_topten_down);

        }
    }








}
