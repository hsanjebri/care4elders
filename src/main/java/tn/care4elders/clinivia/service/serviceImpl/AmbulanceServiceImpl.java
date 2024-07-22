package tn.care4elders.clinivia.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.repository.AmbulanceRepository;
import tn.care4elders.clinivia.service.AmbulanceService;
import tn.care4elders.clinivia.entity.Ambulance;
import java.util.List;
import java.util.Optional;
@Service
public class AmbulanceServiceImpl implements AmbulanceService {
    AmbulanceRepository ambulanceRepository;
    @Autowired
    public AmbulanceServiceImpl(AmbulanceRepository ambulanceRepository){
        this.ambulanceRepository=ambulanceRepository;
    }
    @Override
    public Ambulance addAmbulance(Ambulance ambulance){
        return ambulanceRepository.save(ambulance);
    }
    @Override
    public Ambulance updateAmbulance(Ambulance ambulance){
        return ambulanceRepository.save(ambulance);
    }
    @Override
    public void deleteAmbulanceById(long Id){
        ambulanceRepository.deleteById(Id);
    }
    @Override
    public Optional<Ambulance> getAmbulanceById(long Id){
        return ambulanceRepository.findById(Id);
    }
    @Override
    public List<Ambulance>getAllAmbulances(){
        return ambulanceRepository.findAll();
    }


}
