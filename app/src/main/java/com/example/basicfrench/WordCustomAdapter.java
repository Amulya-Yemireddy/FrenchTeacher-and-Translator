package com.example.basicfrench;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordCustomAdapter extends ArrayAdapter<word> {

    ArrayList<word> wordArrayList;
    Context context;


    public WordCustomAdapter(ArrayList<word> wordArrayList, Context context) {
        super(context, R.layout.word_view_layout,wordArrayList);
        this.wordArrayList=wordArrayList;
        this.context=context;
    }

    private static class MyViewHolder{
        TextView wordType;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        word word_type=getItem(position);
        MyViewHolder myViewHolder;

        if(convertView==null){
            myViewHolder=new MyViewHolder();
            LayoutInflater inflator=LayoutInflater.from(getContext());
            convertView=inflator.inflate(R.layout.word_view_layout,parent,false);
            myViewHolder.wordType=(TextView) convertView.findViewById(R.id.textView5);
            convertView.setTag(myViewHolder);
        }else{
            myViewHolder=(MyViewHolder) convertView.getTag();
        }
        myViewHolder.wordType.setText(word_type.getType_word());
        return convertView;
    }
}
