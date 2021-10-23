package com.ank.springboot.repositories;

import com.ank.springboot.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
