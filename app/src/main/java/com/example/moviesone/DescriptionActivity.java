package com.example.moviesone;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {

private static final String Tag = "DescriptionActivity";

   protected void onCreate(@Nullable Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_description);
       Log.d(Tag,"oncCreate: started");




   }
}
