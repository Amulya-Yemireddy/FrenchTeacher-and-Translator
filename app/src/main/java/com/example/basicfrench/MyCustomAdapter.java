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

public class MyCustomAdapter extends ArrayAdapter<learn> {
    private ArrayList<learn> learnArrayList;
    Context context;


    public MyCustomAdapter(ArrayList<learn> learnArreyList,Context context ) {
        super(context, R.layout.front_view_layout,learnArreyList);
        this.learnArrayList=learnArreyList;
        this.context=context;
    }
    private static class MyViewHolder{
        TextView learnText;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        learn use=getItem(position);
        MyViewHolder myViewHolder;

        if(convertView == null){
            myViewHolder=new MyViewHolder();
            LayoutInflater inflator=LayoutInflater.from(getContext());
            convertView=inflator.inflate(R.layout.front_view_layout,parent,false);
            myViewHolder.learnText=(TextView) convertView.findViewById(R.id.whatYouWant);
            convertView.setTag(myViewHolder);
        }else{
            myViewHolder=(MyViewHolder) convertView.getTag();
        }

        myViewHolder.learnText.setText(use.getFunction());
        return convertView;
    }
}
