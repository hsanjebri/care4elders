package tn.care4elders.clinivia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Date;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String prescPhoto ;
    private String diseases ;
    private String EmailPatient ;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    private String description ;
    private Long doctor_id ;
    private Long ppatient_id ;
    private String symptoms;
    //for the generator
    private boolean approved ;
    private String suggestedMedicines;
    private String doctor_name ;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    Patient patient;
    @JsonIgnore

    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Medicine> medicines;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    User doctor;



}
