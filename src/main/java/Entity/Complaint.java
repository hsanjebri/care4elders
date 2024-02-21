package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdComplaints;

    @Temporal(TemporalType.DATE)
    private Date complaintDate;

    private String complaintDescription;

    private boolean status;

    @Temporal(TemporalType.DATE)
    private Date resolutionDate;
    //with phone , email , or webapp
    private ComplaintChannel complaintChannel;
    //service to complain
    @Enumerated(EnumType.STRING)
    private ComplainedService service;


    private String compTitle;


    @ManyToOne
    Patient patient;

}
