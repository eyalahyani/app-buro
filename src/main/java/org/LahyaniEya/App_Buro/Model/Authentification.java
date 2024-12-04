package org.LahyaniEya.App_Buro.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Authentification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Setter
    @NonNull
    @Column(unique = true, nullable = false)
    private String email;
    @Setter
    @NonNull
    private String mdp;
    
    
    @Setter
    private int role;
    
    public Authentification(@NonNull String email, @NonNull String mdp, int role) {
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

}
