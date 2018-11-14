package com.odoclean;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class SignupActivity extends Activity
{

    private static final String TAG = "SignupActivity";
    String username,password,confirm_password,contact,email;
    EditText input_name,input_password,input_rePassword,input_contact,input_email;
    TextView link_login;
    Button btn_signup;
    Boolean CheckEditText;
    ProgressDialog progressDialog;
    String finalResult ;
    String HttpURL = "https://127.0.0.1/odowash/user.php";
    HashMap<String,String> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        //getSupportActionBar().hide();
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //      WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        input_name=(EditText)findViewById(R.id.input_name);
        input_password=(EditText)findViewById(R.id.input_password);
        input_rePassword=(EditText)findViewById(R.id.input_repassword);
        input_contact =(EditText)findViewById(R.id.input_contact);
        input_email=(EditText)findViewById(R.id.input_email);
        link_login=(TextView)findViewById(R.id.link_login);
        btn_signup=(Button)findViewById(R.id.btn_signup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking whether EditText is Empty or Not
                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    // If EditText is not empty and CheckEditText = True then this block will execute.

                    UserRegisterFunction(username,password, confirm_password, contact,email);

                }
                else {

                    // If EditText is empty then this block will execute .
                    Toast.makeText(SignupActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }


            }
        });

        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

    }

    public void CheckEditTextIsEmptyOrNot(){

        username = input_name.getText().toString();
        password = input_password.getText().toString();
        confirm_password = input_rePassword.getText().toString();
        contact = input_contact.getText().toString();
        email = input_email.getText().toString();


        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }

    public void UserRegisterFunction(final String name, final String pass, final String cpass, final String contact,final String email){

        class UserRegisterFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(SignupActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(SignupActivity.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("name",params[0]);

                hashMap.put("pass",params[1]);

                hashMap.put("cpass",params[2]);

                hashMap.put("contact",params[3]);

                hashMap.put("email",params[4]);

                //finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(name,pass,cpass,contact,email);
    }

}


