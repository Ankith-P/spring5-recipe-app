package com.ank.springboot.repositories;

import com.ank.springboot.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {

}
