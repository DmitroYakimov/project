package com.example.cookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddDishActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dish);
    }

    public void cancelAdd(View view){
        finish();
    }

    public void applyAdd(View view){

        final EditText name = (EditText) findViewById(R.id.set_name_of_dish);
        final EditText ingredients = (EditText) findViewById(R.id.set_ingredients);
        final EditText steps = (EditText) findViewById(R.id.set_steps);

        if(name.length() >= 1 && ingredients.length() >= 1 && steps.length() >= 1) {
            Intent intent = new Intent();
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("ingr", ingredients.getText().toString());
            intent.putExtra("steps", steps.getText().toString());

            setResult(420, intent);
        }

        finish();

    }


}
