package com.example.pintu.bestfriendapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pintu on 11/12/2017.
 */

public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL = "https://sonikashish.000webhostapp.com/FetchData.php";
    private Map<String, String> params;


    public LoginRequest(String Username, String Password, Response.Listener<String> listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL, listener, null );
        params = new HashMap<>();
        params.put("username",Username);
        params.put("password",Password);
    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
