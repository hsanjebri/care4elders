package tn.care4elders.clinivia.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Equipment;
import tn.care4elders.clinivia.service.EquipmentService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("Equipments")

public class EquipmentController {
    EquipmentService equipmentService ;

    // Order 1
    @PostMapping("/add")
    public Equipment addingEquipment(@RequestBody Equipment equipment){
        return equipmentService.addEquipment(equipment);
    }

    // Order 2
    @GetMapping("/getAll")
    public List<Equipment> gettingAllEquipments(){
        return equipmentService.getAllEquipments();
    }

    // Order 3
    @GetMapping("/get")
    public Equipment gettingEquipment(@RequestParam("idEquipment") long idEquipment){
        return equipmentService.getEquipmentById(idEquipment);
    }

    // Order 4
    @DeleteMapping("/delete/{idEquipment}")
    public void deletingEquipment(@PathVariable("idEquipment") long idEquipment){
        equipmentService.deleteEquipment(idEquipment);
    }

    // Order 5
    @PutMapping("/update")
    public Equipment updatingEquipment(@RequestBody Equipment equipment){
        return equipmentService.updateEquipment(equipment);
    }
}
