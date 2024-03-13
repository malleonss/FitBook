package com.android.FitBook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MembershipHandler extends AppCompatActivity {

    MembershipHandler membershipHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberships);

        // Initialize MembershipHandler
        membershipHandler = new MembershipHandler();

        // Example usage:
        // membershipHandler.addNewMembership(activity_memberships.this, "Gold");
        // membershipHandler.renewMembership(activity_memberships.this, "Silver");
    }
}
