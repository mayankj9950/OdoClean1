package com.odoclean;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    Button button,dialogButtonOK;
    AlertDialog alertDialog1;
    CharSequence[] values = {"PAYTM ","UPI","CASH"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        button = (Button)findViewById(R.id.button);



        //dialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                CreateAlertDialogWithRadioButtonGroup() ;

            }
        }, 10); // 3000 milliseconds delay
    }

    public void CreateAlertDialogWithRadioButtonGroup(){


        AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);

        builder.setCancelable(false).setTitle("Select a Payment Method");



        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item) {

                switch(item)
                {
                    case 0:

                        //Toast.makeText(PaymentActivity.this, "First Item Clicked", Toast.LENGTH_LONG).show();


                                Intent moveToRegis = new Intent(PaymentActivity.this, PaytmActivity.class);
                                moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(moveToRegis);


                        break;
                    case 1:

                        Intent moveToRegis1 = new Intent(PaymentActivity.this, PaytmActivity.class);
                        moveToRegis1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(moveToRegis1);
                        break;
                    case 2:

                        Intent moveToRegis2 = new Intent(PaymentActivity.this, PaytmActivity.class);
                        moveToRegis2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(moveToRegis2);
                        break;
                }
                alertDialog1.dismiss();
            }
        });
        alertDialog1 = builder.create();
        alertDialog1.show();

    }



}