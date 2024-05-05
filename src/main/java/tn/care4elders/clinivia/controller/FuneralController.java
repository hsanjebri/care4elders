package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import tn.care4elders.clinivia.repository.FuneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.service.FuneralService;
import tn.care4elders.clinivia.entity.Funeral;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/funerals")
public class FuneralController {
    FuneralService funeralService;
    @Autowired
    public FuneralController(FuneralService funeralService) {
        this.funeralService = funeralService;
    }

    @PostMapping("/add/{IdPatient}")
    public ResponseEntity<Funeral> addFuneral(@PathVariable Long IdPatient, @RequestBody Funeral funeral) {
        Funeral addedFuneral = funeralService.addFuneralForPatient(IdPatient, funeral);
        return addedFuneral != null
                ? new ResponseEntity<>(addedFuneral, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Funeral> updateFuneral(@PathVariable Long IdPatient, @RequestBody Funeral funeral) {
        Funeral updatedFuneral = funeralService.updateFuneralForPatient(IdPatient, funeral);
        return updatedFuneral != null
                ? new ResponseEntity<>(updatedFuneral, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{IdPatient}")
    public ResponseEntity<Void> deleteFuneral(@PathVariable Long IdPatient) {
        funeralService.deleteFuneralForPatient(IdPatient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{IdPatient}")
    public ResponseEntity<Funeral> getFuneral(@PathVariable Long IdPatient) {
        Optional<Funeral> funeral = funeralService.getFuneralForPatient(IdPatient);
        return funeral.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Funeral>> getAllFunerals() {
        List<Funeral> funerals = funeralService.getAllFunerals();
        return new ResponseEntity<>(funerals, HttpStatus.OK);
    }
}
