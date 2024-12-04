package org.LahyaniEya.App_Buro.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class DemandeReparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull @Setter
    private LocalDate dateDepotAppareil;
    @NonNull @Setter
    private LocalDate datePrevueRep;
    @NonNull @Setter
    private String etat;
    @NonNull @Setter
    private String symptomesPanne;

    @ManyToOne
    @NonNull @Setter
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

  
}
