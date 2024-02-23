package tn.care4elders.clinivia.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdRdv;

    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    private String appointmentStatus;

    @ManyToOne
    Patient patient;




}
