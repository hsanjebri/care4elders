package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Complaints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int complaintID;
    private Date complaintDate;
    private String complaintDescription;
    private ComplaintStatus status;
    private Date resolutionDate;
    //with phone , email , or webapp
    private ComplaintChannel complaintChannel;
    //service to complain
    private ComplainedService service;
    private String compTitle;

}
