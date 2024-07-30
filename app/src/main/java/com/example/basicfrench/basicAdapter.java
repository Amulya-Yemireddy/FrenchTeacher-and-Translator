package com.example.basicfrench;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class basicAdapter extends RecyclerView.Adapter<basicAdapter.MyViewHolder> {

    public List<translation> translationList;
    public Context context;

    public basicAdapter(List<translation> translationList, Context context) {
        this.translationList = translationList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View translationView= LayoutInflater.from(parent.getContext()).inflate(R.layout.french_words,parent,false);
        return new MyViewHolder(translationView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        translation trans=translationList.get(position);
        holder.num.setText(String.valueOf(position+1));
        holder.frenchwords.setText(trans.getTransFrench());
        holder.englishwords.setText(trans.getTransEnglish());

        holder.soundbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                playSound(trans.getTranslationbtn());
            }
        });
    }

    @Override
    public int getItemCount() {
        return translationList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView num;
        TextView frenchwords;
        TextView englishwords;
        Button soundbtn;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            num=itemView.findViewById(R.id.numb);
            frenchwords=itemView.findViewById(R.id.french);
            englishwords=itemView.findViewById(R.id.english);
            soundbtn=itemView.findViewById(R.id.button);
        }
    }

    private void playSound(int soundResourceId){
        MediaPlayer mediaPlayer= MediaPlayer.create(context,soundResourceId);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }


        });
    }
}
