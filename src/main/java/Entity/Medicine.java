package Entity;



import jakarta.persistence.*;
import lombok.*;

    import java.util.Date;

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
}
