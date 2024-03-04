package tn.care4elders.clinivia.service;

import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Complaint;

import java.util.List;

@Service
public interface ComplaintService {
      Complaint saveComplaint(Complaint complaint);

     Complaint getComplaintById(long IdComplaints);
    void deleteComplaint(long IdComplaints);
    List<Complaint> getAllComplaints();

    Complaint updateComplaint(Complaint complaint);
}
