package com.ank.springboot.repositories;

import com.ank.springboot.domain.Recepie;
import org.springframework.data.repository.CrudRepository;

public interface RecepieRepository extends CrudRepository<Recepie,Long> {
}
