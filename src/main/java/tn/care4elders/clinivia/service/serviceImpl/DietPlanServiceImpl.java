package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.DietPlan;
import tn.care4elders.clinivia.repository.DietPlanRepository;
import tn.care4elders.clinivia.service.DietPlanService;

import java.util.List;
import java.util.Optional;

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
}
