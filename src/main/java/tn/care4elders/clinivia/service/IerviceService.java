package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Iervice;

import java.util.List;

public interface IerviceService {
    Iervice saveIervice(Iervice iervice);
    Iervice getIerviceById(long IdService);
    Iervice updateIervice(Iervice iervice);
    List<Iervice> getAllIervices();
    void deleteIervice(Long IdService);


}
