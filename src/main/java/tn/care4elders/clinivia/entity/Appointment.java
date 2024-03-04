package tn.care4elders.clinivia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long IdAppointment;
    private String firstName;
    private String lastName;
    private Gender gender;

    private String mobile;
    private String address;

    private String Email;

    private String Ilness;

    private String appointmentStatus;

    private String Note;
    private String file;

    @Temporal(TemporalType.DATE)
    private Date dateOfAppointment;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;




    @ManyToOne
    Patient patient;


    @ManyToOne
    User user;




}
