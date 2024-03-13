package com.android.FitBook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class AboutActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout profile, home, settings, share, about, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        profile = findViewById(R.id.profile);
        home = findViewById(R.id.home);
        settings = findViewById(R.id.settings);
        share = findViewById(R.id.share);
        about = findViewById(R.id.about);
        logout = findViewById(R.id.logout);

        menu.setOnClickListener(view -> openDrawer(drawerLayout));
        home.setOnClickListener(v -> redirectActivity(AboutActivity.this, Dashboard.class));
        profile.setOnClickListener(v -> redirectActivity(AboutActivity.this, SettingsActivity.class));
        settings.setOnClickListener(v -> redirectActivity(AboutActivity.this, SettingsActivity.class));
        share.setOnClickListener(v -> redirectActivity(AboutActivity.this, SettingsActivity.class));
        about.setOnClickListener(v -> recreate());
        logout.setOnClickListener(v -> {
            Toast.makeText(AboutActivity.this, "Logout", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        });
    }
    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}
