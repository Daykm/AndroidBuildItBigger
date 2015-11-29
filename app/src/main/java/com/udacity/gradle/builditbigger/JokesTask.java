package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.daykm.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class JokesTask extends AsyncTask<Context, Void, String> {

    private static MyApi myApiService;

    public JokesTask(MyApi myApiService) {
        this.myApiService = myApiService;
    }

    @Override
    protected String doInBackground(Context... params) {

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            Log.d("Task", Log.getStackTraceString(e));
        }

        return "RIP";
    }
}
