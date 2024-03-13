package com.android.FitBook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout profile, home, settings, share, about, logout;
    MembershipHandler membershipHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        profile = findViewById(R.id.profile);
        home = findViewById(R.id.home);
        settings = findViewById(R.id.settings);
        share = findViewById(R.id.share);
        about = findViewById(R.id.about);
        logout = findViewById(R.id.logout);

        // Initialize MembershipHandler
        membershipHandler = new MembershipHandler();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Dashboard.this, Profile.class);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Dashboard.this, SettingsActivity.class);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Dashboard.this, Message.class);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Dashboard.this, AboutActivity.class);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Dashboard.this, "Logout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        // Adding functionality to Memberships button
        Button membershipsButton = findViewById(R.id.membershipsbutton);
        membershipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMembershipsButtonClick();
            }
        });
    }

    // Method to open the navigation drawer
    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    // Method to close the navigation drawer
    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    // Method to redirect to another activity
    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    // Method to handle Memberships button click
    private void handleMembershipsButtonClick() {
        // For example, navigate to the Memberships activity
        Intent intent = new Intent(Dashboard.this, activity_memberships.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}
