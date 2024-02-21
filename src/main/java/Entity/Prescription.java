package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


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
    private Long IdPres;
    private String medicamentList;
    private String medInstruction;

    @Temporal(TemporalType.DATE)
    private Date medExpireDate;


    @ManyToOne
    Patient patient;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Medicine> medicines;


}
