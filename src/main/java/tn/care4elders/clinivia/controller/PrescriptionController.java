package tn.care4elders.clinivia.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Medicine;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.entity.Prescription;
import tn.care4elders.clinivia.service.PatientService;
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
    PatientService patientService;

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

    @GetMapping("/unApproved")
    public List<Prescription> getAllUnapproved(){
        return prescriptionService.getAllUnapproved();
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

        return prescriptionService.updatePrescription( prescription);
    }

    @PostMapping("/Addmedicines/{prescriptionId}")
    public Prescription addMedicinesToPrescription(@PathVariable Long prescriptionId, @RequestBody List<Long> medicineIds) {
        return prescriptionService.addMedicinesToPrescription(prescriptionId, medicineIds);
    }

    @GetMapping("/GetMedicines/{prescriptionId}")
    public List<Medicine> getMedicinesByPrescriptionId(@PathVariable Long prescriptionId) {
        return prescriptionService.getMedicinesByPrescriptionId(prescriptionId);
    }


    @GetMapping("/GetPrescriptionsByPatient/{patientId}")
    public List<Prescription> getPrescriptionsByPatientId(@PathVariable Long patientId) {
        return      prescriptionService.getPrescriptionsByPatientId(patientId);
    }

    @GetMapping("/GetPrescriptionsByDoctor/{doctorId}")
    public List<Prescription> getPrescriptionsByDoctorId(@PathVariable Long doctorId) {
        return  prescriptionService.getPrescriptionsByDoctorId(doctorId);
    }

    //advanced functionality
    @PostMapping("/generateprescription/")
    public Prescription generatePrescription(@RequestBody Prescription prescription ) {

        return prescriptionService.generatePrescription(prescription);
    }
    @GetMapping("/stat/{doctorId}")
    public List<Integer> calculatePrescriptionStatisticsForDoctor(@PathVariable Long doctorId) {
        return  prescriptionService.calculatePrescriptionStatisticsForDoctor(doctorId);
    }



}
