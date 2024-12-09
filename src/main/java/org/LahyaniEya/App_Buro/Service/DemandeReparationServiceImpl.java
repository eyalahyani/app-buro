package org.LahyaniEya.App_Buro.Service;

import java.util.List;
import org.LahyaniEya.App_Buro.Model.DemandeReparation;
import org.LahyaniEya.App_Buro.Repository.DemandeReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@NoArgsConstructor
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class DemandeReparationServiceImpl implements DemandeReparationService {
	@Autowired
	private DemandeReparationRepository demandeReparationRepo;

	@Override
	public List<DemandeReparation> findAllDemandeReparation() {
        return demandeReparationRepo.findAll();
     }



	@Override
	public List<DemandeReparation> findDemandeReparationByEtat(String etat) {
        return demandeReparationRepo.findByEtat(etat);
	}

	@Override
	public DemandeReparation findDemandeReparationById(Long id) {
        return demandeReparationRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Demande not found with ID: " + id));
	}

	@Override
	public DemandeReparation addDemandeRepration(DemandeReparation demandeRep) {
    	return demandeReparationRepo.save(demandeRep);
	}

	@Override
	public DemandeReparation updateDemandeRepration(DemandeReparation DemandeRep) {

		DemandeReparation demandeReparation = this.findDemandeReparationById(DemandeRep.getId()); 
        if (demandeReparation!=null) {
			demandeReparation.setClient(DemandeRep.getClient());
			demandeReparation.setDateDepotAppareil(DemandeRep.getDateDepotAppareil());
			demandeReparation.setDatePrevueRep(DemandeRep.getDatePrevueRep());
			demandeReparation.setEtat(DemandeRep.getEtat());
			demandeReparation.setSymptomesPanne(DemandeRep.getSymptomesPanne());
        	return this.addDemandeRepration(demandeReparation);
        }
		else{
			 return this.addDemandeRepration(DemandeRep);
		}
	}

	@Override
	public void deleteDemandeReparation(DemandeReparation demandeRep) {
		DemandeReparation demandeReparation = demandeReparationRepo.getReferenceById(demandeRep.getId()); 
        if (demandeReparation!=null) {
			demandeReparationRepo.deleteById(demandeRep.getId());
        }		
	}
	
	
	
	

}
