package tn.care4elders.clinivia.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Medicine;
import tn.care4elders.clinivia.entity.Prescription;
import tn.care4elders.clinivia.service.PrescriptionService;


import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("Prescriptions")

public class PrescriptionController {

    PrescriptionService prescriptionService ;

    // Order 1
    @PostMapping("/add")
    public Prescription addingPrescription(@RequestBody Prescription prescription  ){
        return prescriptionService.addPrescription(prescription );
    }

    // Order 2
    @GetMapping("/getAll")
    public List<Prescription> gettingAllPrescriptions(){
        return prescriptionService.getAllPrescriptions();
    }

    // Order 3
    @GetMapping("/get")
    public Prescription gettingPrescription (@RequestParam("idPrescription") long idPrescription){
        return prescriptionService.getPrescriptionById(idPrescription);
    }

    // Order 4
    @DeleteMapping("/delete/{idPrescription}")
    public void deletingPrescription(@PathVariable("idPrescription") long idPrescription){
        prescriptionService.deletePrescription(idPrescription);
    }

    // Order 5
    @PutMapping("/update")
    public Prescription updatingPrescription(@RequestBody Prescription prescription){
        return prescriptionService.updatePrescription(prescription);
    }



}
