package tn.care4elders.clinivia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

<<<<<<< HEAD
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

=======

@AllArgsConstructor
@NoArgsConstructor
@Data
>>>>>>> f3fbe0b539a83b2e7f2879c24731565a30e2d4cc
@Entity


public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPatient;

<<<<<<< HEAD
    private String patientName;
=======
    private String name;
>>>>>>> f3fbe0b539a83b2e7f2879c24731565a30e2d4cc

    private String patientPassword;

    @Temporal(TemporalType.DATE)
<<<<<<< HEAD
    private Date patientBirthDay;

    private String patientAddress;
=======
    private Date date;

    private String address;

    private String bGroup;
>>>>>>> f3fbe0b539a83b2e7f2879c24731565a30e2d4cc

    @Enumerated(EnumType.STRING)
    private Gender Gender;

<<<<<<< HEAD
    private String patientPhone;

    private String patientContactEmergencies;

    private String patientMedicalHistroy;
=======
    private String mobile;

    private String patientContactEmergencies;

    private String MedicalHistroy;
>>>>>>> f3fbe0b539a83b2e7f2879c24731565a30e2d4cc

    @Enumerated(EnumType.STRING)
    private Alergie patientAlergies;

<<<<<<< HEAD
    private String patientCurrentMedication;
=======
    private String treatment;
>>>>>>> f3fbe0b539a83b2e7f2879c24731565a30e2d4cc



    @OneToOne
    private Funeral funeral;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<Payment> payments;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<Prescription> prescriptions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<DietPlan> dietPlans;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<FeedBack> feedBacks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<Complaint> complaints;


    @OneToOne
    private AmbulanceDispatch ambulanceDispatch;

    @OneToOne
    private Subscription subscription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<RendezVous> rendezVousList;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<Task> tasks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<Notification> notifications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<Equipment> equipments;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Event> events;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
     List<Service> services;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<VitalSign> vitalSignList ;




}
