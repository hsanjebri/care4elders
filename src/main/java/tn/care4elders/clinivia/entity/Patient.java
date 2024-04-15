package tn.care4elders.clinivia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity


public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String img;
    private String gender;
    private String mobile;



    private String treatment;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String address;

    private String bGroup;



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
    private List<Appointment> appointmentList;


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
     List<Iervice> iervices;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private List<VitalSign> vitalSignList ;




}
