package org.LahyaniEya.App_Buro.Model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PieceRechange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String code;
    
    @Column(nullable = false)
    @NonNull 
    private String nom;
    
    @NonNull
    private int qteDisp;
    @NonNull
    private double prixAchat;
    @NonNull
    private double prixHT;
    @Getter(AccessLevel.NONE)
    private double prixTTC;
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "type_piece_id", nullable = false)
    @NonNull 
    private TypePiece typePiece;
    @Column(nullable = false)
    private double TVA = 0.19;
    public double getPrixTTC() {
        return this.prixHT + (this.prixHT * this.getTVA());
    }
    
}