package org.LahyaniEya.App_Buro.Model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 150)
    @Setter
    @NonNull
    private String nom;

    @Column(unique = true, nullable = false,length = 8)
    @Setter
    @NonNull
    private String numTel;

    @NonNull
    @Setter
    private String adresse;
}
