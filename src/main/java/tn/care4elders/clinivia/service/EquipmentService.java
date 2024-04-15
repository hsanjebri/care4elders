package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment addEquipment(Equipment equipment);
    List<Equipment> getAllEquipments();
    Equipment getEquipmentById(long idEquipment);
    void deleteEquipment(long idEquipment);
    Equipment updateEquipment(Equipment Equipment);


}
