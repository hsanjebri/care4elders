package tn.care4elders.clinivia.service.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.care4elders.clinivia.entity.Complaint;
import tn.care4elders.clinivia.repository.ComplaintRepository;
import tn.care4elders.clinivia.service.ComplaintService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ComplaintServiceImpl implements ComplaintService {
    public ComplaintRepository complaintRepository;
    @Override
    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint getComplaintById(long IdComplaints) {
        Optional<Complaint> optionalComplaint = complaintRepository.findById(IdComplaints);
        return optionalComplaint.orElse(null);
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public void deleteComplaint(long IdComplaints) {
        complaintRepository.deleteById(IdComplaints);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

}
