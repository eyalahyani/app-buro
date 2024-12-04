package org.LahyaniEya.App_Buro.Repository;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.Client;
import org.LahyaniEya.App_Buro.Model.DemandeReparation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeReparationRepository extends JpaRepository<DemandeReparation, Long> {

   public List<DemandeReparation> findByEtat(String Etat);
   
   public List<DemandeReparation> findByClient(Client Client);
   


  
}
