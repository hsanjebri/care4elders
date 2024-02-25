package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;



    @PostMapping("/add")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/getbyid/{id}")
    public Patient getPatientById(@PathVariable("id") long id) {
        return patientService.getPatientById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable("id") long id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/getall")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PutMapping("/update")
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient( patient);
    }

}
