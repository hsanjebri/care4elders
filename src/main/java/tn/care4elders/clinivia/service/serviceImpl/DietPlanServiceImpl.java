package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.DietPlan;
import tn.care4elders.clinivia.entity.MealRecommendation;
import tn.care4elders.clinivia.repository.DietPlanRepository;
import tn.care4elders.clinivia.service.DietPlanService;

import java.util.*;

@Service
@AllArgsConstructor
public class DietPlanServiceImpl implements DietPlanService  {

            DietPlanRepository dietPlanRepository ;
    @Override
    public DietPlan saveDietPlan(DietPlan dietPlan) {
            return  dietPlanRepository.save(dietPlan);

                }

    @Override
    public DietPlan getDietPlanById(Long id) {
        Optional<DietPlan> dietPlanOptional = dietPlanRepository.findById(id);
        return dietPlanOptional.orElse(null);
    }

    @Override
    public void deleteDietPlan(Long id) {
        dietPlanRepository.deleteById(id);
    }

    @Override
    public List<DietPlan> getAllDietPlans() {
        return dietPlanRepository.findAll();
    }

    @Override
    public DietPlan updateDietPlan(DietPlan dietPlan) {
        return dietPlanRepository.save(dietPlan);
    }



    public Map<Date, String> assessNutritionalIntake(Long patientId) {
        // Retrieve the diet plans associated with the patient
        List<DietPlan> dietPlans = dietPlanRepository.findByPatientId(patientId);

        Map<Date, Map<String, Double>> dailyNutrients = new HashMap<>();
        Map<Date, String> assessmentResults = new HashMap<>();

        // Iterate through each diet plan of the patient
        for (DietPlan dietPlan : dietPlans) {
            if (dietPlan != null && dietPlan.getMealRecommendations() != null) {
                for (MealRecommendation recommendation : dietPlan.getMealRecommendations()) {
                    Date date = recommendation.getRecommendationDate();
                    dailyNutrients.putIfAbsent(date, new HashMap<String, Double>() {{
                        put("Calories", 0.0);
                        put("Protein", 0.0);
                        put("Carbohydrates", 0.0);
                        put("Fat", 0.0);
                        put("Cholesterol", 0.0);
                    }});

                    Map<String, Double> totals = dailyNutrients.get(date);
                    totals.compute("Calories", (k, v) -> v + recommendation.getCalories());
                    totals.compute("Protein", (k, v) -> v + recommendation.getProtein());
                    totals.compute("Carbohydrates", (k, v) -> v + recommendation.getCarbohydrates());
                    totals.compute("Fat", (k, v) -> v + recommendation.getFat());
                    totals.compute("Cholesterol", (k, v) -> v + recommendation.getCholesterol());
                }
            }
        }

        // Generate assessment results for each date
        for (Map.Entry<Date, Map<String, Double>> entry : dailyNutrients.entrySet()) {
            Date date = entry.getKey();
            Map<String, Double> totals = entry.getValue();
            StringBuilder sb = new StringBuilder();

            sb.append("Nutritional assessment for ").append(date).append(":\n");
            totals.forEach((nutrient, value) -> {
                double avgValue = getAverageValue(nutrient);
                double missingValue = avgValue - value;
                if (value < avgValue) {
                    sb.append("  - ").append(nutrient).append(": ").append(value)
                            .append(" (below average, missing ").append(missingValue).append(" to reach average)\n");
                } else {
                    sb.append("  - ").append(nutrient).append(": ").append(value).append(" (meets or exceeds average)\n");
                }
            });

            assessmentResults.put(date, sb.toString());
        }

        return assessmentResults;
    }

    private double getAverageValue(String nutrient) {
        switch (nutrient) {
            case "Calories":
                return 2500; // Average daily calorie intake for adults
            case "Protein":
                return 56; // Recommended Dietary Allowance (RDA) for adult men
            case "Carbohydrates":
                return 130; // Estimated Average Requirement (EAR) for adults
            case "Fat":
                return 78; // Acceptable Macronutrient Distribution Range (AMDR) for adults
            case "Cholesterol":
                return 300; // Recommended daily intake limit for adults
            default:
                return 0.0; // Default value
        }
    }

}
