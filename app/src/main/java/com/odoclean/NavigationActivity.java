package com.odoclean;

import android.accessibilityservice.FingerprintGestureController;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("DryClean"));
        tabLayout.addTab(tabLayout.newTab().setText("Iron+DryClean"));
        tabLayout.addTab(tabLayout.newTab().setText("Clean+Iron"));
        tabLayout.addTab(tabLayout.newTab().setText("Clean+Iron"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });












       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        View header = navigationView.getHeaderView(0);
        Button btnCapturePicture = (Button) header.findViewById(R.id.btnCapturePicture);
        btnCapturePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 final int REQUEST_IMAGE_CAPTURE = 1;


                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }

                Toast.makeText(NavigationActivity.this,"working on Camera activity",Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        NavigationActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void createTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.tab1, null);
        tabOne.setText("DryClean");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_contact, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.tab1, null);
        tabTwo.setText("Iron+Washing");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.tab1, null);
        tabThree.setText("Iron+DryClean");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_order, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.tab1, null);
        tabFour.setText("Iron+DryClean");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_order, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

    }

    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Fragment1(), "DryClean");
        adapter.addFrag(new Fragment2(), "Iron+Washing");
        adapter.addFrag(new Fragment3(), "Iron+DryClean");
        adapter.addFrag(new Fragment4(), "Iron+Clean");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {


            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {

                    Intent moveToRegis = new Intent(NavigationActivity.this, CartActivity.class);
                    moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(moveToRegis);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_contact)
        {
            Intent moveToRegis = new Intent(NavigationActivity.this, ContactActivity.class);
            moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(moveToRegis);

        } else if (id == R.id.nav_manage)
        {
            Intent moveToRegis = new Intent(NavigationActivity.this, RatingActivity.class);
            moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(moveToRegis);
           // NavigationActivity.this.finish();

        }else if(id==R.id.nav_order)
        {

            Intent moveToRegis = new Intent(NavigationActivity.this, MapsActivity.class);
            moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(moveToRegis);
        }
        else if (id == R.id.nav_share)
        {


        } else if (id == R.id.nav_send)
        {

            Intent moveToRegis = new Intent(NavigationActivity.this, FeedbackActivity.class);
            moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(moveToRegis);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
