package com.example.dllo.baidumusic.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.baidumusic.Bean.DynamicBean;
import com.example.dllo.baidumusic.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/24.
 */

public class DynamicOutRecyclerViewAdapter extends RecyclerView.Adapter {

    private Context context;
    private DynamicBean data;


    public void setData(DynamicBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public DynamicOutRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    /**
     * 绑定布局
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == 0) {

            View view0 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_head, parent, false);

            viewHolder = new DynamicHeadViewHolder(view0);

        } else if (viewType == 2) {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_ad, parent, false);

            viewHolder = new DynamicADViewHolder(view2);


        } else {

//            View viewx= LayoutInflater.from(context).inflate(R.layout.item_dynamic_main,parent,false);
//
//            viewHolder=new DynamicHeadViewHolder(viewx);


            //0:单曲 //1:歌单





            if (data.getMsg().get(viewType - 1).getContent()!=null) {

                if (data.getMsg().get(viewType - 1).getContent().getContent_type() == 0) {

                    int pic_count;
                    if (data.getMsg().get(viewType - 1).getPiclist() == null) {
                        pic_count = 0;
                    } else {
                        pic_count = data.getMsg().get(viewType - 1).getPiclist().size();
                    }

                    switch (pic_count) {
                        case 0:
                            View viewx0 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_zero, parent, false);
                            viewHolder = new DynamicMainSingleZeroViewHolder(viewx0);
                            break;
                        case 1:
                            View viewx1 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_one, parent, false);
                            viewHolder = new DynamicMainSingleOneViewHolder(viewx1);
                            break;

                        case 2:
                            View viewx2 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_two, parent, false);
                            viewHolder = new DynamicMainSingleTwoViewHolder(viewx2);
                            break;

                        case 3:
                            View viewx3 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_three, parent, false);
                            viewHolder = new DynamicMainSingleThreeViewHolder(viewx3);
                            break;

                        case 4:
                            View viewx4 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_four, parent, false);
                            viewHolder = new DynamicMainSingleFourViewHolder(viewx4);
                            break;

                        case 5:
                            View viewx5 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_five, parent, false);
                            viewHolder = new DynamicMainSingleFiveViewHolder(viewx5);
                            break;
                        case 6:
                            View viewx6 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_six, parent, false);
                            viewHolder = new DynamicMainSingleSixViewHolder(viewx6);
                            break;
                        default:
                            View viewx7 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_zero, parent, false);
                            viewHolder = new DynamicMainSingleZeroViewHolder(viewx7);

                            break;

                    }


                } else if (data.getMsg().get(viewType - 1).getContent().getContent_type() == 1) {


                    int pic_count;
                    if (data.getMsg().get(viewType - 1).getPiclist() == null) {
                        pic_count = 0;
                    } else {
                        pic_count = data.getMsg().get(viewType - 1).getPiclist().size();
                    }

                    switch (pic_count) {
                        case 0:
                            View viewx0 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_list_zero, parent, false);
                            viewHolder = new DynamicMainListZeroViewHolder(viewx0);
                            break;
                        case 1:
                            View viewx1 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_list_one, parent, false);
                            viewHolder = new DynamicMainListOneViewHolder(viewx1);
                            break;

                        case 2:
                            View viewx2 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_list_two, parent, false);
                            viewHolder = new DynamicMainListTwoViewHolder(viewx2);
                            break;

                        case 3:
                            View viewx3 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_list_three, parent, false);
                            viewHolder = new DynamicMainListThreeViewHolder(viewx3);
                            break;

                        case 4:
                            View viewx4 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_list_four, parent, false);
                            viewHolder = new DynamicMainListFourViewHolder(viewx4);
                            break;

                        case 5:
                            View viewx5 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_list_five, parent, false);
                            viewHolder = new DynamicMainListFiveViewHolder(viewx5);
                            break;
                        case 6:
                            View viewx6 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_list_six, parent, false);
                            viewHolder = new DynamicMainListSixViewHolder(viewx6);
                            break;

                        default:
                            View viewx7 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_zero, parent, false);
                            viewHolder = new DynamicMainListZeroViewHolder(viewx7);

                            break;
                    }

                }
            }else {
                View viewx0 = LayoutInflater.from(context).inflate(R.layout.item_dynamic_main_single_zero, parent, false);
                viewHolder = new DynamicMainSingleZeroViewHolder(viewx0);
            }



        }


        return viewHolder;
    }


    /**
     * 设置数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (position == 0) {

            //头布局

        } else if (position == 2) {

            //广告布局
            DynamicADViewHolder dynamicADViewHolder= (DynamicADViewHolder) holder;
           Picasso.with(context).load("http://ugcpic.qianqian.com/ugcdiy/pic/bos_ugcclient_14800686159249344d4eb3a5313a1999eb92775ab7.jpg@w_750,h_215,o_1").into(dynamicADViewHolder.iv_ad);


        } else {
            //实际内容布局

            if (data.getMsg().get(position-1).getContent()!=null) {
                if (data.getMsg().get(position - 1).getContent().getContent_type() == 0) {


                    position = position - 1;
                    int pic_count;
                    if (data.getMsg().get(position).getPiclist() == null) {
                        pic_count = 0;
                    } else {
                        pic_count = data.getMsg().get(position).getPiclist().size();
                    }


                    switch (pic_count) {
                        case 0:


                            DynamicMainSingleZeroViewHolder dynamicMainSingleZeroViewHolder = (DynamicMainSingleZeroViewHolder) holder;
                            /**
                             * 加载用户图片和歌曲图片
                             */
                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainSingleZeroViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainSingleZeroViewHolder.music_photo);


                            dynamicMainSingleZeroViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainSingleZeroViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            dynamicMainSingleZeroViewHolder.content.setText(data.getMsg().get(position).getMsg());


                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainSingleZeroViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainSingleZeroViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainSingleZeroViewHolder.song_name.setText(data.getMsg().get(position).getContent().getTitle());
                            dynamicMainSingleZeroViewHolder.singer.setText(data.getMsg().get(position).getContent().getArtist_name());

                            dynamicMainSingleZeroViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainSingleZeroViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainSingleZeroViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");


                            break;


                        case 1:

                            DynamicMainSingleOneViewHolder dynamicMainSingleOneViewHolder = (DynamicMainSingleOneViewHolder) holder;
                            dynamicMainSingleOneViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainSingleOneViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            dynamicMainSingleOneViewHolder.content.setText(data.getMsg().get(position).getMsg());


                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainSingleOneViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainSingleOneViewHolder.music_photo);

                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainSingleOneViewHolder.iv_wall_one_one);


                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainSingleOneViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainSingleOneViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainSingleOneViewHolder.song_name.setText(data.getMsg().get(position).getContent().getTitle());
                            dynamicMainSingleOneViewHolder.singer.setText(data.getMsg().get(position).getContent().getArtist_name());

                            dynamicMainSingleOneViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainSingleOneViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainSingleOneViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");

                            break;


                        case 2:

                            DynamicMainSingleTwoViewHolder dynamicMainSingleTwoViewHolder = (DynamicMainSingleTwoViewHolder) holder;
                            dynamicMainSingleTwoViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());

                            dynamicMainSingleTwoViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainSingleTwoViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainSingleTwoViewHolder.music_photo);

                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainSingleTwoViewHolder.iv_wall_two_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainSingleTwoViewHolder.iv_wall_two_two);


                            dynamicMainSingleTwoViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainSingleTwoViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainSingleTwoViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainSingleTwoViewHolder.song_name.setText(data.getMsg().get(position).getContent().getTitle());
                            dynamicMainSingleTwoViewHolder.singer.setText(data.getMsg().get(position).getContent().getArtist_name());

                            dynamicMainSingleTwoViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainSingleTwoViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainSingleTwoViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;


                        case 3:

                            DynamicMainSingleThreeViewHolder dynamicMainSingleThreeViewHolder = (DynamicMainSingleThreeViewHolder) holder;
                            dynamicMainSingleThreeViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());

                            dynamicMainSingleThreeViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainSingleThreeViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainSingleThreeViewHolder.music_photo);

                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainSingleThreeViewHolder.iv_wall_three_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainSingleThreeViewHolder.iv_wall_three_two);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(2).getPic_large()).into(dynamicMainSingleThreeViewHolder.iv_wall_three_three);


                            dynamicMainSingleThreeViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainSingleThreeViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainSingleThreeViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainSingleThreeViewHolder.song_name.setText(data.getMsg().get(position).getContent().getTitle());
                            dynamicMainSingleThreeViewHolder.singer.setText(data.getMsg().get(position).getContent().getArtist_name());

                            dynamicMainSingleThreeViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainSingleThreeViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainSingleThreeViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;


                        case 4:

                            DynamicMainSingleFourViewHolder dynamicMainSingleFourViewHolder = (DynamicMainSingleFourViewHolder) holder;
                            dynamicMainSingleFourViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainSingleFourViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");


                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainSingleFourViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainSingleFourViewHolder.music_photo);

                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainSingleFourViewHolder.iv_wall_four_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainSingleFourViewHolder.iv_wall_four_two);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(2).getPic_large()).into(dynamicMainSingleFourViewHolder.iv_wall_four_three);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(3).getPic_large()).into(dynamicMainSingleFourViewHolder.iv_wall_four_four);


                            dynamicMainSingleFourViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainSingleFourViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainSingleFourViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainSingleFourViewHolder.song_name.setText(data.getMsg().get(position).getContent().getTitle());
                            dynamicMainSingleFourViewHolder.singer.setText(data.getMsg().get(position).getContent().getArtist_name());

                            dynamicMainSingleFourViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainSingleFourViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainSingleFourViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;


                        case 5:

                            DynamicMainSingleFiveViewHolder dynamicMainSingleFiveViewHolder = (DynamicMainSingleFiveViewHolder) holder;
                            dynamicMainSingleFiveViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainSingleFiveViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainSingleFiveViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainSingleFiveViewHolder.music_photo);

                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainSingleFiveViewHolder.iv_wall_five_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainSingleFiveViewHolder.iv_wall_five_two);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(2).getPic_large()).into(dynamicMainSingleFiveViewHolder.iv_wall_five_three);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(3).getPic_large()).into(dynamicMainSingleFiveViewHolder.iv_wall_five_four);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(4).getPic_large()).into(dynamicMainSingleFiveViewHolder.iv_wall_five_five);


                            dynamicMainSingleFiveViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainSingleFiveViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainSingleFiveViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainSingleFiveViewHolder.song_name.setText(data.getMsg().get(position).getContent().getTitle());
                            dynamicMainSingleFiveViewHolder.singer.setText(data.getMsg().get(position).getContent().getArtist_name());

                            dynamicMainSingleFiveViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainSingleFiveViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainSingleFiveViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;

                        case 6:

                            DynamicMainSingleSixViewHolder dynamicMainSingleSixViewHolder = (DynamicMainSingleSixViewHolder) holder;
                            dynamicMainSingleSixViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainSingleSixViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainSingleSixViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainSingleSixViewHolder.music_photo);


                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainSingleSixViewHolder.iv_wall_six_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainSingleSixViewHolder.iv_wall_six_two);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(2).getPic_large()).into(dynamicMainSingleSixViewHolder.iv_wall_six_three);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(3).getPic_large()).into(dynamicMainSingleSixViewHolder.iv_wall_six_four);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(4).getPic_large()).into(dynamicMainSingleSixViewHolder.iv_wall_six_five);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(5).getPic_large()).into(dynamicMainSingleSixViewHolder.iv_wall_six_six);


                            dynamicMainSingleSixViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainSingleSixViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainSingleSixViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainSingleSixViewHolder.song_name.setText(data.getMsg().get(position).getContent().getTitle());
                            dynamicMainSingleSixViewHolder.singer.setText(data.getMsg().get(position).getContent().getArtist_name());

                            dynamicMainSingleSixViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainSingleSixViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainSingleSixViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;


                    }


                } else {

                    /**
                     * 列表
                     */

                    position = position - 1;

                    int pic_count;
                    if (data.getMsg().get(position).getPiclist() == null) {
                        pic_count = 0;
                    } else {
                        pic_count = data.getMsg().get(position).getPiclist().size();
                    }


                    switch (pic_count) {
                        case 0:


                            DynamicMainListZeroViewHolder dynamicMainListZeroViewHolder = (DynamicMainListZeroViewHolder) holder;
                            dynamicMainListZeroViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainListZeroViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            dynamicMainListZeroViewHolder.content.setText(data.getMsg().get(position).getMsg());


                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainListZeroViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainListZeroViewHolder.music_photo);


                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainListZeroViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainListZeroViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainListZeroViewHolder.musiclist.setText(data.getMsg().get(position).getContent().getTitle().toString());


                            dynamicMainListZeroViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainListZeroViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainListZeroViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");


                            break;


                        case 1:

                            DynamicMainListOneViewHolder dynamicMainListOneViewHolder = (DynamicMainListOneViewHolder) holder;
                            dynamicMainListOneViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainListOneViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");


                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainListOneViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainListOneViewHolder.music_photo);

                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainListOneViewHolder.iv_wall_one_one);


                            dynamicMainListOneViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainListOneViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainListOneViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainListOneViewHolder.musiclist.setText(data.getMsg().get(position).getContent().getTitle().toString());


                            dynamicMainListOneViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainListOneViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainListOneViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");

                            break;


                        case 2:

                            DynamicMainListTwoViewHolder dynamicMainListTwoViewHolder = (DynamicMainListTwoViewHolder) holder;
                            dynamicMainListTwoViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainListTwoViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainListTwoViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainListTwoViewHolder.music_photo);

                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainListTwoViewHolder.iv_wall_two_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainListTwoViewHolder.iv_wall_two_two);


                            dynamicMainListTwoViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainListTwoViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainListTwoViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }


                            dynamicMainListTwoViewHolder.musiclist.setText(data.getMsg().get(position).getContent().getTitle().toString());

                            dynamicMainListTwoViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainListTwoViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainListTwoViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;


                        case 3:

                            DynamicMainListThreeViewHolder dynamicMainListThreeViewHolder = (DynamicMainListThreeViewHolder) holder;
                            dynamicMainListThreeViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainListThreeViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainListThreeViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainListThreeViewHolder.music_photo);


                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainListThreeViewHolder.iv_wall_three_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainListThreeViewHolder.iv_wall_three_two);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(2).getPic_large()).into(dynamicMainListThreeViewHolder.iv_wall_three_three);


                            dynamicMainListThreeViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainListThreeViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainListThreeViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }

                            dynamicMainListThreeViewHolder.musiclist.setText(data.getMsg().get(position).getContent().getTitle().toString());

                            dynamicMainListThreeViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainListThreeViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainListThreeViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;


                        case 4:

                            DynamicMainListFourViewHolder dynamicMainListFourViewHolder = (DynamicMainListFourViewHolder) holder;
                            dynamicMainListFourViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainListFourViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainListFourViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainListFourViewHolder.music_photo);

                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainListFourViewHolder.iv_wall_four_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainListFourViewHolder.iv_wall_four_two);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(2).getPic_large()).into(dynamicMainListFourViewHolder.iv_wall_four_three);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(3).getPic_large()).into(dynamicMainListFourViewHolder.iv_wall_four_four);


                            dynamicMainListFourViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainListFourViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainListFourViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }

                            dynamicMainListFourViewHolder.musiclist.setText(data.getMsg().get(position).getContent().getTitle().toString());

                            dynamicMainListFourViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainListFourViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainListFourViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;


                        case 5:

                            DynamicMainListFiveViewHolder dynamicMainListFiveViewHolder = (DynamicMainListFiveViewHolder) holder;
                            dynamicMainListFiveViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainListFiveViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");


                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainListFiveViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainListFiveViewHolder.music_photo);


                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainListFiveViewHolder.iv_wall_five_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainListFiveViewHolder.iv_wall_five_two);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(2).getPic_large()).into(dynamicMainListFiveViewHolder.iv_wall_five_three);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(3).getPic_large()).into(dynamicMainListFiveViewHolder.iv_wall_five_four);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(4).getPic_large()).into(dynamicMainListFiveViewHolder.iv_wall_five_five);


                            dynamicMainListFiveViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainListFiveViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainListFiveViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }

                            dynamicMainListFiveViewHolder.musiclist.setText(data.getMsg().get(position).getContent().getTitle().toString());

                            dynamicMainListFiveViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainListFiveViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainListFiveViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;

                        case 6:

                            DynamicMainListSixViewHolder dynamicMainListSixViewHolder = (DynamicMainListSixViewHolder) holder;
                            dynamicMainListSixViewHolder.username.setText(data.getMsg().get(position).getAuthor().getUsername());
                            dynamicMainListSixViewHolder.date.setText(data.getMsg().get(position).getCtime() + "");

                            Picasso.with(context).load(data.getMsg().get(position).getAuthor().getUserpic()).into(dynamicMainListSixViewHolder.iv_userpic);
                            Picasso.with(context).load(data.getMsg().get(position).getContent().getPic()).into(dynamicMainListSixViewHolder.music_photo);


                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(0).getPic_large()).into(dynamicMainListSixViewHolder.iv_wall_six_one);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(1).getPic_large()).into(dynamicMainListSixViewHolder.iv_wall_six_two);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(2).getPic_large()).into(dynamicMainListSixViewHolder.iv_wall_six_three);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(3).getPic_large()).into(dynamicMainListSixViewHolder.iv_wall_six_four);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(4).getPic_large()).into(dynamicMainListSixViewHolder.iv_wall_six_five);
                            Picasso.with(context).load(data.getMsg().get(position).getPiclist().get(5).getPic_large()).into(dynamicMainListSixViewHolder.iv_wall_six_six);


                            dynamicMainListSixViewHolder.content.setText(data.getMsg().get(position).getMsg());

                            if (data.getMsg().get(position).getTopic() == null) {
                                dynamicMainListSixViewHolder.topic_title.setText("");
                            } else {
                                dynamicMainListSixViewHolder.topic_title.setText(data.getMsg().get(position).getTopic().getTopic_title());
                            }

                            dynamicMainListSixViewHolder.musiclist.setText(data.getMsg().get(position).getContent().getTitle().toString());

                            dynamicMainListSixViewHolder.zan_count.setText(data.getMsg().get(position).getZan_num() + "");
                            dynamicMainListSixViewHolder.pinglun_count.setText(data.getMsg().get(position).getComment_num() + "");
                            dynamicMainListSixViewHolder.zhuanfa_count.setText(data.getMsg().get(position).getShare_num() + "");
                            break;


                    }


                }


            }else {


            }

        }


    }


    @Override
    public int getItemCount() {
        return data.getMsg().size()+1;
    }


    class DynamicHeadViewHolder extends RecyclerView.ViewHolder {


        public DynamicHeadViewHolder(View itemView) {
            super(itemView);

        }
    }


    class DynamicADViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_ad;


        public DynamicADViewHolder(View itemView) {
            super(itemView);
            iv_ad = (ImageView) itemView.findViewById(R.id.iv_dynamic_ad);

        }
    }

    /**
     * 不带歌单,单曲
     */
    class DynamicMainSingleZeroViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,song_name,singer,zan_count,zhuanfa_count,pinglun_count;

        private ImageView iv_userpic,music_photo;

        public DynamicMainSingleZeroViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.tv_single_zero_username);
            date = (TextView) itemView.findViewById(R.id.tv_single_zero_date);
            content = (TextView) itemView.findViewById(R.id.tv_single_zero_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_single_zero_topictitle);
            song_name = (TextView) itemView.findViewById(R.id.tv_single_zero_songname);
            singer = (TextView) itemView.findViewById(R.id.tv_single_zero_singer);
            zan_count = (TextView) itemView.findViewById(R.id.tv_single_zero_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_single_zero_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_single_zero_pingluncount);




            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_single_zero_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_single_zero_musicphoto);
        }
    }
    class DynamicMainSingleOneViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,song_name,singer,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_one_one;
        public DynamicMainSingleOneViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_single_one_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_single_one_musicphoto);

            iv_wall_one_one = (ImageView) itemView.findViewById(R.id.iv_single_one_one);
            username = (TextView) itemView.findViewById(R.id.tv_single_one_username);
            date = (TextView) itemView.findViewById(R.id.tv_single_one_date);
            content = (TextView) itemView.findViewById(R.id.tv_single_one_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_single_one_topictitle);
            song_name = (TextView) itemView.findViewById(R.id.tv_single_one_songname);
            singer = (TextView) itemView.findViewById(R.id.tv_single_one_singer);
            zan_count = (TextView) itemView.findViewById(R.id.tv_single_one_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_single_one_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_single_one_pingluncount);
        }
    }

    class DynamicMainSingleTwoViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,song_name,singer,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_two_one,iv_wall_two_two;
        public DynamicMainSingleTwoViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_single_two_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_single_two_musicphoto);

            iv_wall_two_one = (ImageView) itemView.findViewById(R.id.iv_single_two_one);
            iv_wall_two_two = (ImageView) itemView.findViewById(R.id.iv_single_two_two);

            username = (TextView) itemView.findViewById(R.id.tv_single_two_username);
            date = (TextView) itemView.findViewById(R.id.tv_single_two_date);
            content = (TextView) itemView.findViewById(R.id.tv_single_two_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_single_two_topictitle);
            song_name = (TextView) itemView.findViewById(R.id.tv_single_two_songname);
            singer = (TextView) itemView.findViewById(R.id.tv_single_two_singer);
            zan_count = (TextView) itemView.findViewById(R.id.tv_single_two_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_single_two_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_single_two_pingluncount);
        }
    }

    class DynamicMainSingleThreeViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,song_name,singer,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_three_one,iv_wall_three_two,iv_wall_three_three;
        public DynamicMainSingleThreeViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_single_three_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_single_three_musicphoto);

            iv_wall_three_one = (ImageView) itemView.findViewById(R.id.iv_single_three_one);
            iv_wall_three_two = (ImageView) itemView.findViewById(R.id.iv_single_three_two);
            iv_wall_three_three = (ImageView) itemView.findViewById(R.id.iv_single_three_three);

            username = (TextView) itemView.findViewById(R.id.tv_single_three_username);
            date = (TextView) itemView.findViewById(R.id.tv_single_three_date);
            content = (TextView) itemView.findViewById(R.id.tv_single_three_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_single_three_topictitle);
            song_name = (TextView) itemView.findViewById(R.id.tv_single_three_songname);
            singer = (TextView) itemView.findViewById(R.id.tv_single_three_singer);
            zan_count = (TextView) itemView.findViewById(R.id.tv_single_three_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_single_three_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_single_three_pingluncount);
        }
    }

    class DynamicMainSingleFourViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,song_name,singer,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_four_one,iv_wall_four_two,iv_wall_four_three,iv_wall_four_four;
        public DynamicMainSingleFourViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_single_four_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_single_four_musicphoto);


            iv_wall_four_one = (ImageView) itemView.findViewById(R.id.iv_single_four_one);
            iv_wall_four_two = (ImageView) itemView.findViewById(R.id.iv_single_four_two);
            iv_wall_four_three = (ImageView) itemView.findViewById(R.id.iv_single_four_three);
            iv_wall_four_four= (ImageView) itemView.findViewById(R.id.iv_single_four_four);



            username = (TextView) itemView.findViewById(R.id.tv_single_four_username);
            date = (TextView) itemView.findViewById(R.id.tv_single_four_date);
            content = (TextView) itemView.findViewById(R.id.tv_single_four_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_single_four_topictitle);
            song_name = (TextView) itemView.findViewById(R.id.tv_single_four_songname);
            singer = (TextView) itemView.findViewById(R.id.tv_single_four_singer);
            zan_count = (TextView) itemView.findViewById(R.id.tv_single_four_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_single_four_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_single_four_pingluncount);

        }
    }

    class DynamicMainSingleFiveViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,song_name,singer,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_five_one,iv_wall_five_two,iv_wall_five_three,iv_wall_five_four,iv_wall_five_five;
        public DynamicMainSingleFiveViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_single_five_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_single_five_musicphoto);

            iv_wall_five_one = (ImageView) itemView.findViewById(R.id.iv_single_five_one);
            iv_wall_five_two = (ImageView) itemView.findViewById(R.id.iv_single_five_two);
            iv_wall_five_three = (ImageView) itemView.findViewById(R.id.iv_single_five_three);
            iv_wall_five_four= (ImageView) itemView.findViewById(R.id.iv_single_five_four);
            iv_wall_five_five=(ImageView) itemView.findViewById(R.id.iv_single_five_five);



            username = (TextView) itemView.findViewById(R.id.tv_single_five_username);
            date = (TextView) itemView.findViewById(R.id.tv_single_five_date);
            content = (TextView) itemView.findViewById(R.id.tv_single_five_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_single_five_topictitle);
            song_name = (TextView) itemView.findViewById(R.id.tv_single_five_songname);
            singer = (TextView) itemView.findViewById(R.id.tv_single_five_singer);
            zan_count = (TextView) itemView.findViewById(R.id.tv_single_five_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_single_five_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_single_five_pingluncount);

        }
    }

    class DynamicMainSingleSixViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,song_name,singer,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_six_one,iv_wall_six_two,iv_wall_six_three,iv_wall_six_four,iv_wall_six_five,iv_wall_six_six;
        public DynamicMainSingleSixViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_single_six_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_single_six_musicphoto);


            iv_wall_six_one = (ImageView) itemView.findViewById(R.id.iv_single_six_one);
            iv_wall_six_two = (ImageView) itemView.findViewById(R.id.iv_single_six_two);
            iv_wall_six_three = (ImageView) itemView.findViewById(R.id.iv_single_six_three);
            iv_wall_six_four= (ImageView) itemView.findViewById(R.id.iv_single_six_four);
            iv_wall_six_five=(ImageView) itemView.findViewById(R.id.iv_single_six_five);
            iv_wall_six_six=(ImageView) itemView.findViewById(R.id.iv_single_six_six);



            username = (TextView) itemView.findViewById(R.id.tv_single_six_username);
            date = (TextView) itemView.findViewById(R.id.tv_single_six_date);
            content = (TextView) itemView.findViewById(R.id.tv_single_six_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_single_six_topictitle);
            song_name = (TextView) itemView.findViewById(R.id.tv_single_six_songname);
            singer = (TextView) itemView.findViewById(R.id.tv_single_six_singer);
            zan_count = (TextView) itemView.findViewById(R.id.tv_single_six_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_single_six_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_single_six_pingluncount);
        }
    }


    /**
     * 带有歌单
     *
     */

    class DynamicMainListZeroViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,musiclist,zan_count,zhuanfa_count,pinglun_count;

        private ImageView iv_userpic,music_photo;


        public DynamicMainListZeroViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.tv_list_zero_username);
            date = (TextView) itemView.findViewById(R.id.tv_list_zero_date);
            content = (TextView) itemView.findViewById(R.id.tv_list_zero_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_list_zero_topictitle);




            musiclist = (TextView) itemView.findViewById(R.id.tv_list_zero_musiclist);
            zan_count = (TextView) itemView.findViewById(R.id.tv_list_zero_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_list_zero_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_list_zero_pingluncount);




           iv_userpic = (ImageView) itemView.findViewById(R.id.iv_list_zero_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_list_zero_musicphoto);
        }
    }
    class DynamicMainListOneViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,musiclist,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_one_one;
        public DynamicMainListOneViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_list_one_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_list_one_musicphoto);

            iv_wall_one_one = (ImageView) itemView.findViewById(R.id.iv_list_one_one);

            username = (TextView) itemView.findViewById(R.id.tv_list_one_username);
            date = (TextView) itemView.findViewById(R.id.tv_list_one_date);
            content = (TextView) itemView.findViewById(R.id.tv_list_one_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_list_one_topictitle);

            musiclist = (TextView) itemView.findViewById(R.id.tv_list_one_musiclist);

            zan_count = (TextView) itemView.findViewById(R.id.tv_list_one_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_list_one_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_list_one_pingluncount);
        }
    }

    class DynamicMainListTwoViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,musiclist,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_two_one,iv_wall_two_two;
        public DynamicMainListTwoViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_list_two_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_list_two_musicphoto);

            iv_wall_two_one = (ImageView) itemView.findViewById(R.id.iv_list_two_one);
            iv_wall_two_two = (ImageView) itemView.findViewById(R.id.iv_list_two_two);

            username = (TextView) itemView.findViewById(R.id.tv_list_two_username);
            date = (TextView) itemView.findViewById(R.id.tv_list_two_date);
            content = (TextView) itemView.findViewById(R.id.tv_list_two_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_list_two_topictitle);

            musiclist = (TextView) itemView.findViewById(R.id.tv_list_two_musiclist);

            zan_count = (TextView) itemView.findViewById(R.id.tv_list_two_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_list_two_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_list_two_pingluncount);
        }
    }

    class DynamicMainListThreeViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,musiclist,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_three_one,iv_wall_three_two,iv_wall_three_three;
        public DynamicMainListThreeViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_list_three_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_list_three_musicphoto);

            iv_wall_three_one = (ImageView) itemView.findViewById(R.id.iv_list_three_one);
            iv_wall_three_two = (ImageView) itemView.findViewById(R.id.iv_list_three_two);
            iv_wall_three_three = (ImageView) itemView.findViewById(R.id.iv_list_three_three);

            username = (TextView) itemView.findViewById(R.id.tv_list_three_username);
            date = (TextView) itemView.findViewById(R.id.tv_list_three_date);
            content = (TextView) itemView.findViewById(R.id.tv_list_three_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_list_three_topictitle);

            musiclist = (TextView) itemView.findViewById(R.id.tv_list_three_musiclist);

            zan_count = (TextView) itemView.findViewById(R.id.tv_list_three_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_list_three_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_list_three_pingluncount);
        }
    }

    class DynamicMainListFourViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,musiclist,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_four_one,iv_wall_four_two,iv_wall_four_three,iv_wall_four_four;
        public DynamicMainListFourViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_list_four_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_list_four_musicphoto);

            username = (TextView) itemView.findViewById(R.id.tv_list_four_username);
            date = (TextView) itemView.findViewById(R.id.tv_list_four_date);
            content = (TextView) itemView.findViewById(R.id.tv_list_four_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_list_four_topictitle);



            iv_wall_four_one = (ImageView) itemView.findViewById(R.id.iv_list_four_one);
            iv_wall_four_two = (ImageView) itemView.findViewById(R.id.iv_list_four_two);
            iv_wall_four_three = (ImageView) itemView.findViewById(R.id.iv_list_four_three);
            iv_wall_four_four= (ImageView) itemView.findViewById(R.id.iv_list_four_four);


            musiclist = (TextView) itemView.findViewById(R.id.tv_list_four_musiclist);
            zan_count = (TextView) itemView.findViewById(R.id.tv_list_four_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_list_four_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_list_four_pingluncount);

        }
    }

    class DynamicMainListFiveViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,musiclist,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_five_one,iv_wall_five_two,iv_wall_five_three,iv_wall_five_four,iv_wall_five_five;
        public DynamicMainListFiveViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_list_five_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_list_five_musicphoto);

            username = (TextView) itemView.findViewById(R.id.tv_list_five_username);
            date = (TextView) itemView.findViewById(R.id.tv_list_five_date);
            content = (TextView) itemView.findViewById(R.id.tv_list_five_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_list_five_topictitle);


            iv_wall_five_one = (ImageView) itemView.findViewById(R.id.iv_list_five_one);
            iv_wall_five_two = (ImageView) itemView.findViewById(R.id.iv_list_five_two);
            iv_wall_five_three = (ImageView) itemView.findViewById(R.id.iv_list_five_three);
            iv_wall_five_four= (ImageView) itemView.findViewById(R.id.iv_list_five_four);
            iv_wall_five_five=(ImageView) itemView.findViewById(R.id.iv_list_five_five);

            musiclist = (TextView) itemView.findViewById(R.id.tv_list_five_musiclist);
            zan_count = (TextView) itemView.findViewById(R.id.tv_list_five_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_list_five_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_list_five_pingluncount);

        }
    }

    class DynamicMainListSixViewHolder extends RecyclerView.ViewHolder {

        private TextView username,date,content,topic_title,musiclist,zan_count,zhuanfa_count,pinglun_count;
        private ImageView iv_userpic,music_photo;
        private ImageView iv_wall_six_one,iv_wall_six_two,iv_wall_six_three,iv_wall_six_four,iv_wall_six_five,iv_wall_six_six;
        public DynamicMainListSixViewHolder(View itemView) {
            super(itemView);
            iv_userpic = (ImageView) itemView.findViewById(R.id.iv_list_six_userpic);
            music_photo = (ImageView) itemView.findViewById(R.id.iv_list_six_musicphoto);


            username = (TextView) itemView.findViewById(R.id.tv_list_six_username);
            date = (TextView) itemView.findViewById(R.id.tv_list_six_date);
            content = (TextView) itemView.findViewById(R.id.tv_list_six_content);
            topic_title = (TextView) itemView.findViewById(R.id.tv_list_six_topictitle);


            iv_wall_six_one = (ImageView) itemView.findViewById(R.id.iv_list_six_one);
            iv_wall_six_two = (ImageView) itemView.findViewById(R.id.iv_list_six_two);
            iv_wall_six_three = (ImageView) itemView.findViewById(R.id.iv_list_six_three);
            iv_wall_six_four= (ImageView) itemView.findViewById(R.id.iv_list_six_four);
            iv_wall_six_five=(ImageView) itemView.findViewById(R.id.iv_list_six_five);
            iv_wall_six_six=(ImageView) itemView.findViewById(R.id.iv_list_six_six);




            musiclist = (TextView) itemView.findViewById(R.id.tv_list_six_musiclist);
            zan_count = (TextView) itemView.findViewById(R.id.tv_list_six_zancount);
            zhuanfa_count = (TextView) itemView.findViewById(R.id.tv_list_six_zhuanfacount);
            pinglun_count = (TextView) itemView.findViewById(R.id.tv_list_six_pingluncount);
        }
    }

}
