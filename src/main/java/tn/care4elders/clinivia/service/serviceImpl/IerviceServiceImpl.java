package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Iervice;
import tn.care4elders.clinivia.repository.IerviceRepository;
import tn.care4elders.clinivia.service.IerviceService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IerviceServiceImpl implements IerviceService {

    public IerviceRepository ierviceRepository;


    @Override
    public Iervice saveIervice(Iervice iervice) {
        return ierviceRepository.save(iervice);
    }

    @Override
    public Iervice getIerviceById(long IdService) {
        Optional<Iervice> ierviceOptional = ierviceRepository.findById(IdService);
            return ierviceOptional.orElse(null);
        }

    @Override
    public Iervice updateIervice(Iervice iervice) {
        return ierviceRepository.save(iervice);
    }



    @Override
    public List<Iervice> getAllIervices() {
        return ierviceRepository.findAll();
    }

    @Override
    public void deleteIervice(Long IdService) { ierviceRepository.deleteById(IdService);

    }


}
