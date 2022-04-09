package com.checkapp.health.healthcheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_contact_us extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    ImageView i1;
    ImageView i2;
    ImageView i3;
    private static final int REQUEST_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        t1 = findViewById(R.id.call_cs);
        t2 = findViewById(R.id.mail_cs);
        t3 = findViewById(R.id.map_cs);
        i1 = findViewById(R.id.final_call);
        i2 = findViewById(R.id.final_mail);
        i3 = findViewById(R.id.final_map);

        final String num = "8859477700";
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(num);
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(num);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:" + "naman712sharma@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback");
                try {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(activity_contact_us.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:" + "naman712sharma@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback");
                try {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(activity_contact_us.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(Intent.ACTION_VIEW);
                bIntent.setData(Uri.parse("https://www.google.com/maps/dir/28.4760959,77.4816688/Nalanda+Living+Boy's+Hostel+best+boys+hostels+in+greater+noida,+Plot+No.+45,+Opp.+Dronacharya+Colllege,+near+Sharda+University,+Knowledge+Park+III,+Greater+Noida,+Uttar+Pradesh+201308/@28.4778454,77.4779994,17z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x390ceb9bf4b89b61:0x8061d58d84cc6729!2m2!1d77.4775558!2d28.4775118"));
                startActivity(bIntent);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(Intent.ACTION_VIEW);
                bIntent.setData(Uri.parse("https://www.google.com/maps/dir/28.4760959,77.4816688/Nalanda+Living+Boy's+Hostel+best+boys+hostels+in+greater+noida,+Plot+No.+45,+Opp.+Dronacharya+Colllege,+near+Sharda+University,+Knowledge+Park+III,+Greater+Noida,+Uttar+Pradesh+201308/@28.4778454,77.4779994,17z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x390ceb9bf4b89b61:0x8061d58d84cc6729!2m2!1d77.4775558!2d28.4775118"));
                startActivity(bIntent);
            }
        });


    }

    private void makePhoneCall(String num)
    {
        if(ContextCompat.checkSelfPermission(activity_contact_us.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(activity_contact_us.this, new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL );
        }
        else
        {
            String dial = "tel:" +num;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

}
