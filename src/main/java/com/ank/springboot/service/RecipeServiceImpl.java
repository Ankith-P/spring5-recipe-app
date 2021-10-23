package com.ank.springboot.service;

import com.ank.springboot.domain.Recipe;
import com.ank.springboot.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        Iterator<Recipe> res=recipeRepository.findAll().iterator();

        System.out.println("printing 1st");
        while(res.hasNext())
        {
            System.out.println("printing"+res.next());
        }
        return recipeSet;
    }
}