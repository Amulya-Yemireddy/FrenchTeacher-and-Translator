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

public class SentenceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<translation> translationList;

    basicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sentence);
        recyclerView=findViewById(R.id.sentencerecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        translationList=new ArrayList<>();
        translationList.add(new translation(R.raw.idontunderstand,"Je ne comprends pas","I don't understand"));
        translationList.add(new translation(R.raw.doyouspeakenglish,"Parlez-vous anglais?","Do you speak English?"));
        translationList.add(new translation(R.raw.howmuch,"Combine","How much?"));
        translationList.add(new translation(R.raw.please,"S’il vous plaît","Please"));
        translationList.add(new translation(R.raw.iamsorry,"Je suis désolé","I am sorry"));
        translationList.add(new translation(R.raw.iwouldlike,"Je voudrais...","I would like..."));
        translationList.add(new translation(R.raw.nonotatall,"Non, pas du tout","No, not at all"));
        translationList.add(new translation(R.raw.wherearewe,"Où sommes-nous?","Where are we?"));
        translationList.add(new translation(R.raw.canyouhelpme,"Pourriez-vous m’aider?","Can you help me?"));
        translationList.add(new translation(R.raw.pleaserepeat,"Répétez s'il vous plaît","Please repeat"));
        translationList.add(new translation(R.raw.iamlookingforthisaddress,"Je cherche cette adresse","I am looking for this address"));
        translationList.add(new translation(R.raw.howmuchisit,"C’est combien?","How much is it?"));
        translationList.add(new translation(R.raw.itstooexpensive,"C’est trop cher!","It’s too expensive!"));
        translationList.add(new translation(R.raw.whatsyourname,"Comment vous appelez-vous?","What’s your name?"));
        translationList.add(new translation(R.raw.mynameis,"Je m’appelle…","My name is…"));
        translationList.add(new translation(R.raw.pleasedtomeetyou,"Enchantée !","Pleased to meet you!"));
        translationList.add(new translation(R.raw.whereareyoufrom,"D’où venez-vous ?","Where are you from?"));
        translationList.add(new translation(R.raw.iamfrom,"Je viens de…","I’m from…"));
        translationList.add(new translation(R.raw.howareyou,"Comment allez-vous ? ","How are you?"));
        translationList.add(new translation(R.raw.iamfineandyou,"Je vais bien, et vous ?","I am fine, and you?"));
        translationList.add(new translation(R.raw.iwouldliketotrythison,"Je voudrais essayer ceci","I would like to try this on"));

        adapter=new basicAdapter(translationList,this);
        recyclerView.setAdapter(adapter);


    }
}