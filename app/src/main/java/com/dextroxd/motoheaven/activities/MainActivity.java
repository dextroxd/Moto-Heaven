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
                        Intent in = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(in);
                        menuItem.setChecked(false);
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
                {urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538736428/harley-davidson-roadster-doin-time.jpg");
                urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538736427/19-sportster-roadster-hero.jpg");
                urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538736438/Harley-Davidson-Roadster-XL1200CX-Static-11.jpg");
                urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538736436/Harley-Davidson-Roadster-XL1200CX-Static-8.jpg");
                urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538736430/2000000014.jpg");
                bundle.putStringArrayList(mode.getmName(),urls);}
                else if(mode.getmName()=="Fatboy")
                {urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538737653/ea18e6d543c08c87768218840ad3c283.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538737678/maxresdefault.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538737691/a0d84a41159e1966ab3a26e55f801f54--moped-fat.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538737678/maxresdefault.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538828208/Thunderbike-customized-Harley-Davidson-Fat-Boy.jpg");
                    bundle.putStringArrayList(mode.getmName(),urls);}
                else if(mode.getmName()=="Dyna")
                {urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538738077/harley-davidson-dyna-1.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538738051/original.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538738102/5bbaaca9fd0da9b018a65a2aec30a184.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538738121/_harley-davidson-dyna-3.jpg");
                    urls.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538828285/DSC04278.jpg");
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
        aImage.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538736428/harley-davidson-roadster-doin-time.jpg");
        aImage.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538737653/ea18e6d543c08c87768218840ad3c283.jpg");
        aImage.add("https://res.cloudinary.com/dj3vndkb4/image/upload/v1538738077/harley-davidson-dyna-1.jpg");
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
