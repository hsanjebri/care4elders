package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdEvent;

    private String eventName;

    @Temporal(TemporalType.DATE)
    private Date eventDate;

    private String eventLocation;

    private String eventDescription;

    private String eventAttachment;

    @Enumerated(EnumType.STRING)
    private EventType eventType;


    @ManyToMany(mappedBy="events", cascade = CascadeType.ALL)
    private List<Patient> patients;



    @ManyToOne
    User user;


}
