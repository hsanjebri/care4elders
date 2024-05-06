package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import tn.care4elders.clinivia.entity.Ambulance;
import tn.care4elders.clinivia.entity.AmbulanceDispatch;
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
@CrossOrigin("*")
public class FuneralController {
    FuneralService funeralService;
    @Autowired
    public FuneralController(FuneralService funeralService) {
        this.funeralService = funeralService;
    }

    @PostMapping("/add")
    public ResponseEntity<Funeral> addFuneral(@RequestBody Funeral funeral) {
        Funeral addedFuneral = funeralService.addFuneral(funeral);
        return new ResponseEntity<>(addedFuneral, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Funeral> updateFuneral(@RequestBody Funeral funeral){
        Funeral updatedFuneral = funeralService.updateFuneral(funeral);
        return new ResponseEntity<>(updatedFuneral,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{IdFuneral}")
    public ResponseEntity<Void> deleteFuneralById(@PathVariable long IdFuneral){
        funeralService.deleteFuneralById(IdFuneral);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{IdPatient}")
    public ResponseEntity<Funeral> getFuneralById(@PathVariable long IdFuneral){
        Optional<Funeral> funeral = funeralService.getFuneralById(IdFuneral);
        return funeral.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Funeral>> getAllFunerals() {
        List<Funeral> funerals = funeralService.getAllFunerals();
        return new ResponseEntity<>(funerals, HttpStatus.OK);
    }
}
