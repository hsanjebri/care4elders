package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.MealRecommendation;
import tn.care4elders.clinivia.repository.MealRecommendationRepository;
import tn.care4elders.clinivia.service.MealRecommendationService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MealRecommendationImpl implements MealRecommendationService {


    MealRecommendationRepository mealRecommendationRepository;


    @Override
    public MealRecommendation saveMealRecommendation(MealRecommendation mealRecommendation) {
        return mealRecommendationRepository.save(mealRecommendation);
    }

    @Override
    public MealRecommendation getMealRecommendationById(Long id) {
        Optional<MealRecommendation> mealRecommendationOptional = mealRecommendationRepository.findById(id);
        return mealRecommendationOptional.orElse(null);
    }

    @Override
    public void deleteMealRecommendation(Long id) {
        mealRecommendationRepository.deleteById(id);
    }

    @Override
    public List<MealRecommendation> getAllMealRecommendations() {
        return mealRecommendationRepository.findAll();
    }

    @Override
    public MealRecommendation updateMealRecommendation(MealRecommendation mealRecommendation) {
        return mealRecommendationRepository.save(mealRecommendation);
    }
}
