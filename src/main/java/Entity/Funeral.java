package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
}