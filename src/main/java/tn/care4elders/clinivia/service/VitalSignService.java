package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.VitalSign;

import java.util.List;

public interface VitalSignService {
    VitalSign saveVitalSign(VitalSign vitalSign);

    VitalSign getVitalSignById(long id);

    void deleteVitalSign(long id);

    List<VitalSign> getAllVitalSigns();

    VitalSign updateVitalSign(VitalSign vitalSign);
}
