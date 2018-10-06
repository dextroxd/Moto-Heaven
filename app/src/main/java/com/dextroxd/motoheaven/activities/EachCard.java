package com.dextroxd.motoheaven.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

         if(bundle.getStringArrayList("Roadster")!=null)
         {


                  imagee = new ArrayList<>(bundle.getStringArrayList("Roadster"));

         }
         else if(bundle.getStringArrayList("Fatboy")!=null)
         {
             imagee = new ArrayList<>(bundle.getStringArrayList("Fatboy"));
         }

        else if(bundle.getStringArrayList("Dyna")!=null)
        {


            imagee = new ArrayList<>(bundle.getStringArrayList("Dyna"));

        }

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this,imagee);
        viewPager.setAdapter(viewPagerAdapter);

    }
}
