package org.LahyaniEya.App_Buro.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Reparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @NonNull
    private LocalDate dateRep;
    @Setter
    @NonNull
    private String description;
    
    @Setter
    @NonNull
    private double tarifHMO;
    
    @Setter     @NonNull
    private int tempsMO;

    @OneToOne      @NonNull
    @JoinColumn(name = "demande_reparation_id", nullable = false)
    @Setter
    private DemandeReparation demandeReparation;

   
}
