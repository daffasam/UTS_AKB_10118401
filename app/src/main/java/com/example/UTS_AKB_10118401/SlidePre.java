package com.example.UTS_AKB_10118401;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

// Tanggal Pengerjaan : 23 Mei 2022
// Nama : Daffa Sacofi Mutawakkil
// NIM : 10118401
// Kelas : IF-6

public class SlidePre extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlidePre(Context context) {
        this.context = context;
    }

    //Arrays for logo
    public int[] slide_images = {
            R.drawable.slide2,
            R.drawable.slide3,
            R.drawable.slide4
    };

    //Array for heading
    public String[] slide_headings = {
            "WELCOME",
            "",
            ""
    };

    public String[] slide_decs = {
            "",
            "This application provides daily information, hobbies, galleries, music, videos and my social media",
            "Are you ready ?"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_screen, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.txt1);
        TextView slideDescription = (TextView) view.findViewById(R.id.txt2);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_decs[position]);

        if (slideHeading.getText().equals("")){
            slideHeading.setVisibility(View.GONE);
            slideDescription.setVisibility(View.VISIBLE);
        } else {
            slideDescription.setVisibility(View.GONE);
            slideHeading.setVisibility(View.VISIBLE);
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
