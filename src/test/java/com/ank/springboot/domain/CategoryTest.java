package com.ank.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    Category category;
    @BeforeEach
    void setUp()
    {
    category=new Category();
    }

    @Test
    void getDescription() {

    }

    @Test
    void getRecipes() {
    }

    @Test
    void getId() {
        Long idVal=4l;
        category.setId(idVal);
        assertEquals(idVal+1,category.getId());
    }
}