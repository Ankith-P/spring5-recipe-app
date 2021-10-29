package com.ank.springboot.recepie.controllers;

import com.ank.springboot.domain.Recipe;
import com.ank.springboot.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    @Mock
   // RecipeRepository recipeRepository;
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController indexController;
    @BeforeEach
    void setUp() {
    //   recipeService=new RecipeServiceImpl(recipeRepository);

        MockitoAnnotations.openMocks(this);
        indexController=new IndexController(recipeService);
    }



    @Test
    void getIndex()  {
//        when(recipeRepository.get)
//        recipeService.
//;
        Set<Recipe> recipes=new HashSet<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        when(recipeService.getRecipes()).thenReturn(recipes);
                String viewName=indexController.getIndex(model);

        ArgumentCaptor<Set<Recipe>> argumentCaptor=ArgumentCaptor.forClass(Set.class);
        assertEquals("index",viewName);
        verify(recipeService,times(1)).getRecipes();
        //verify(model,times(1)).addAttribute(eq("recipes"),anySet());
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        Set<Recipe> setInController=argumentCaptor.getValue();
        assertEquals(1,setInController.size());
    }

    @Test
    void mockMVC() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
}