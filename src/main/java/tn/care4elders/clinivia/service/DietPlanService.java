package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.DietPlan;

import java.util.List;

public interface DietPlanService {

    DietPlan saveDietPlan(DietPlan dietPlan);
    DietPlan getDietPlanById(Long id);
    void deleteDietPlan(Long id);
    List<DietPlan> getAllDietPlans();
    DietPlan updateDietPlan(DietPlan dietPlan);
}
