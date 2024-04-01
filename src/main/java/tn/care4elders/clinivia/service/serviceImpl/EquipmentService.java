package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Equipment;
import tn.care4elders.clinivia.repository.EquipmentRepository;


import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipmentService implements tn.care4elders.clinivia.service.EquipmentService {

    EquipmentRepository equipmentRepo  ;

    @Override
    public Equipment addEquipment(Equipment equipment) {
        return (Equipment) equipmentRepo.save(equipment);
    }
    @Override
    public List<Equipment> getAllEquipments() {
        return (List<Equipment>) equipmentRepo.findAll();
    }
    @Override
    public Equipment getEquipmentById(long idEquipment) {
        return (Equipment) equipmentRepo.findById(idEquipment).get();
    }
    @Override
    public void deleteEquipment(long idEquipment) {
        equipmentRepo.deleteById(idEquipment);
    }
    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return (Equipment) equipmentRepo.save(equipment);
    }

    @Override
    public List<Integer> getCategoryItemCounts() {
        List<String> categories = equipmentRepo.findAllCategories();
        Map<String, Integer> categoryItemCounts = new HashMap<>();
        for (String category : categories) {
            List<Equipment> equipments = equipmentRepo.findEquipmentByCategory(category);
            categoryItemCounts.put(category, equipments.size());
        }

        // Convertir la map en une liste de nombres d'éléments
        List<Integer> itemCounts = new ArrayList<>(categoryItemCounts.values());
        return itemCounts;
    }


    @Override
    public List<String> getAllCategories() {
        return equipmentRepo.findAllCategories();
    }
}
