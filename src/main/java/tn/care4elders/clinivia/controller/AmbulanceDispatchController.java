package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import tn.care4elders.clinivia.repository.AmbulanceDispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.service.AmbulanceDispatchService;
import tn.care4elders.clinivia.entity.AmbulanceDispatch;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/ambulancedispatch")
public class AmbulanceDispatchController {
     AmbulanceDispatchService ambulanceDispatchService;

    @Autowired
    public AmbulanceDispatchController(AmbulanceDispatchService ambulanceDispatchService) {
        this.ambulanceDispatchService = ambulanceDispatchService;
    }

    @PostMapping
    public ResponseEntity<AmbulanceDispatch> addAmbulanceDispatch(@RequestBody AmbulanceDispatch ambulanceDispatch) {
        AmbulanceDispatch addedDispatch = ambulanceDispatchService.addAmbulanceDispatch(ambulanceDispatch);
        return new ResponseEntity<>(addedDispatch, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AmbulanceDispatch> updateAmbulanceDispatch(@RequestBody AmbulanceDispatch ambulanceDispatch) {
        AmbulanceDispatch updatedDispatch = ambulanceDispatchService.updateAmbulanceDispatch(ambulanceDispatch);
        return new ResponseEntity<>(updatedDispatch, HttpStatus.OK);
    }

    @DeleteMapping("/{dispatchId}")
    public ResponseEntity<Void> deleteAmbulanceDispatch(@PathVariable long dispatchId) {
        ambulanceDispatchService.deleteAmbulanceDispatch(dispatchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{dispatchId}")
    public ResponseEntity<AmbulanceDispatch> getAmbulanceDispatchById(@PathVariable long dispatchId) {
        Optional<AmbulanceDispatch> dispatch = ambulanceDispatchService.getAmbulanceDispatchById(dispatchId);
        return dispatch.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AmbulanceDispatch>> getAllAmbulanceDispatches() {
        List<AmbulanceDispatch> dispatches = ambulanceDispatchService.getAllAmbulanceDispatches();
        return new ResponseEntity<>(dispatches, HttpStatus.OK);
    }
}
