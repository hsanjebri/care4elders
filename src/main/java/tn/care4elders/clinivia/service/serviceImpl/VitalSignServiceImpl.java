package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.VitalSign;
import tn.care4elders.clinivia.repository.VitalSignRepository;
import tn.care4elders.clinivia.service.VitalSignService;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class VitalSignServiceImpl implements VitalSignService {
    VitalSignRepository vitalSignRepository;

    @Override
    public VitalSign saveVitalSign(VitalSign vitalSign) {
        return vitalSignRepository.save(vitalSign);
    }

    @Override
    public VitalSign getVitalSignById(long id) {
        Optional<VitalSign> vitalSignOptional = vitalSignRepository.findById(id);
        return vitalSignOptional.orElse(null);
    }

    @Override
    public void deleteVitalSign(long id) {
        vitalSignRepository.deleteById(id);
    }

    @Override
    public List<VitalSign> getAllVitalSigns() {
        return vitalSignRepository.findAll();
    }

    @Override
    public VitalSign updateVitalSign(VitalSign vitalSign) {
        return vitalSignRepository.save(vitalSign);
    }
}
