package com.dextroxd.motoheaven.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.dextroxd.motoheaven.R;
import com.dextroxd.motoheaven.adapters.Cardcustomadapter;
import com.dextroxd.motoheaven.models.Model_card;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigation;
    private ArrayList<Model_card> arrayList= new ArrayList<>();
    private Cardcustomadapter customadapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawer = findViewById(R.id.drawer);
        mNavigation = findViewById(R.id.nav_view);
        mToggle = new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        mDrawer.requestLayout();
        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                menuItem.setChecked(false);
                mDrawer.closeDrawers();

                switch (id)
                {
                    case R.id.home:

                        menuItem.setChecked(false);
                        mDrawer.closeDrawers();
                        break;
                    case R.id.wishlist:
                        break;
                    case R.id.custom:
                        String e = "8684889061";
                        Uri u = Uri.parse("tel:" + e.toString());
                        Intent i = new Intent(Intent.ACTION_DIAL, u);
                        startActivity(i);
                        menuItem.setChecked(false);
                        break;
                    case R.id.about:
                        Intent o = new Intent(Intent.ACTION_VIEW);
                        o.setData(Uri.parse("https://www.suzukimotorcycle.co.in/hayabusa_creed_india"));
                        startActivity(o);
                        menuItem.setChecked(false);
                        break;
                    case R.id.help:
                        String [] arr ={"divyanshudhawan17@gmail.com"};

                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                        intent.putExtra(Intent.EXTRA_EMAIL, arr);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Help");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        menuItem.setChecked(false);
                        break;

                }
                return false;
            }
        });
        recyclerView = findViewById(R.id.recycler);
        customadapter = new Cardcustomadapter(arrayList,MainActivity.this);
        recyclerView.setAdapter(customadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getData();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Model_card mode = arrayList.get(position);
                Intent in = new Intent(MainActivity.this,EachCard.class);
                Bundle bundle = new Bundle();
                ArrayList<String>urls = new ArrayList<>();
                if(mode.getmName()=="Roadster")
                {urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538972808/sportster-roadster-int-gallery-1.jpg");
                urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538972745/sportster-roadster-gallery-2.jpg");
                urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538972933/sportster-roadster-gallery-3.jpg");
                urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538972967/sportster-roadster-gallery-4.jpg");
                urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538973004/sportster-roadster-gallery-5.jpg");
                urls.add("The new model in the Harley-Davidson India range gets the same V-Twin 1200cc Evolution air-cooled unit that does duty on the 1200 Custom, although the state of tune is different in both the models. The prowess gets new paint-schemes and graphics that add to its rugged and muscular look. Priced at Rs 9.70 lakh (ex-showroom, Delhi), new Roadster from Harley-Davidson gets the V-Tzwin 1200cc Evolution air-cooled engine making peak torque of 96Nm at 4000rpm. Placed above Forty-Eight in the line-up, the sportster comes with a 4-inch digital instrumentation which displays RPMs, speed and time. Besides, it also gets a trip meter, gear indicator and tell-tale lights.");
                urls.add(String.valueOf(mode.getmRating()));
                bundle.putStringArrayList(mode.getmName(),urls);}
                else if(mode.getmName()=="Fatboy")
                {urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538975234/557854ebccb1e.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538973562/softail-fatboy-gallery-4.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538973641/kf3-MKE-EIGHT-Big-twin.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538973627/kf2-steamroller-stance.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538973660/kf5-New-Softail-Frame.jpg");
                    urls.add("Yes, it's fat and that is why it gets its name. The Fat Boy has a unique design and there is a generous dose of chrome and that is not all. It comes with a load full of features too. It features a wide FLH-style handlebar, a textured leather seat insert, custom metal fenders and a shotgun-style dual exhaust system. The Fat Boy is powered by a Twin Cam 103 1690cc engine that produces a generous amount of power and it's a highway cruiser so don't try and tame it by riding it in the city. It's clearly out of place there.");
                    urls.add(String.valueOf(mode.getmRating()));
                    bundle.putStringArrayList(mode.getmName(),urls);}
                else if(mode.getmName()=="Dyna")
                {urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538974219/Street-Bob-1800-1.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538974260/Low-Rider-Trees.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538974288/Fat-Bob-1800.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538974309/Wide-Glide-1800.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538974322/Switchback-1800.jpg");
                    urls.add("The Harley-Davidson Dyna lineup includes some of the most widely recognized motorcycles in the world. These stripped down cruisers boast raw custom style, big V- Twin performance, and the kind of instantly recognizable Harley-Davidson nameplates that you want. Read all about the Street Bob®, Low Rider®, Fat Bob® and the rest of the Dyna® model line here at Huntington Beach Harley-Davidson in the Anaheim and Irvine, CA area!");
                    urls.add(String.valueOf(mode.getmRating()));
                    bundle.putStringArrayList(mode.getmName(),urls);}

                in.putExtras(bundle);
                startActivity(in);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));




        }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void getData()
    {
        ArrayList<String> aImage = new ArrayList<>();
        ArrayList<String> aName = new ArrayList<>();
        ArrayList<String> aCost = new ArrayList<>();
        ArrayList<Float> aRate = new ArrayList<>();
        aImage.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538972808/sportster-roadster-int-gallery-1.jpg");
        aImage.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538975234/557854ebccb1e.jpg");
        aImage.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538974219/Street-Bob-1800-1.jpg");
        aName.add("Roadster");
        aName.add("Fatboy");
        aName.add("Dyna");
        aCost.add("₹"+"9.70"+" Lacks");
        aCost.add("₹"+"18.11"+" Lacks");
        aCost.add("₹"+"12.59"+" Lacks");
        aRate.add(2f);
        aRate.add(1.5f);
        aRate.add(2.5f);
        for(int i=0;i<aImage.size();i++)
        {
            arrayList.add(new Model_card(aImage.get(i),aName.get(i),aCost.get(i),aRate.get(i)));
        }

        customadapter.notifyDataSetChanged();
    }
}
