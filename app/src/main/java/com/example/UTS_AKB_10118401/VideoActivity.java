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

public class VideoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public int id;

    RecyclerView rvLaguMenu;
    LaguAdapter myAdapter;
    List<LaguModel> lsLaguMenu = new ArrayList<>();
    LaguModel mdlLaguMenu;


    //ImageView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //video = findViewById(R.id.video);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_video);

        rvLaguMenu = findViewById(R.id.rvLagu);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        rvLaguMenu.setLayoutManager(mLayoutManager);
        rvLaguMenu.setHasFixedSize(true);

        setMenu();

        String url = "https://www.youtube.com/watch?v=xR278KGKN_Y";

        /**
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
            }
        });
         **/
    }

    private void setMenu() {
        mdlLaguMenu = new LaguModel("1. Industry baby -  (Lil Nas feat. Jack Harlow)");
        lsLaguMenu.add(mdlLaguMenu);
        mdlLaguMenu = new LaguModel("2. Takeaway - Chainsmoker");
        lsLaguMenu.add(mdlLaguMenu);
        mdlLaguMenu = new LaguModel("3. Let Me Down Slowly - Alec Benjamin");
        lsLaguMenu.add(mdlLaguMenu);
        mdlLaguMenu = new LaguModel("4. Roxanne - Arizona Zervas");
        lsLaguMenu.add(mdlLaguMenu);
        mdlLaguMenu = new LaguModel("5. Side to side - Ariana Grande");
        lsLaguMenu.add(mdlLaguMenu);
        mdlLaguMenu = new LaguModel("6. Me and My Broken Heart - Rixton");
        lsLaguMenu.add(mdlLaguMenu);
        mdlLaguMenu = new LaguModel("7. Without Me - Halsey");
        lsLaguMenu.add(mdlLaguMenu);

        myAdapter = new LaguAdapter(lsLaguMenu);
        rvLaguMenu.setAdapter(myAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_daily:
                Intent intent3 = new Intent(this, DailyActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_gallery:
                Intent intent2 = new Intent(this, GalleryActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_video:
                id = item.getItemId();
                break;
            case R.id.nav_profile:
                Intent intent4 = new Intent(this, ProfileActivity.class);
                startActivity(intent4);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            finishAffinity();
        }
    }
}