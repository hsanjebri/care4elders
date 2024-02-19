package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    private String Name;

    private String Password;

    private String Email;

    private int BirthDay;

    private String Address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String Phone;

    @Enumerated(EnumType.STRING)
    private JobTitle JobTitle;

    private String LicenceDetails;

    private String MedicalSpecialities;

    private String EducationalBackground;

    private String WorkHistory;

    private String EmergencyContact;

    private String AvailabilityShift;
}
