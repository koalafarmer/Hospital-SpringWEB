package ma.dante.ioc3.entities;
import jakarta.persistence.*;
import lombok.*;
import ma.dante.ioc3.entities.Patient;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Setter @Getter
public class RendezVous {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private boolean cancelled;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}