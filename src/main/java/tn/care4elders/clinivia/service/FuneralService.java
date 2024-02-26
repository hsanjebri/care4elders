package tn.care4elders.clinivia.service;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Funeral;
import java.util.Optional;
import java.util.List;


@Service
public interface FuneralService {

    Funeral addFuneralForPatient(Long IdPatient, Funeral funeral);

    Funeral updateFuneralForPatient(Long IdPatient, Funeral funeral);

    void deleteFuneralForPatient(Long IdPatient);

    Optional<Funeral> getFuneralForPatient(Long IdPatient);

    List<Funeral> getAllFunerals();
}
