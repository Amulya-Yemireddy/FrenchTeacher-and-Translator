package com.example.basicfrench;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.basicfrench.learn;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<learn> learnArrayList;

    MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);
        learnArrayList=new ArrayList<>();
        learn l1=new learn("Words");
        learn l2=new learn("Sentences");
        learn l3=new learn("translate");

        learnArrayList.add(l1);
        learnArrayList.add(l2);
        learnArrayList.add(l3);

        adapter=new MyCustomAdapter(learnArrayList,getApplicationContext());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String activityName=adapter.getItem(position).getFunction();
                Intent i=null;

                if(activityName=="Words"){
                    i=new Intent(getApplicationContext(), wordActivity.class);
                }
                else if(activityName=="Sentences"){
                    i=new Intent(getApplicationContext(), SentenceActivity.class);
                }
                else if(activityName=="translate"){
                    i=new Intent(getApplicationContext(), TranslateActivity.class);
                }

                startActivity(i);
            }
        });

    }
}