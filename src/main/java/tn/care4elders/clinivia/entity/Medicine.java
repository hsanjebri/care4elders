package tn.care4elders.clinivia.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

    @Entity
    public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String m_name;
    private String medDescription;
    private String medDosage;
    @Enumerated(EnumType.STRING)
    private MedicineForm medForm;
    private String medPhoto ;

    @JsonIgnore
     @ManyToMany(mappedBy="medicines",fetch = FetchType.LAZY)
    private List<Prescription> prescriptions ;


}
