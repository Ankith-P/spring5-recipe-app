package com.ank.springboot.service;

import com.ank.springboot.domain.Recipe;
import com.ank.springboot.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeServiceImpl;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeServiceImpl=new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe recipe=new Recipe();
        HashSet<Recipe> recipeHashSet=new HashSet<>();
        recipeHashSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeHashSet);
        Set<Recipe> recipes= recipeServiceImpl.getRecipes();
        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }
}