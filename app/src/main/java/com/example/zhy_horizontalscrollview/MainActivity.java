package com.example.zhy_horizontalscrollview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.zhy_horizontalscrollview.MyHorizontalScrollView.CurrentImageChangeListener;
import com.example.zhy_horizontalscrollview.MyHorizontalScrollView.OnItemClickListener;

public class MainActivity extends Activity {

    private MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter mAdapter;
    private ImageView mImg;
    private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(
            R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8,
            R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12,
            R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16,
            R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20 ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mImg = (ImageView) findViewById(R.id.id_content);

        mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
        mAdapter = new HorizontalScrollViewAdapter(this, mDatas);
        //添加滚动回调
//        mHorizontalScrollView
//                .setCurrentImageChangeListener(new CurrentImageChangeListener() {
//                    @Override
//                    public void onCurrentImgChanged(int position,
//                                                    View viewIndicator) {
//                        mImg.setImageResource(mDatas.get(position));
//                        viewIndicator.setBackgroundColor(Color
//                                .parseColor("#AA024DA4"));
//                    }
//                });

        mImg.setImageResource(mDatas.get(0));//设置初始图片为第一张

        //添加点击回调
        mHorizontalScrollView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                mImg.setImageResource(mDatas.get(position));
                view.setBackgroundColor(Color.parseColor("#AA024DA4"));
            }
        });
        //设置适配器
        mHorizontalScrollView.initDatas(mAdapter);
    }

}
