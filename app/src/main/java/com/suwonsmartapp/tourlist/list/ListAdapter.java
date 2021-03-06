package com.suwonsmartapp.tourlist.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.suwonsmartapp.tourlist.R;

import java.util.ArrayList;

/**
 * Created by sangmun on 2015-04-01.
 */
public class ListAdapter extends ArrayAdapter<TourList>{
    private static final int sTitleLength = 25;
    private static final int sContentLength = 60;
    private static final int REQ_CODE_PICK_IMAGE = 0;
    private static final String TAG = "ssm_img_main";

    // ViewHolder 패턴
    static class ViewHolder {
        private ImageView mListMainImg;
        private TextView mLIstMainTitle;
        private TextView mListMainDate;
        private TextView mListMainContent;
        private ImageView mListSubImg1;
        private ImageView mListSubImg2;
        private ImageView mListSubImg3;
        private ImageView mListSubImg4;
        private ImageView mListSubImg5;
    }

    // Layout을 가져오기 위한 객체
    private LayoutInflater inflater;

    public ListAdapter(Context context, int resource, ArrayList<TourList> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View view = convertView;

        if (view == null) {
            // View 를 처음 로딩할 때, Data 를 처음 셋팅할 때
            inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_adapter, null);
            ImageView listMainImg = (ImageView) view.findViewById(R.id.iv_list_main_img);
            TextView listMainTitle = (TextView) view.findViewById(R.id.tv_list_main_title);
            TextView listMainDate = (TextView) view.findViewById(R.id.tv_list_main_date);
            TextView listMainContent = (TextView) view.findViewById(R.id.tv_list_main_content);
            ImageView listSubImg1 = (ImageView) view.findViewById(R.id.iv_list_sub_img1);
            ImageView listSubImg2 = (ImageView) view.findViewById(R.id.iv_list_sub_img2);
            ImageView listSubImg3 = (ImageView) view.findViewById(R.id.iv_list_sub_img3);
            ImageView listSubImg4 = (ImageView) view.findViewById(R.id.iv_list_sub_img4);
            ImageView listSubImg5 = (ImageView) view.findViewById(R.id.iv_list_sub_img5);

            holder = new ViewHolder();

            holder.mListMainImg = listMainImg;
            holder.mLIstMainTitle = listMainTitle;
            holder.mListMainDate = listMainDate;
            holder.mListMainContent = listMainContent;
            holder.mListSubImg1 = listSubImg1;
            holder.mListSubImg2 = listSubImg2;
            holder.mListSubImg3 = listSubImg3;
            holder.mListSubImg4 = listSubImg4;
            holder.mListSubImg5 = listSubImg5;

            view.setTag(holder);
        } else {
            // View, Data 재사용
            holder = (ViewHolder) view.getTag();
        }

        TourList tourlist = getItem(position);
        int mainImg = tourlist.getmListMainImg();
        String mainTitle = tourlist.getmLIstMainTitle();
        String mainDate = tourlist.getmListMainDate();
        String mainContent = tourlist.getmListMainContent();
        int subImg1 = tourlist.getmListSubImg1();
        int subImg2 = tourlist.getmListSubImg2();
        int subImg3 = tourlist.getmListSubImg3();
        int subImg4 = tourlist.getmListSubImg4();
        int subImg5 = tourlist.getmListSubImg5();

        if (mainImg == 0) mainImg = R.drawable.no_image;
        holder.mListMainImg.setImageResource(mainImg);

        if (!TextUtils.isEmpty(mainTitle)){
            if(mainTitle.length() > sTitleLength) mainTitle = mainTitle.substring(0, sTitleLength) + "..";
            holder.mLIstMainTitle.setText(mainTitle);
        }
        if (TextUtils.isEmpty(mainDate)) mainDate = "0000-00-00";
        holder.mListMainDate.setText(mainDate);
        if (!TextUtils.isEmpty(mainContent)){
            if(mainContent.length() > sContentLength) mainContent = mainContent.substring(0, sContentLength) + "..";
            holder.mListMainContent.setText(mainContent);
        }

        if (subImg1 == 0) subImg1 = R.drawable.no_image;
        holder.mListSubImg1.setImageResource(subImg1);
        if (subImg2 == 0) subImg2 =  R.drawable.no_image;
        holder.mListSubImg2.setImageResource(subImg2);
        if (subImg3 == 0) subImg3 =  R.drawable.no_image;
        holder.mListSubImg3.setImageResource(subImg3);
        if (subImg4 == 0) subImg4 =  R.drawable.no_image;
        holder.mListSubImg4.setImageResource(subImg4);
        if (subImg5 == 0) subImg5 =  R.drawable.no_image;
        holder.mListSubImg5.setImageResource(subImg5);

        // 완성된 View return
        return view;
    }
}
