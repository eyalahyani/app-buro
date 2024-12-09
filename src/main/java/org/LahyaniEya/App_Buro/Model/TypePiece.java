package org.LahyaniEya.App_Buro.Model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class TypePiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private String type;
    
    @NonNull
    private double tarifh;
}
