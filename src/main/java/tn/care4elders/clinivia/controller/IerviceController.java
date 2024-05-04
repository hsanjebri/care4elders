package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Iervice;
import tn.care4elders.clinivia.service.IerviceService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/iervice")
public class IerviceController {
    IerviceService ierviceService;
    @PostMapping ("/add")
    public Iervice createIervice(@RequestBody Iervice iervice) {
        return ierviceService.saveIervice(iervice);
    }
    @GetMapping("/getbyid/{id}")
    public Iervice getIerviceById(@PathVariable("id") Long id) {
        return ierviceService.getIerviceById(id);
    }
    @PutMapping("/update")
    public Iervice updateIervice(@RequestBody Iervice iervice) {
        return ierviceService.updateIervice(iervice);
    }
    @GetMapping("/getall")
    public List<Iervice> getAllIervices() {
        return ierviceService.getAllIervices();
    }
    @DeleteMapping("/{id}")
    public void deleteIervice(@PathVariable("id") Long id) {
        ierviceService.deleteIervice(id);
    }
}
