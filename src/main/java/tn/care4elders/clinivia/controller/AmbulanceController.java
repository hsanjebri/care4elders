package tn.care4elders.clinivia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Ambulance;
import tn.care4elders.clinivia.entity.AmbulanceDispatch;
import tn.care4elders.clinivia.service.AmbulanceDispatchService;
import tn.care4elders.clinivia.service.AmbulanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ambulance")

public class AmbulanceController {
    AmbulanceService ambulanceService;
    @Autowired
    public AmbulanceController(AmbulanceService ambulanceService) {
        this.ambulanceService = ambulanceService;
    }
    @PostMapping("/add")
    public ResponseEntity<Ambulance> addAmbulance(@RequestBody Ambulance ambulance) {
        Ambulance addedAmbulance = ambulanceService.addAmbulance(ambulance);
        return new ResponseEntity<>(addedAmbulance, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Ambulance> updateAmbulance(@RequestBody Ambulance ambulance){
        Ambulance updatedAmbulance = ambulanceService.updateAmbulance(ambulance);
        return new ResponseEntity<>(updatedAmbulance,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Void> deleteAmbulanceById(@PathVariable long Id){
        ambulanceService.deleteAmbulanceById(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
     @GetMapping("/get/{Id}")
    public ResponseEntity<Ambulance> getAmbulanceById(@PathVariable long Id){
        Optional<Ambulance> ambulance = ambulanceService.getAmbulanceById(Id);
         return ambulance.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                 .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }
    @GetMapping("/getall")
    public ResponseEntity<List<Ambulance>> getAllAmbulances() {
        List<Ambulance> ambulances = ambulanceService.getAllAmbulances();
        return new ResponseEntity<>(ambulances, HttpStatus.OK);
    }
}
