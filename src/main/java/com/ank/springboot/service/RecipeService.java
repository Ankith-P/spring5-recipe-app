package com.ank.springboot.service;


import com.ank.springboot.commands.RecipeCommand;
import com.ank.springboot.domain.Recipe;

import java.util.Set;


/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}