package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Ambulance;
import java.util.Optional;
import java.util.List;

public interface AmbulanceService {
    Ambulance addAmbulance(Ambulance ambulance);
    Ambulance updateAmbulance(Ambulance ambulance);
    void deleteAmbulanceById(long Id);
    Optional<Ambulance> getAmbulanceById(long Id);
    List<Ambulance> getAllAmbulances();

}
