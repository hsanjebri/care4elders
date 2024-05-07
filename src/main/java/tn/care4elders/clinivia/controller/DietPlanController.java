package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.DietPlan;
import tn.care4elders.clinivia.service.DietPlanService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dietplan")
@AllArgsConstructor
@CrossOrigin("*")

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

    @GetMapping("/assess/{patientId}")
    public ResponseEntity<Map<Date, Map<String, Object>>> assessNutritionalIntake(@PathVariable Long patientId) {
        Map<Date, Map<String, Object>> assessmentResults = dietPlanService.assessNutritionalIntake(patientId);
        if (assessmentResults.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assessmentResults, HttpStatus.OK);
    }
}