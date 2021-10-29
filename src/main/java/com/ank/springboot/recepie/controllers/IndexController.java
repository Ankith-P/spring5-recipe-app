package com.ank.springboot.recepie.controllers;

import com.ank.springboot.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
/*

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
*/

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @RequestMapping({"","/","/index","/index.html"})
    public String getIndex(Model model)
    {
        log.debug("In index page using lombok");
      /*  Optional<Category> categoryOptional=categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional=unitOfMeasureRepository.findByDescription("Pinch");
        System.out.println("Printing values for test DJ ank");
        System.out.println("category Id is "+categoryOptional.get().getId());
        System.out.println("Unit of Measure Id is "+unitOfMeasureOptional.get().getId());*/
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }

}
