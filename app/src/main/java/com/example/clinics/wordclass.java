package com.example.clinics;

import android.widget.ImageView;

public class wordclass {
    private Integer mImageView;
    private String mTextV1;
    private String mTextV2;
    public wordclass(int imageRes,String text1,String text2)
    {
        mImageView = imageRes;
        mTextV1 = text1;
        mTextV2 = text2;
    }
    public Integer getmImageView(){
        return mImageView;
    }
    public String getmTextV1(){
        return mTextV1;
    }
    public String getmTextV2(){
        return mTextV2;
    }
}
