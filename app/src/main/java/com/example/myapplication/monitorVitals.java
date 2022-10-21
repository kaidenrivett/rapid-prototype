package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMonitorVitalsBinding;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class monitorVitals extends AppCompatActivity {

    private TextView ques,num_ques;
    private Button option1,option2;
    private ArrayList<questions> questions_array;
    Random random;
    int emergency_req=0,ques_att=1,current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_monitor_vitals);
       ques=findViewById(R.id.question);
       num_ques=findViewById(R.id.noOfques);
       option1=findViewById(R.id.button1);
       option2=findViewById(R.id.button2);
       questions_array=new ArrayList<>();
       random=new Random();
       getData(questions_array);
       current=0;
       setData(current);
       option1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(questions_array.get(current).getAnswer().trim().toLowerCase().equals(option1.getText().toString().trim().toLowerCase()))emergency_req++;
               ques_att++;
               current++;
               setData(current);
           }
       });
       option2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(questions_array.get(current).getAnswer().trim().toLowerCase().equals(option2.getText().toString().trim().toLowerCase()))emergency_req++;
               ques_att++;
               current++;
               setData(current);
           }
       });
    }


    private void bottomPop()
    {
        BottomSheetDialog bottom= new BottomSheetDialog(monitorVitals.this);
        View bottom_popup= LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_popup,(LinearLayout)findViewById(R.id.lay));
        TextView emer=bottom_popup.findViewById(R.id.emer);
        TextView location=bottom_popup.findViewById(R.id.loc);
        emer.setText("Emergency services on the way \n");
        bottom.setCancelable(false);
        bottom.setContentView(bottom_popup);
        bottom.show();
    }
    private void setData(int cur)
    {
        num_ques.setText("Questions Answered: "+ques_att+ "/5");
        if(ques_att ==6)
        {
            bottomPop();
        }
        else{
            ques.setText(questions_array.get(cur).getQuestion());
            option1.setText(questions_array.get(cur).getOption1());
            option2.setText(questions_array.get(cur).getOption2());
        }

    }
    private void getData(ArrayList<questions> questions_array) {
        questions_array.add(new questions("What is the heart beat pattern you observe?","low or heart rate","normal heart rate","low or heart rate"));
        questions_array.add(new questions("What is the heart breathing pattern you observe?","low or high breathing","normal breathing","low or high breathing"));
        questions_array.add(new questions("Any changes in skin color?","yes","no","yes"));
        questions_array.add(new questions("Is opioid user unconscious or unable to arose?","yes","no","yes"));
        questions_array.add(new questions("Is opioid user feeling lack of oxygen","yes","no","yes"));
    }

}