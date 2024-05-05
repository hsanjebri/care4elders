package tn.care4elders.clinivia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String d_No;
    private String d_Name;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date d_Date;
    private String d_Head;
    private String status;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "department")
    private List<User> users;
}
