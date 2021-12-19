package com.example.cookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Repices extends AppCompatActivity implements SearchView.OnQueryTextListener {

    //ArrayList<Recipe> recipes = new ArrayList<>();
    ArrayList<RecipeItem> listItems;
    //RecipeAdapter recipeAdapter;
    RecipesList_Adapter recipeAdapter;
    SearchView searchView;
    RecyclerView userRecycler;
    private Button button;

   // String namesOfDefaultRecipe[], descriptionsOfDefaultRecipe[], ingredientsOfDefaultRecipe[];

    @Override
    protected void onCreate(Bundle savedInstanceRecipe) {
        super.onCreate(savedInstanceRecipe);
        setContentView(R.layout.activity_repices);
        //namesOfDefaultRecipe = getResources().getStringArray(R.recipes1);
        //descriptionsOfDefaultRecipe = getResources().getStringArray(R.array.description);
        //ingredientsOfDefaultRecipe = getResources().getStringArray(R.array.ingredients);
        button = (Button) findViewById(R.id.add_new_recipe_button);
        //recipeAdapter =  new RecipeAdapter(this, s1, s2, s3);
        searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(this);

        listItems = new ArrayList<>();

        //for(int i = 0; i < namesOfDefaultRecipe.length; i++)
       // {
            //listItems.add(new RecipeItem(namesOfDefaultRecipe[i], ingredientsOfDefaultRecipe[i], descriptionsOfDefaultRecipe[i]));
            listItems.add(new RecipeItem(getResources().getString(R.string.name1), getResources().getString(R.string.ingredients1), getResources().getString(R.string.description1)));
            listItems.add(new RecipeItem(getResources().getString(R.string.name2), getResources().getString(R.string.ingredients2), getResources().getString(R.string.description2)));
            listItems.add(new RecipeItem(getResources().getString(R.string.name3), getResources().getString(R.string.ingredients3), getResources().getString(R.string.description3)));
            listItems.add(new RecipeItem(getResources().getString(R.string.name4), getResources().getString(R.string.ingredients4), getResources().getString(R.string.description4)));
        //}

        //setInitialData();
        setUserRecycler();
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goToAddDish();
            }
        });
    }

    private void setInitialData() {
        //recipes.add(new Recipe("Жаркое по-деревенски"));
        //recipes.add(new Recipe("Жюльен с курицей и грибами"));
        //recipes.add(new Recipe("Фаршированный картофель в духовке"));
        //recipes.add(new Recipe("Куриные рулеты с сыром"));
        //recipes.add(new Recipe("Рассыпчатый плов с курицей"));

    }

    private void setUserRecycler() {

        userRecycler = findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        userRecycler.setHasFixedSize(true);
        userRecycler.setLayoutManager(new LinearLayoutManager(this));
        recipeAdapter= new RecipesList_Adapter(listItems, this);
        userRecycler.setAdapter(recipeAdapter);

        recipeAdapter.setList(listItems);
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        if (!s.isEmpty()) {
            recipeAdapter.setRecipes(filter(s));
        } else {
            recipeAdapter.setRecipes(listItems);
        }
        return false;
    }


    public List<RecipeItem> filter(String str) {
        List<RecipeItem> tempList = new ArrayList<>();
        for (RecipeItem recipe : listItems) {
            if (recipe.getNameOfRecipe_Item().toLowerCase().contains(str.toLowerCase())) tempList.add(recipe);
        }
        return tempList;
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 420)
        {
            String name = data.getStringExtra("name");
            String ingredients = data.getStringExtra("ingr");
            String steps = data.getStringExtra("steps");

            listItems.add(new RecipeItem(name, ingredients, steps));
            recipeAdapter.setList(listItems);

        }

    }
    public void goToAddDish() {
        Intent intent = new Intent(this, AddDishActivity.class);
        startActivityForResult(intent, 420);
    }

}