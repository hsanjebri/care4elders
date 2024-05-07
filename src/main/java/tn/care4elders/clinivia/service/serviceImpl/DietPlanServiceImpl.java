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



    public Map<Date, Map<String, Object>> assessNutritionalIntake(Long patientId) {
        // Retrieve the diet plans associated with the patient
        List<DietPlan> dietPlans = dietPlanRepository.findByPatientId(patientId);

        Map<Date, Map<String, Double>> dailyNutrients = new HashMap<>();
        Map<Date, Map<String, Object>> assessmentResults = new HashMap<>();

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

        // Generate assessment results and meal predictions for each date
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

            Map<String, Object> result = new HashMap<>();
            result.put("NutritionalAssessment", sb.toString());
            result.put("MealRecommendations", generateMealRecommendations(totals));

            assessmentResults.put(date, result);
        }

        return assessmentResults;
    }

    private List<String> generateMealRecommendations(Map<String, Double> totals) {
        List<String> recommendations = new ArrayList<>();

        if (isNutritionalIntakeBelowThreshold(totals)) {
            recommendations.addAll(predictMeals(totals));
        } else {
            recommendations.addAll(generateMealsForExcess(totals));
        }

        return recommendations;
    }

    private boolean isNutritionalIntakeBelowThreshold(Map<String, Double> totals) {
        return totals.get("Calories") < getAverageValue("Calories") ||
                totals.get("Protein") < getAverageValue("Protein") ||
                totals.get("Carbohydrates") < getAverageValue("Carbohydrates") ||
                totals.get("Fat") < getAverageValue("Fat") ||
                totals.get("Cholesterol") < getAverageValue("Cholesterol");
    }

    private List<String> generateMealsForExcess(Map<String, Double> totals) {
        List<String> recommendations = new ArrayList<>();

        if (totals.get("Calories") > getAverageValue("Calories")) {
            recommendations.add("Consider lighter meal options to reduce calorie intake, such as salads or vegetable soups.");
            recommendations.add("Focus on portion control and avoid high-calorie snacks to manage excess calorie intake.");
        }
        if (totals.get("Protein") > getAverageValue("Protein")) {
            recommendations.add("Maintain a balanced protein intake by incorporating more plant-based proteins like beans and lentils.");
            recommendations.add("Opt for lean protein sources and limit intake of high-fat meats to manage excess protein intake.");
        }
        if (totals.get("Carbohydrates") > getAverageValue("Carbohydrates")) {
            recommendations.add("Choose complex carbohydrates over simple sugars to regulate blood sugar levels.");
            recommendations.add("Balance carbohydrate intake with fiber-rich foods like vegetables and whole grains.");
        }
        if (totals.get("Fat") > getAverageValue("Fat")) {
            recommendations.add("Reduce consumption of high-fat foods like fried items and processed snacks to manage excess fat intake.");
            recommendations.add("Focus on heart-healthy fats from sources like nuts, seeds, and avocados.");
        }
        if (totals.get("Cholesterol") > getAverageValue("Cholesterol")) {
            recommendations.add("Limit intake of high-cholesterol foods like fatty meats and full-fat dairy products to manage excess cholesterol intake.");
            recommendations.add("Incorporate foods known to help lower cholesterol levels, such as oats, barley, and foods rich in soluble fiber.");
        }

        return recommendations;
    }

    private List<String> predictMeals(Map<String, Double> totals) {
        List<String> predictions = new ArrayList<>();

        if (totals.get("Calories") < getAverageValue("Calories")) {
            predictions.add("Consider having a high-calorie meal such as pasta with creamy sauce.");
            predictions.add("Try a hearty meal like beef stew with potatoes and vegetables.");
        }
        if (totals.get("Protein") < getAverageValue("Protein")) {
            predictions.add("Include protein-rich foods like grilled chicken or tofu in your meals.");
            predictions.add("Opt for meals containing lean meats such as turkey or fish.");
        }
        if (totals.get("Carbohydrates") < getAverageValue("Carbohydrates")) {
            predictions.add("Incorporate complex carbohydrates like brown rice or quinoa into your meals.");
            predictions.add("Try dishes made with whole wheat pasta or sweet potatoes.");
        }
        if (totals.get("Fat") < getAverageValue("Fat")) {
            predictions.add("Add healthy fats to your meals with avocado or olive oil.");
            predictions.add("Include nuts and seeds in your snacks for a source of healthy fats.");
        }
        if (totals.get("Cholesterol") < getAverageValue("Cholesterol")) {
            predictions.add("Opt for meals with ingredients known to help lower cholesterol, such as oats and legumes.");
            predictions.add("Include fatty fish like salmon or mackerel in your diet for heart-healthy omega-3 fatty acids.");
        }

        return predictions;
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
