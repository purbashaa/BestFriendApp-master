package com.example.pintu.bestfriendapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {


    private EditText UserName;
    private EditText Password;
    private Button Login;
    private Button CreateNewAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
// To get values from user
        UserName =(EditText) findViewById(R.id.etlogin);
        Password =(EditText) findViewById(R.id.etpassword);


        Login =(Button) findViewById(R.id.btLogin);
        CreateNewAccount =(Button) findViewById(R.id.btCreateNwAccnt);
/*
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(login.this, MainActivity.class);
                login.this.startActivity(LoginIntent);
            }
        });
*/
        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String VIUsername = UserName.getText().toString();
                final String VIPassword = Password.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {

                                String VName = jsonResponse.getString("name");
                                int VAge = jsonResponse.getInt("age");
                                String VCity = jsonResponse.getString("city");
                                String VHobby1 = jsonResponse.getString("hobby_1");
                                String VHobby2 = jsonResponse.getString("hobby_2");
                                String VUsername = jsonResponse.getString("username");

                                Intent intent = new Intent(login.this, MainActivity.class);
                                intent.putExtra("name",VName);
                                intent.putExtra("age",VAge);
                                intent.putExtra("city",VCity);
                                intent.putExtra("hobby_1",VHobby1);
                                intent.putExtra("hobby_2",VHobby2);
                                intent.putExtra("username",VUsername);

                                login.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                                builder.setMessage("Login Failed.")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest = new LoginRequest(VIUsername,VIPassword, responseListener );
                RequestQueue queue = Volley.newRequestQueue(login.this);
                queue.add(loginRequest);

            }
        });
        CreateNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createNewAccountIntent = new Intent(login.this, createAccount.class);
                login.this.startActivity(createNewAccountIntent);
        }
        });

    }
}
