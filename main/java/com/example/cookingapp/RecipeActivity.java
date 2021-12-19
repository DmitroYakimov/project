package com.example.cookingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecipeActivity extends Activity {

    private Button goBackButton;
    private TextView TVNameOfDish;
    private TextView TVIngredientsOfDish;
    private TextView TVStepsOfDish;

    private String NameOfDish;
    private String IngredientsOfDish;
    private String StepsOfDish;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        goBackButton = (Button) findViewById(R.id.recipe_button_back);
        TVNameOfDish = (TextView) findViewById(R.id.dish_name);
        TVIngredientsOfDish = (TextView) findViewById(R.id.ingredient_field);
        TVStepsOfDish = (TextView) findViewById(R.id.steps_field);

        Intent intent = getIntent();
        NameOfDish = intent.getStringExtra("name");
        IngredientsOfDish = intent.getStringExtra("ingr");
        StepsOfDish = intent.getStringExtra("steps");

        TVNameOfDish.setText(NameOfDish);
        TVIngredientsOfDish.setText(IngredientsOfDish);
        TVStepsOfDish.setText(StepsOfDish);

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
