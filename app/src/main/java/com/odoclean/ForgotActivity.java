package com.odoclean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class ForgotActivity extends AppCompatActivity {

    public RatingBar ratingBar;
    Button btn_checkout, btn_back,send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        send=(Button)findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToRegis = new Intent(ForgotActivity.this, OtpActivity.class);
                moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moveToRegis);

            }
        });



    }

    @Override
    public void onBackPressed()
    {
        Intent moveToRegis = new Intent(ForgotActivity.this, LoginActivity.class);
        moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(moveToRegis);
        super.onBackPressed();  // optional depending on your needs
    }
}