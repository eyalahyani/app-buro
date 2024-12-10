package org.LahyaniEya.App_Buro.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull @Setter
    @Column(unique = true, nullable = false)
    private String numero;
    
    @NonNull @Setter
    private LocalDate date;
    @Setter
    private double montantTotalHTX;

    @Setter
    private double montantTotalTVA;

    @Setter
    private double montantTotal;

    @OneToOne     @NonNull @Setter
    @JoinColumn(name = "reparation_id", nullable = false)
    private Reparation reparation;
}