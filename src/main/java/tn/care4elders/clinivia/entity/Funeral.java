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

    private String IdPatient;

    private String funeralServiceProvider;


    private String contactPersonForArrangements;

    private String contactPersonRelationshipToPatient;

    private String contactPersonPhoneNumber;

    private String estimatedFuneralExpenses;


    @OneToOne(mappedBy="funeral")
    private Patient patient;

    public Long getId() {
        return IdFuneral;
    }

    public void setId(Long IdFuneral) {
        this.IdFuneral = IdFuneral;
    }
}