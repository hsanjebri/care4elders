package tn.care4elders.clinivia.entity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class AmbulanceDispatch {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long Id;
        private String case_no;
        private String patient_name;
        private String gender;
        private String date;
        private String vehicule_no;
        private String driver_name;
        private String driver_no;
        private String patient_address;
        private String note;


        @OneToOne
        private Patient patient;

        @ManyToOne
        private User user;


}
