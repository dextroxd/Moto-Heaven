package com.dextroxd.motoheaven.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dextroxd.motoheaven.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    ArrayList<String> imagesv = new ArrayList<>();
    public ViewPagerAdapter(Context context,ArrayList<String> mn) {
        this.context = context;
        for(int i=0;i<5;i++)
        {
            imagesv.add(mn.get(i));
        }
    }

    @Override
    public int getCount() {
        return imagesv.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.customview,null);
        ImageView imagef = (ImageView) view.findViewById(R.id.imagec);
        Picasso.get().load(imagesv.get(position)).into(imagef);
        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp =(ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
