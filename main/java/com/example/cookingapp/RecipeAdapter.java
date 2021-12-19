package com.example.cookingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    List<Recipe> recipes = new ArrayList<>();
    String data1[], data2[], data3[];
    Context context;

    public RecipeAdapter(Context ct, String s1[], String s2[], String s3[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setRecipes (List<Recipe> list) {
        recipes.clear();
        recipes.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Recipe state = recipes.get(position);
        holder.nameView.setText(state.getName());
        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Recipe1.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("data3", data3[position]);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        ConstraintLayout main;


        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.name_of_recipe_item);
            main = itemView.findViewById(R.id.main);
        }
    }
}
