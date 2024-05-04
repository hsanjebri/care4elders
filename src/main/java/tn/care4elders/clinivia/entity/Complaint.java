package tn.care4elders.clinivia.entity;

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
    private long Id;
    private String mno;
    private String mname;
    private String category;
    private String company;
    @Temporal(TemporalType.DATE)
    private Date pdate;
    private String price;
    @Temporal(TemporalType.DATE)
    private Date edate;
    private String stock;


    @ManyToOne
    Patient patient;

}
