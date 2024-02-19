package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientID;

    private String patientName;

    private String patientPassword;

    @Temporal(TemporalType.DATE)
    private Date patientBirthDay;

    private String patientAddress;

    @Enumerated(EnumType.STRING)
    private Gender Gender;

    private String patientPhone;

    private String patientContactEmergencies;

    private String patientMedicalHistroy;

    @Enumerated(EnumType.STRING)
    private Alergies patientAlergies;

    private String patientCurrentMedication;

    private String patientChrinicConditions;

    private String patientInsuranceConditions;

    private String patientInsurancePolicy;



}
