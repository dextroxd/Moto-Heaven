package com.dextroxd.motoheaven.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dextroxd.motoheaven.R;
import com.dextroxd.motoheaven.adapters.ViewPagerAdapter;

import java.util.ArrayList;

public class EachCard extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<String> imagee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_card);
         viewPager= findViewById(R.id.viewPager);
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

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this,imagee);
        viewPager.setAdapter(viewPagerAdapter);

    }
}
