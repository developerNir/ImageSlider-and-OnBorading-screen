package com.example.imageslideshow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context) {
        this.context = context;
    }

    int Images[] = {
            R.drawable.bills,
            R.drawable.clock,
            R.drawable.statistice,
            R.drawable.share,

    };

    int Headers[] ={
            R.string.headerOne,
            R.string.headerTwo,
            R.string.headerTree,
            R.string.headerFour
    };

    int Descriptions[] ={
            R.string.desOne,
            R.string.desTwo,
            R.string.desTree,
            R.string.desFour
    };

    @Override
    public int getCount() {
        return Headers.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        // kon layout slide korba example LinearLayout ----------------------
        return view == (LinearLayout) object;
    }

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        TextView des = view.findViewById(R.id.TextDescription);

        imageView.setImageResource(Images[position]);
        textView.setText(Headers[position]);
        des.setText(Descriptions[position]);

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {



        // kon layout slide korba example LinearLayout ----------------------
        container.removeView((LinearLayout) object );
    }
}
