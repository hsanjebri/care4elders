package tn.care4elders.clinivia.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String img;
    private String name;
    private String email;

    private String gender;

    private String date;
    private  String time;

    private String mobile;
    private String doctor;

    private String injury;








    @ManyToOne
    Patient patient;


    @ManyToOne
    User user;




}
