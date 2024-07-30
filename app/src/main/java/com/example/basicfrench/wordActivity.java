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

import java.util.ArrayList;

public class wordActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<word> wordArrayList;

    WordCustomAdapter wordCustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_word);
        gridView=findViewById(R.id.wordgridlayout);
        wordArrayList=new ArrayList<>();
        word w1=new word("Basic Words");
        word w2=new word("colors");
        word w3=new word("fruits");
        word w4=new word("vegetables");
        word w5=new word("Animals and birds");
        word w6=new word("plants");
        word w7=new word("objects");

        wordArrayList.add(w1);
        wordArrayList.add(w2);
        wordArrayList.add(w3);
        wordArrayList.add(w4);
        wordArrayList.add(w5);
        wordArrayList.add(w6);
        wordArrayList.add(w7);

        wordCustomAdapter=new WordCustomAdapter(wordArrayList,getApplicationContext());
        gridView.setAdapter(wordCustomAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String wordName=wordCustomAdapter.getItem(position).getType_word();
                Intent i=null;
                if(wordName=="Basic Words"){
                    i=new Intent(getApplicationContext(), BasicWordsActivity.class);
                }
                else if(wordName=="colors"){
                    i=new Intent(getApplicationContext(), colorsActivity.class);
                } else if (wordName=="fruits") {
                    i=new Intent(getApplicationContext(),fruitsWordActivity.class);
                }
                else if(wordName=="vegetables"){
                    i=new Intent(getApplicationContext(), VegetableWordActivity.class);
                } else if (wordName=="Animals and birds") {
                    i=new Intent(getApplicationContext(), AnimalnBirdActivity.class);
                } else if (wordName=="plants") {
                    i=new Intent(getApplicationContext(), plantsActivity.class);
                } else if (wordName == "objects") {
                    i=new Intent(getApplicationContext(),objectActivity.class);
                }

                startActivity(i);
            }
        });

    }
}