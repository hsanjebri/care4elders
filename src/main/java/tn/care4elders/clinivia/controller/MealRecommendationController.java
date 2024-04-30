package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.MealRecommendation;
import tn.care4elders.clinivia.service.MealRecommendationService;

import java.util.List;

@RestController
@RequestMapping("/mealrecommendation")
@AllArgsConstructor
@CrossOrigin("*")

public class MealRecommendationController {
    MealRecommendationService mealRecommendationService;

    @PostMapping("/add")
    public MealRecommendation createMealRecommendation(@RequestBody MealRecommendation mealRecommendation) {
        return mealRecommendationService.saveMealRecommendation(mealRecommendation);
    }

    @GetMapping("/getbyid/{id}")
    public MealRecommendation getMealRecommendationById(@PathVariable("id") Long id) {
        return mealRecommendationService.getMealRecommendationById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMealRecommendation(@PathVariable("id") Long id) {
        mealRecommendationService.deleteMealRecommendation(id);
    }

    @GetMapping("/getall")
    public List<MealRecommendation> getAllMealRecommendations() {
        return mealRecommendationService.getAllMealRecommendations();
    }

    @PutMapping("/update")
    public MealRecommendation updateMealRecommendation(@RequestBody MealRecommendation mealRecommendation) {
        return mealRecommendationService.updateMealRecommendation(mealRecommendation);
    }
}
