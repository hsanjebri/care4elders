package tn.care4elders.clinivia.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Medicine;

import tn.care4elders.clinivia.service.MedicineService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin("*")
@RequestMapping("Medicines/")

public class MedicineController {
    MedicineService medicineService ;

    // Order 1
    @PostMapping("add")
    public Medicine addingMedicine(@RequestBody Medicine medicine){
        return medicineService.addMedicine(medicine);
    }

    // Order 2
    @GetMapping("getAll")
    public List<Medicine> gettingAllMedicines(){
        return medicineService.getAllMedicines();
    }

    // Order 3
    @GetMapping("get")
    public Medicine gettingMedicine (@RequestParam("idMedicine") long idMedicine){
        return medicineService.getMedicineById(idMedicine);
    }

    // Order 4
    @DeleteMapping("delete/{idMedicine}")
    public void deletingMedicine(@PathVariable("idMedicine") long idMedicine){
        medicineService.deleteMedicine(idMedicine);
    }

    // Order 5
    @PutMapping("update")
    public Medicine updatingMedicine(@RequestBody Medicine medicine){
        return medicineService.updateMedicine(medicine);
    }
}
