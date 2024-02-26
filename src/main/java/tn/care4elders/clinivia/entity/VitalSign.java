package tn.care4elders.clinivia.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class VitalSign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vitalSignId;


    private float bmi;

    private float heigh;

    private float weight;

    private String recordingLocation;

    private int heartRate;

    private String bloodPressure;

    private float respiratoryRate;

    private float temperature;

    private float oxygenSaturation;


    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateRecord;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private User user;

}