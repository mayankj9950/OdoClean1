package com.odoclean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity
{
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    EditText input_name,input_password;
    TextView link_signup,forgot_password;
    Button btn_login;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        // requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        //.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_name=(EditText)findViewById(R.id.input_name);
        input_password=(EditText)findViewById(R.id.input_password);
        link_signup=(TextView)findViewById(R.id.link_signup);
        btn_login=(Button)findViewById(R.id.btn_login);
        forgot_password=(TextView)findViewById(R.id.forget_password);


        link_signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent moveToRegis = new Intent(LoginActivity.this, SignupActivity.class);
                moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moveToRegis);
                LoginActivity.this.finish();
            }
        });






        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent moveToRegis = new Intent(LoginActivity.this, NavigationActivity.class);
                moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moveToRegis);
                LoginActivity.this.finish();
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent moveToRegis = new Intent(LoginActivity.this, ForgotActivity.class);
                moveToRegis.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(moveToRegis);
                LoginActivity.this.finish();
            }
        });




    }

}

/* Email = (EditText)findViewById(R.id.email);
          Password = (EditText)findViewById(R.id.password);
          LogIn = (Button)findViewById(R.id.Login);

          LogIn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

        CheckEditTextIsEmptyOrNot();

        if(CheckEditText){

        UserLoginFunction(EmailHolder, PasswordHolder);

        }
        else {

        Toast.makeText(UserLoginActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

        }

        }
        });
        }
public void CheckEditTextIsEmptyOrNot(){

        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {
        CheckEditText = false;
        }
        else {

        CheckEditText = true ;
        }
        }

public void UserLoginFunction(final String email, final String password){

class UserLoginClass extends AsyncTask<String,Void,String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = ProgressDialog.show(UserLoginActivity.this,"Loading Data",null,true,true);
    }

    @Override
    protected void onPostExecute(String httpResponseMsg) {

        super.onPostExecute(httpResponseMsg);

        progressDialog.dismiss();

        if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

            finish();

            Intent intent = new Intent(UserLoginActivity.this, DashboardActivity.class);

            intent.putExtra(UserEmail,email);

            startActivity(intent);

        }
        else{

            Toast.makeText(UserLoginActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected String doInBackground(String... params) {

        hashMap.put("email",params[0]);

        hashMap.put("password",params[1]);

        finalResult = httpParse.postRequest(hashMap, HttpURL);

        return finalResult;
    }
}

    UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(email,password);
                }

                }*/
