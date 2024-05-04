package tn.care4elders.clinivia.service;
import tn.care4elders.clinivia.entity.AmbulanceDispatch;
import java.util.Optional;
import java.util.List;

public interface AmbulanceDispatchService {
    AmbulanceDispatch addAmbulanceDispatch(AmbulanceDispatch ambulanceDispatch);

    AmbulanceDispatch updateAmbulanceDispatch(AmbulanceDispatch ambulanceDispatch);

    void deleteAmbulanceDispatch(long dispatchId);

    Optional<AmbulanceDispatch> getAmbulanceDispatchById(long dispatchId);

    List<AmbulanceDispatch> getAllAmbulanceDispatches();
}
