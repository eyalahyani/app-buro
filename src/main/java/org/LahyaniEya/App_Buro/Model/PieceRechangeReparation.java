package org.LahyaniEya.App_Buro.Model;

import lombok.*;

import org.hibernate.annotations.Check;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"idpiece","idreparation"}))
public class PieceRechangeReparation {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	@Check(constraints="qte<>0")
    private int qte;

    @ManyToOne
    @JoinColumn(name="idpiece", nullable=false)
    private PieceRechange pieceRechange;

    @ManyToOne
    @JoinColumn(name="idreparation" , nullable=false)
    private Reparation reparation;

	
    @Column(nullable = false)
    private double prixPieceRechangeReparationHTX;

   
    
}