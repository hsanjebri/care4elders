package tn.care4elders.clinivia.service;
import tn.care4elders.clinivia.entity.AmbulanceDispatch;
import java.util.Optional;
import java.util.List;

public interface AmbulanceDispatchService {
    AmbulanceDispatch addAmbulanceDispatch(AmbulanceDispatch ambulanceDispatch);

    AmbulanceDispatch updateAmbulanceDispatch(AmbulanceDispatch ambulanceDispatch);

    void deleteAmbulanceDispatch(long Id);

    Optional<AmbulanceDispatch> getAmbulanceDispatchById(long Id);

    List<AmbulanceDispatch> getAllAmbulanceDispatches();
}
