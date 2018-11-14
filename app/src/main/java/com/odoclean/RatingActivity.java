package com.odoclean;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    public RatingBar ratingBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratingbar);
        // Initialize RatingBar
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        button=(Button)findViewById(R.id.submit);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),
                        String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }

        });



    }
}