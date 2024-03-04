package tn.care4elders.clinivia.entity;



import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

    @Entity
    public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdMedecin;

    private String medName;
    private String medDescription;
    private String medDosage;

    @Enumerated(EnumType.STRING)
    private MedicineForm medForm;

    private String medInteraction;
    private String medPhoto ;
}
