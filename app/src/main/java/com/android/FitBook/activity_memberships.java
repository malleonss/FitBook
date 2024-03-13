package com.android.FitBook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity_memberships extends AppCompatActivity {

    // Declare buttons for memberships
    private Button newMembershipButton;
    private Button renewMembershipButton;
    private Button membershipsButton;
    private Button messButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberships);

        // Initialize MembershipHandler
        MembershipHandler membershipHandler = new MembershipHandler();

        // Declare a flag to indicate if all buttons are successfully found
        boolean allButtonsFound = true;

        // Find the New Membership Button
        try {
            newMembershipButton = findViewById(R.id.avpButton);
        } catch (Exception e) {
            allButtonsFound = false;
            e.printStackTrace();
        }

        // Find the Renew Membership Button
        try {
            renewMembershipButton = findViewById(R.id.recButton);
        } catch (Exception e) {
            allButtonsFound = false;
            e.printStackTrace();
        }

        // Find the Memberships Button
        try {
            membershipsButton = findViewById(R.id.membershipsbutton);
        } catch (Exception e) {
            allButtonsFound = false;
            e.printStackTrace();
        }

        // Find the Message Button
        try {
            messButton = findViewById(R.id.messButton);
        } catch (Exception e) {
            allButtonsFound = false;
            e.printStackTrace();
        }

        // If any button is not found, show a toast message and return
        if (!allButtonsFound) {
            Toast.makeText(this, "Some buttons were not found", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set click listener for the New Membership Button
        newMembershipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to add a new membership
                membershipHandler.addNewMembership(activity_memberships.this, "Gold");
            }
        });

        // Set click listener for the Renew Membership Button
        renewMembershipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to renew an existing membership
                membershipHandler.renewMembership(activity_memberships.this, "Gold");
            }
        });

        // Set click listener for the Memberships Button
        membershipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method for memberships
                Toast.makeText(activity_memberships.this, "Membership button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listener for the Message Button
        messButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method for message
                Toast.makeText(activity_memberships.this, "Message button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // MembershipHandler class
    private static class MembershipHandler {
        // Method to add a new membership
        public void addNewMembership(Context context, String membershipType) {
            // Your code to add a new membership
            // For example:
            Toast.makeText(context, "New " + membershipType + " membership added!", Toast.LENGTH_SHORT).show();
        }

        // Method to renew an existing membership
        public void renewMembership(Context context, String membershipType) {
            // Your code to renew a membership
            // For example:
            Toast.makeText(context, "Renewed " + membershipType + " membership!", Toast.LENGTH_SHORT).show();
        }
    }
}
