package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.DietPlan;
import tn.care4elders.clinivia.service.DietPlanService;

import java.util.List;

@RestController
@RequestMapping("/dietplan")
@AllArgsConstructor
public class DietPlanController {

    DietPlanService dietPlanService;



    @PostMapping("/add")
    public DietPlan createDietPlan(@RequestBody DietPlan dietPlan) {
        return dietPlanService.saveDietPlan(dietPlan);
    }

    @GetMapping("/get/{id}")
    public DietPlan getDietPlanById(@PathVariable("id") Long id) {
        return dietPlanService.getDietPlanById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDietPlan(@PathVariable("id") Long id) {
        dietPlanService.deleteDietPlan(id);
    }

    @GetMapping("/getall")
    public List<DietPlan> getAllDietPlans() {
        return dietPlanService.getAllDietPlans();
    }

    @PutMapping("/update")
    public DietPlan updateDietPlan(@RequestBody DietPlan dietPlan) {
        return dietPlanService.updateDietPlan(dietPlan);
    }
}
