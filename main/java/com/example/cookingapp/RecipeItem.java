package com.example.cookingapp;

import java.io.Serializable;

public class RecipeItem implements Serializable {

    private String name_of_recipe_Item;
    private String Ingredients_of_recipe_Item;
    private String Steps_of_recipe_Item;

    public RecipeItem(String name, String Ingr, String Steps)
    {
        name_of_recipe_Item = name;
        Ingredients_of_recipe_Item = Ingr;
        Steps_of_recipe_Item = Steps;
    }

    public void setNameOfRecipeItem(String name)
    {
        name_of_recipe_Item = name;
    }

    public String getNameOfRecipe_Item()
    {
        return name_of_recipe_Item;
    }

    public String getIngredientsOfRecipe_Item() { return Ingredients_of_recipe_Item; }

    public String getStepsOfRecipe_Item() { return Steps_of_recipe_Item; }

}
