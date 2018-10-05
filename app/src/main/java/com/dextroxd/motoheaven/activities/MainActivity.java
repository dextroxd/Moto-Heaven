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
import android.widget.ListView;

import com.dextroxd.motoheaven.R;

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
