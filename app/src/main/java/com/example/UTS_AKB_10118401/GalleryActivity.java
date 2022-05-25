package com.example.UTS_AKB_10118401;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
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

public class GalleryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public int id;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    RecyclerView rvGalMenu;
    GalleryAdapter myAdapter;
    List<GalleryModel> lsGalMenu = new ArrayList<>();
    GalleryModel mdlGalMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_gallery);

        rvGalMenu = findViewById(R.id.rvGallery);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 3,
                RecyclerView.VERTICAL, false);
        rvGalMenu.setLayoutManager(mLayoutManager);
        rvGalMenu.setHasFixedSize(true);

        setMenu();
    }

    private void setMenu() {
        mdlGalMenu = new GalleryModel(R.drawable.gal1);
        lsGalMenu.add(mdlGalMenu);
        mdlGalMenu = new GalleryModel(R.drawable.gal2);
        lsGalMenu.add(mdlGalMenu);
        mdlGalMenu = new GalleryModel(R.drawable.gal3);
        lsGalMenu.add(mdlGalMenu);
        mdlGalMenu = new GalleryModel(R.drawable.gal4);
        lsGalMenu.add(mdlGalMenu);
        mdlGalMenu = new GalleryModel(R.drawable.gal5);
        lsGalMenu.add(mdlGalMenu);
        mdlGalMenu = new GalleryModel(R.drawable.gal6);
        lsGalMenu.add(mdlGalMenu);
        mdlGalMenu = new GalleryModel(R.drawable.gal7);
        lsGalMenu.add(mdlGalMenu);
        mdlGalMenu = new GalleryModel(R.drawable.gal8);
        lsGalMenu.add(mdlGalMenu);
        mdlGalMenu = new GalleryModel(R.drawable.gal9);
        lsGalMenu.add(mdlGalMenu);

        myAdapter = new GalleryAdapter(lsGalMenu);
        rvGalMenu.setAdapter(myAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_daily:
                Intent intent2 = new Intent(this, DailyActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_gallery:
                id = item.getItemId();
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            finishAffinity();
        }
    }
}