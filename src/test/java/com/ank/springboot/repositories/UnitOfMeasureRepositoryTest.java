package com.ank.springboot.repositories;

import com.ank.springboot.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryTest {
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DirtiesContext
    void findByDescription() {
        Optional<UnitOfMeasure> uomOptional =unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon",uomOptional.get().getDescription());
    }
    @Test
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> uomOptional =unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup",uomOptional.get().getDescription());
    }
}