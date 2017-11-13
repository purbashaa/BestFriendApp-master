package com.example.pintu.bestfriendapp;

import android.provider.ContactsContract;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pintu on 11/11/2017.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://sonikashish.000webhostapp.com/Register.php";
    private Map<String, String> params;


    public RegisterRequest(String Name, int Age, String City, String Hobby1, String Hobby2, String Username, String Password, Response.Listener<String> listener){
        super(Method.POST,REGISTER_REQUEST_URL, listener, null );
        params = new HashMap<>();
        params.put("name", Name);
        params.put("age",Age + "");
        params.put("city",City);
        params.put("hobby_1",Hobby1);
        params.put("hobby_2",Hobby2);
        params.put("username",Username);
        params.put("password",Password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
