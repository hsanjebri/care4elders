package tn.care4elders.clinivia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import tn.care4elders.clinivia.repository.MedicineRepository;

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
    @Transient
    private List<Medicine> Allmedicines;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    Patient patient;
    @JsonIgnore

    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Medicine> medicines;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    User doctor;

  /**  public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
        medicine.setPrescriptions(this); // Set bidirectional relationship


   }*/


}
