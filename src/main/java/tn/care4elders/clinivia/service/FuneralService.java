package tn.care4elders.clinivia.service;
import tn.care4elders.clinivia.entity.Ambulance;
import tn.care4elders.clinivia.entity.Funeral;
import java.util.Optional;
import java.util.List;


public interface FuneralService {

    Funeral addFuneral(Funeral funeral);

    Funeral updateFuneral(Funeral funeral);

    void deleteFuneralById(Long IdFuneral);

    Optional<Funeral> getFuneralById(long IdFuneral);

    List<Funeral> getAllFunerals();
}
