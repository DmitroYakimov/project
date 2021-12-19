package com.example.cookingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipesList_Adapter extends RecyclerView.Adapter<RecipesList_Adapter.ViewHolder> {
    private List<RecipeItem> listItems;
    private Context mContext;

    public RecipesList_Adapter(List<RecipeItem> listItems, Context mContext)
    {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecipesList_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
        return new RecipesList_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesList_Adapter.ViewHolder holder, int position) {
        final RecipeItem itemList = listItems.get(position);
        if(itemList!=null) {
            holder.NameOfRecipe.setText(itemList.getNameOfRecipe_Item());
            holder.ButtonOfRecipe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // КОД ОТКРЫТИЯ НОВОГО АКИТВИТИ С ТЕКСТОМ ИЗ АЙТЕМА РЕЦЕПТА
                    Intent intent = new Intent(mContext, RecipeActivity.class);
                    intent.putExtra("name", itemList.getNameOfRecipe_Item());
                    intent.putExtra("ingr", itemList.getIngredientsOfRecipe_Item());
                    intent.putExtra("steps", itemList.getStepsOfRecipe_Item());

                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(listItems.size() >= 1) return listItems.size();
        else return 0;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setRecipes (List<RecipeItem> list) {
        listItems.clear();
        listItems.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView NameOfRecipe;
        public Button ButtonOfRecipe;

        public ViewHolder(View itemView)
        {
            super(itemView);
            NameOfRecipe = (TextView) itemView.findViewById(R.id.name_of_recipe_item);
            ButtonOfRecipe = (Button) itemView.findViewById(R.id.item_button);
        }

    }

    public void setList(List<RecipeItem> list)
    {
        listItems = list;
        notifyDataSetChanged();
    }

}
