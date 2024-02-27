package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.MealRecommendation;

import java.util.List;

public interface MealRecommendationService {

    MealRecommendation saveMealRecommendation(MealRecommendation mealRecommendation);
    MealRecommendation getMealRecommendationById(Long id);
    void deleteMealRecommendation(Long id);
    List<MealRecommendation> getAllMealRecommendations();
    MealRecommendation updateMealRecommendation(MealRecommendation mealRecommendation);
}
