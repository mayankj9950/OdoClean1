package com.odoclean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    public RatingBar ratingBar;
    Button btn_place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        // Initialize RatingBar

        btn_place=(Button)findViewById(R.id.btn_place);


        btn_place.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent moveToRegis = new Intent(CheckoutActivity.this, PaymentActivity.class);
                moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moveToRegis);

            }
        });


    }
}