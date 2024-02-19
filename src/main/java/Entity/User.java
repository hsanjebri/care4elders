package Entity;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdUser;

    private String Name;

    private String Password;

    private String Email;

    private Date BirthDay;

    private String Address;

    private Integer zipCode;

    private String city;

    private String country;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String Phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String LicenceDetails;

    private String MedicalSpecialities;

    private String EducationalBackground;

    private String WorkHistory;

    private String EmergencyContact;

    private String AvailabilityShift;
}
