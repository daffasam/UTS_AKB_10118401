package com.example.UTS_AKB_10118401;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

// Tanggal Pengerjaan : 23 Mei 2022
// Nama : Daffa Sacofi Mutawakkil
// NIM : 10118401
// Kelas : IF-6

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public int id;
    final int PICK_ONE = 1;

    ImageView ig,email,tlp;
    CardView findme, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ig = findViewById(R.id.ig);
        email = findViewById(R.id.email);
        tlp = findViewById(R.id.tlp);
        findme = findViewById(R.id.findme);
        about = findViewById(R.id.about);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_profile);

        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/daffa_sac/?hl=id"));
                startActivity(browserIntent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isiEMail = "Hallo saya ...";
                String subjectEmail = "Perkenalkan";

                String email = "daffasacofi3@gmail.com".trim();
                String subject = subjectEmail.trim();
                String isi = isiEMail.trim();

                Uri uri = Uri.parse("mailto:"+email+"?subject="+subject+"&body="+isi);

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                try {
                    Intent intent1 = Intent.createChooser(intent,"Choose");
                    setResult(PICK_ONE, intent1);
                    startActivity(intent1);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), String.valueOf(e), Toast.LENGTH_LONG).show();
                }
            }
        });

        tlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+6285731250605"));
                startActivity(intent);
            }
        });

        findme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double latitude = -6.895474;
                Double longitude = 107.645636;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<"+latitude+">,<"+longitude+">?q=<"+latitude+">,<"+longitude+">(Kosan+Daffa)"));
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        Dialog dialog1 = new Dialog(ProfileActivity.this);
        dialog1.setCanceledOnTouchOutside(true);
        dialog1.setContentView(R.layout.about);

        ImageView img;
        TextView txt;

        img = dialog1.findViewById(R.id.logo);
        txt = dialog1.findViewById(R.id.msg);

        img.setImageResource(R.drawable.slide1);
        txt.setText("ABOUT MYSELF APPS");

        dialog1.show();
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
                Intent intent4 = new Intent(this, VideoActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_profile:
                id = item.getItemId();
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