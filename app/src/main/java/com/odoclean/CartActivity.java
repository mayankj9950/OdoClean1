package com.odoclean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {

    public RatingBar ratingBar;
    Button btn_checkout,btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        // Initialize RatingBar

        btn_checkout=(Button)findViewById(R.id.btn_checkout);
        btn_back=(Button)findViewById(R.id.btn_back);






        btn_checkout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent moveToRegis = new Intent(CartActivity.this, CheckoutActivity.class);
                moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moveToRegis);

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent moveToRegis = new Intent(CartActivity.this, NavigationActivity.class);
                moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moveToRegis);

            }
        });




    }
}