package com.example.UTS_AKB_10118401;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

// Tanggal Pengerjaan : 23 Mei 2022
// Nama : Daffa Sacofi Mutawakkil
// NIM : 10118401
// Kelas : IF-6

public class DailyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public int id;

    RecyclerView rvDAMenu,rvFLMenu;
    DailyAdapter myAdapterDA;
    List<DailyModel> lsDAMenu = new ArrayList<>();
    DailyModel mdlDAMenu;

    FLAdapter myAdapter;
    List<FLModel> lsFLMenu = new ArrayList<>();
    FLModel mdlFLMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_daily);

        rvFLMenu = findViewById(R.id.rvFL);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this,
                RecyclerView.HORIZONTAL, false);
        rvFLMenu.setLayoutManager(mLayoutManager);
        rvFLMenu.setHasFixedSize(true);

        setMenuFL();

        rvDAMenu = findViewById(R.id.rvDA);
        LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        rvDAMenu.setLayoutManager(mLayoutManager1);
        rvDAMenu.setHasFixedSize(true);

        setMenuDA();
    }

    private void setMenuDA() {
        mdlDAMenu = new DailyModel(R.drawable.wakeup, "Wake Up");
        lsDAMenu.add(mdlDAMenu);
        mdlDAMenu = new DailyModel(R.drawable.bath, "Bath");
        lsDAMenu.add(mdlDAMenu);
        mdlDAMenu = new DailyModel(R.drawable.bf, "Breakfast");
        lsDAMenu.add(mdlDAMenu);
        mdlDAMenu = new DailyModel(R.drawable.game, "Playing Game Online");
        lsDAMenu.add(mdlDAMenu);
        mdlDAMenu = new DailyModel(R.drawable.film, "Watching Film (anime and movie)");
        lsDAMenu.add(mdlDAMenu);
        mdlDAMenu = new DailyModel(R.drawable.study, "Study");
        lsDAMenu.add(mdlDAMenu);
        mdlDAMenu = new DailyModel(R.drawable.lunch, "Have Lunch and Dinner");
        lsDAMenu.add(mdlDAMenu);
        mdlDAMenu = new DailyModel(R.drawable.sleep, "Sleep");
        lsDAMenu.add(mdlDAMenu);

        myAdapterDA = new DailyAdapter(lsDAMenu);
        rvDAMenu.setAdapter(myAdapterDA);
    }

    private void setMenuFL() {
        mdlFLMenu = new FLModel(R.drawable.ipul, "Saeful A");
        lsFLMenu.add(mdlFLMenu);
        mdlFLMenu = new FLModel(R.drawable.ruy, "Ruyatsyah");
        lsFLMenu.add(mdlFLMenu);
        mdlFLMenu = new FLModel(R.drawable.li, "Rifqi Li");
        lsFLMenu.add(mdlFLMenu);

        myAdapter = new FLAdapter(lsFLMenu);
        rvFLMenu.setAdapter(myAdapter);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            finishAffinity();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_daily:
                id = item.getItemId();
                break;
            case R.id.nav_gallery:
                Intent intent2 = new Intent(this, GalleryActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_video:
                Intent intent3 = new Intent(this, VideoActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_profile:
                Intent intent4 = new Intent(this, ProfileActivity.class);
                startActivity(intent4);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}