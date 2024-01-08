package tn.esprit.worker_examen.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Washing_Service")
public class Washing_Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idService")
    Long idService;

    float price;

    @Enumerated(EnumType.STRING)
    Type type;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "washingServiceList",fetch = FetchType.EAGER)
    List<Reservation> reservationList=new ArrayList<>();


}
