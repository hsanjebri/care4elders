package Entity;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

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


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Task> tasks;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Schedule> schedules;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Event> events;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Service> services;


   @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
   private List<Notification> notifications;


}
