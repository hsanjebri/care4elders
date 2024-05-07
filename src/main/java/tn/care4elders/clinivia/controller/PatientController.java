package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Alergie;
import tn.care4elders.clinivia.entity.Patient;
import tn.care4elders.clinivia.service.PatientService;
import tn.care4elders.clinivia.service.SMSService;
import tn.care4elders.clinivia.service.TwillioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
@CrossOrigin("*")
public class PatientController {

     PatientService patientService;
     TwillioService twillioService;
        SMSService smsService ;


    @PostMapping("/add")
    public Patient createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);

        // Customize the SMS message to include patient information
        String message = "New patient added: " + savedPatient.getName() +
                ". Address: " + savedPatient.getAddress() +
                ". Mobile: " + savedPatient.getMobile() +
                ". Date of Birth: " + savedPatient.getDate();

        // Send SMS to the specified number
        String toPhoneNumber = "+21623671593"; // Update with your recipient's phone number
        //smsService.sendSMS(toPhoneNumber, message);

        return savedPatient;
    }

    @GetMapping("/getbyid/{id}")
    public Patient getPatientById(@PathVariable("id") long id) {
        return patientService.getPatientById(id);
    }


    @DeleteMapping("/delete/{id}")
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



        @GetMapping("/{patientId}/task-completion-percentage")
        public double getTaskCompletionPercentage(@PathVariable("patientId") long patientId) {
            return patientService.calculateTaskCompletionPercentage(patientId);
        }
    //shadha

    @GetMapping("/getPatientByAdresse/{address}")
    public Patient getPatientByAddress(@PathVariable("address") String address) { return patientService.getPatientByEmail(address);


    }


    @GetMapping("/rarest-blood-type-distribution")
    public void displayRarestBloodTypeDistribution() {
        patientService.displayRarestBloodTypeDistribution();
    }



    @GetMapping("/common-allergies")
    public Map<Alergie, Integer> getCommonPatientAllergies() {
        List<Patient> allPatients = patientService.getAllPatients();
        return patientService.countCommonPatientAllergies(allPatients);
    }
}
