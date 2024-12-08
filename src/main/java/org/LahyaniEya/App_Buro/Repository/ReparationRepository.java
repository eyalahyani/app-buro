package org.LahyaniEya.App_Buro.Repository;

import org.LahyaniEya.App_Buro.Model.Reparation;
import org.LahyaniEya.App_Buro.Model.DemandeReparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ReparationRepository extends JpaRepository<Reparation, Long> {
    boolean existsByDemandeReparation(DemandeReparation demandeReparation);
    @Query("SELECT r.id FROM Reparation r WHERE r.demandeReparation.id = :demandeReparationId")
    Long findReparationIdByDemandeReparationId(@Param("demandeReparationId") Long demandeReparationId);
   }
