package tn.care4elders.clinivia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("iad")
    private long IdUser;

    @JsonProperty("name")
    private String Name;

    private String Password;


    private String email;

    @JsonProperty("date")
    private Date BirthDay;

    private String Address;

    private Integer zipCode;

    private String city;

    private String country;

    private String img;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonProperty("mobile")
    private String Phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonProperty("degree")
    private String LicenceDetails;

    @JsonProperty("specialization")
    private String MedicalSpecialities;

    private String department;

    private String EducationalBackground;

    private String WorkHistory;

    private String EmergencyContact;

    private String AvailabilityShift;

    private String designation;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Task> tasks;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Schedule> schedules;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Event> events;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Iervice> services;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Notification> notifications;


    @OneToOne
    private AmbulanceDispatch ambulanceDispatch;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<AmbulanceDispatch> ambulanceDispatchList;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<VitalSign> vitalSignList ;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="doctor")
    private List<Prescription> prescriptions;

}
}
