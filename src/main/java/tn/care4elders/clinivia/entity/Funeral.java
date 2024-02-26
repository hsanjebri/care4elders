package tn.care4elders.clinivia.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Funeral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFuneral;

    private String funeralServiceProvider;


    private String contactPersonForArrangements;

    private String contactPersonRelationshipToPatient;

    private String contactPersonPhoneNumber;

    private Double estimatedFuneralExpenses;


    @OneToOne(mappedBy="funeral")
    private Patient patient;
<<<<<<< HEAD
=======

    public Long getId() {
        return IdFuneral;
    }

    public void setId(Long IdFuneral) {
        this.IdFuneral = IdFuneral;
    }
>>>>>>> f3fbe0b539a83b2e7f2879c24731565a30e2d4cc
}