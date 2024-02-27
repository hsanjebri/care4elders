package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.VitalSign;
import tn.care4elders.clinivia.service.VitalSignService;

import java.util.List;

@RestController
@RequestMapping("/vitalSigns")
@AllArgsConstructor
public class VitalSignController {

     VitalSignService vitalSignService;

    @PostMapping("/add")
    public VitalSign createVitalSign(@RequestBody VitalSign vitalSign) {
        return vitalSignService.saveVitalSign(vitalSign);
    }

    @GetMapping("/getById/{id}")
    public VitalSign getVitalSignById(@PathVariable("id") long id) {
        return vitalSignService.getVitalSignById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteVitalSign(@PathVariable("id") long id) {
        vitalSignService.deleteVitalSign(id);
    }

    @GetMapping("/getAll")
    public List<VitalSign> getAllVitalSigns() {
        return vitalSignService.getAllVitalSigns();
    }

    @PutMapping("/update")
    public VitalSign updateVitalSign(@RequestBody VitalSign vitalSign) {
        return vitalSignService.updateVitalSign(vitalSign);
    }
}
