package tn.esprit.worker_examen.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    Long idReservation;

    LocalDateTime timereservation;

    @Enumerated(EnumType.STRING)
    Status status;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    Worker worker;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Washing_Service> washingServiceList=new ArrayList<>();



}
