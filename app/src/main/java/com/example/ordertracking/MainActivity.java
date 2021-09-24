package com.example.ordertracking;

import androidx.appcompat.app.AppCompatActivity;
import com.kofigyan.stateprogressbar.StateProgressBar;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    StateProgressBar stateProgressBar;
    String[] descriptionData = {"Cooking", "Picked", "On the way", "Delivered", "Done"};
    Button btn, report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateProgressBar = (StateProgressBar) findViewById(R.id.your_state_progress_bar_id);
        stateProgressBar.setStateDescriptionData(descriptionData);
        stateProgressBar.setAnimationDuration(800);
        stateProgressBar.enableAnimationToCurrentState(true);
        btn = (Button) findViewById(R.id.button);
        report = (Button) findViewById(R.id.report);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:28.673983439615526,77.1341432421473");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                displayTwo();
            }
        }, 5000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                displayThree();
            }
        }, 10000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                displayFour();
            }
        }, 15000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                displayFive();
            }
        }, 20000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                displayDone();
            }
        }, 25000);

    }
    private void displayTwo(){
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
    }
    private void displayThree(){
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
    }
    private void displayFour(){
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
  }
    private void displayFive(){
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FIVE);
    }
    private void displayDone(){
        stateProgressBar.setAllStatesCompleted(true);
        report.setVisibility(View.INVISIBLE);
    }
}