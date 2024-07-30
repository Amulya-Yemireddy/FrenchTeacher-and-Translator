package com.example.basicfrench;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnimalnBirdActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<translation> translationList;

    basicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animaln_bird);
        recyclerView=findViewById(R.id.mammelsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        translationList = new ArrayList<>();
        translationList.add(new translation(R.raw.chat,"Chat","Cat"));
        translationList.add(new translation(R.raw.chien,"Chien","Dog"));
        translationList.add(new translation(R.raw.lapin,"lapin","Rabbit"));
        translationList.add(new translation(R.raw.sourus,"souris","Mouse"));
        translationList.add(new translation(R.raw.tortue,"tortue","Turtle"));
        translationList.add(new translation(R.raw.cheval,"cheval","Horse"));
        translationList.add(new translation(R.raw.chevre,"chèvre","Goat"));
        translationList.add(new translation(R.raw.cow,"vache","Cow"));
        translationList.add(new translation(R.raw.taureau,"taureau","Bull"));
        translationList.add(new translation(R.raw.daim,"daim","Deer"));
        translationList.add(new translation(R.raw.perroquet,"perroquet","Parrot"));
        translationList.add(new translation(R.raw.poissonrouge,"poisson rouge","Goldfish"));
        translationList.add(new translation(R.raw.coq,"coq","Rooster"));
        translationList.add(new translation(R.raw.tigre,"tigre","Tiger"));
        translationList.add(new translation(R.raw.pingouin,"pingouin","Penguin"));
        translationList.add(new translation(R.raw.aigle,"aigle","Eagle"));
        translationList.add(new translation(R.raw.colombe,"colombe","Dove"));
        translationList.add(new translation(R.raw.corbeau,"corbeau","Crow"));
        translationList.add(new translation(R.raw.cygne,"cygne","Swan"));
        translationList.add(new translation(R.raw.moineau,"moineau","Sparrow"));
        translationList.add(new translation(R.raw.pigeon," pigeon","Pigeon"));



        adapter =new basicAdapter(translationList,this);
        recyclerView.setAdapter(adapter);

    }
}