package tn.care4elders.clinivia.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Complaint;
import tn.care4elders.clinivia.service.ComplaintService;
import tn.care4elders.clinivia.service.PatientService;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/complaint")
@CrossOrigin("*")

public class ComplaintController {

    ComplaintService complaintService;

    @PostMapping("/add")
    public Complaint addComplaint(@RequestBody Complaint complaint) {
        return complaintService.saveComplaint(complaint);
    }

    @GetMapping ("/getbyid/{id}")
    public Complaint getComplaintById(@PathVariable("id") long id) {
        return complaintService.getComplaintById(id);
    }
    @PutMapping("/update")
    public Complaint updateComplaint(@RequestBody Complaint complaint) {
        return complaintService.updateComplaint(complaint);
    }
    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable("id") long id) {
        complaintService.deleteComplaint(id);
    }
    @GetMapping("/getall")
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }
}


