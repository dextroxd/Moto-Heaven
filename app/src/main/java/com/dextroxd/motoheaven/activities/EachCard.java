package com.dextroxd.motoheaven.activities;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dextroxd.motoheaven.R;
import com.dextroxd.motoheaven.adapters.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static android.util.Log.i;

public class EachCard extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<String> imagee;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 200;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 2000; // time in milliseconds between successive task executions.
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_card);
         viewPager= findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
         Bundle bundle = getIntent().getExtras();
        TextView tv = findViewById(R.id.description);
        TextView tvh=findViewById(R.id.heading);
        RatingBar rg = findViewById(R.id.rate);
        float r;
         if(bundle.getStringArrayList("Roadster")!=null)
         {


                  imagee = new ArrayList<>(bundle.getStringArrayList("Roadster"));

                    tvh.setText("Roadster");
                    tv.setText(bundle.getStringArrayList("Roadster").get(5));
                    r= Float.valueOf(bundle.getStringArrayList("Roadster").get(6));
                    rg.setRating(r);



         }


         else if(bundle.getStringArrayList("Fatboy")!=null)
         {
             imagee = new ArrayList<>(bundle.getStringArrayList("Fatboy"));
             tvh.setText("Fatboy");
             tv.setText(bundle.getStringArrayList("Fatboy").get(5));
             r= Float.valueOf(bundle.getStringArrayList("Fatboy").get(6));
             rg.setRating(r);


         }

        else if(bundle.getStringArrayList("Dyna")!=null)
        {


            imagee = new ArrayList<>(bundle.getStringArrayList("Dyna"));
            tvh.setText("Dyna");
            tv.setText(bundle.getStringArrayList("Dyna").get(5));
            r= Float.valueOf(bundle.getStringArrayList("Dyna").get(6));
            rg.setRating(r);



        }

        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this,imagee);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentPage = viewPager.getCurrentItem();

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


            final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 5) {
                    currentPage = 0;
                }

                viewPager.setCurrentItem(currentPage++, true);

            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}

