package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Recipe1 extends AppCompatActivity {
    TextView recipes, description, ingredients;
    String data1, data2, data3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe1);

        recipes = findViewById(R.id.title);
        description = findViewById(R.id.description);
        ingredients = findViewById(R.id.ingredients);
        getData();
        setData();
    }
    private void getData(){
        if(getIntent().hasExtra("data1")&&getIntent().hasExtra("data2")&&getIntent().hasExtra("data3")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        recipes.setText(data1);
        description.setText(data2);
        ingredients.setText(data3);
    }
}