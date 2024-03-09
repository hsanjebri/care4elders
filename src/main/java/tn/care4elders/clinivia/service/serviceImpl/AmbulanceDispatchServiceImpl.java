package tn.care4elders.clinivia.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.AmbulanceDispatch;
import tn.care4elders.clinivia.repository.AmbulanceDispatchRepository;
import tn.care4elders.clinivia.service.AmbulanceDispatchService;

import java.util.List;
import java.util.Optional;

@Service
public class AmbulanceDispatchServiceImpl implements AmbulanceDispatchService {
    AmbulanceDispatchRepository ambulanceDispatchRepository;

    @Autowired
    public AmbulanceDispatchServiceImpl(AmbulanceDispatchRepository ambulanceDispatchRepository) {
        this.ambulanceDispatchRepository = ambulanceDispatchRepository;
    }

    @Override
    public AmbulanceDispatch addAmbulanceDispatch(AmbulanceDispatch ambulanceDispatch) {
        return ambulanceDispatchRepository.save(ambulanceDispatch);
    }

    @Override
    public AmbulanceDispatch updateAmbulanceDispatch(AmbulanceDispatch ambulanceDispatch) {
        return ambulanceDispatchRepository.save(ambulanceDispatch);
    }

    @Override
    public void deleteAmbulanceDispatch(long Id) {
        ambulanceDispatchRepository.deleteById(Id);
    }

    @Override
    public Optional<AmbulanceDispatch> getAmbulanceDispatchById(long Id) {
        return ambulanceDispatchRepository.findById(Id);
    }

    @Override
    public List<AmbulanceDispatch> getAllAmbulanceDispatches() {
        return ambulanceDispatchRepository.findAll();
    }
}
