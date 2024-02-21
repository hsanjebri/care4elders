package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPatient;

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
    private Alergie patientAlergies;

    private String patientCurrentMedication;

    private String patientChrinicConditions;

    private String patientInsuranceConditions;

    private String patientInsurancePolicy;



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

}
