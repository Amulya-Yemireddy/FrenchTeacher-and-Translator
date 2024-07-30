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

public class BasicWordsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<translation> translationList;

    basicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_basic_words);
        recyclerView=findViewById(R.id.basicrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the translation list with data
        translationList = new ArrayList<>();
        translationList.add(new translation(R.raw.bojure, "Bonjour","Hello or good morning"));
        translationList.add(new translation(R.raw.aurevoir," Au revoir","Goodbye"));
        translationList.add(new translation(R.raw.oui,"Oui","Yes"));
        translationList.add(new translation(R.raw.non,"Non","No"));
        translationList.add(new translation(R.raw.merci,"Merci","Thank you"));
        translationList.add(new translation(R.raw.mercibeaucoup,"Merci beaucoup","Thank you very much"));
        translationList.add(new translation(R.raw.fille,"Fille","Girl"));
        translationList.add(new translation(R.raw.garcon,"Garçon","Boy"));
        translationList.add(new translation(R.raw.femme,"Femme","Female"));
        translationList.add(new translation(R.raw.homme,"Homme","Man"));
        translationList.add(new translation(R.raw.amour,"Amour","Love"));
        translationList.add(new translation(R.raw.francais,"français","French"));
        translationList.add(new translation(R.raw.silvousplait,"s’il vous plaît","Please (literally, “if you please”)"));
        translationList.add(new translation(R.raw.bonsoir,"bonsoir","Good Evening"));
        translationList.add(new translation(R.raw.bonnenuit,"bonne nuit","Good night"));
        translationList.add(new translation(R.raw.excusezmoi,"excusez-moi","Excuse me"));
        translationList.add(new translation(R.raw.derien,"De rien","A casual way of saying “you’re welcome”"));
        translationList.add(new translation(R.raw.jevousenprie,"Je vous en prie","A formal way to say “you’re welcome”"));
        translationList.add(new translation(R.raw.temps,"Temps","Time"));
        translationList.add(new translation(R.raw.jour,"Jour","Day"));
        translationList.add(new translation(R.raw.monde,"Monde","World"));
        translationList.add(new translation(R.raw.monsieur,"Monsieur","Mister or gentleman"));
        translationList.add(new translation(R.raw.raison,"Raison","Reason"));
        translationList.add(new translation(R.raw.mademoiselle,"Mademoiselle","Miss, referring to an unmarried woman"));
        translationList.add(new translation(R.raw.madam,"Madame","a married or older woman"));
        translationList.add(new translation(R.raw.beau,"Beau","Handsome"));
        translationList.add(new translation(R.raw.belle,"Belle","Beauty"));
        translationList.add(new translation(R.raw.chat,"Chat","Cat"));
        translationList.add(new translation(R.raw.chien,"Chien","dog"));
        translationList.add(new translation(R.raw.fort,"Fort","Strong"));

        adapter =new basicAdapter(translationList,this);
        recyclerView.setAdapter(adapter);
    }
}