package org.LahyaniEya.App_Buro.Service;

import java.util.List;
import org.LahyaniEya.App_Buro.Model.Reparation;
import org.LahyaniEya.App_Buro.Repository.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@NoArgsConstructor
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class ReparationServiceImpl implements ReparationService {
	@Autowired
	private ReparationRepository reparationRepo;
	
	@Override
	public List<Reparation> findAllReparation() {
        return reparationRepo.findAll();
	}

	@Override
	public Reparation findReparationById(Long id) {
		return reparationRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Reparation not found with ID: " + id));
	}

	@Override
	public Reparation addReparation(Reparation r) {
	    return reparationRepo.save(r);
	}

	@Override
	public Reparation updateRepration(Reparation reparation) {
	    Reparation r = this.findReparationById(reparation.getId());
	    
	    if (r != null) {
	        r.setDateRep(reparation.getDateRep());
	        r.setDescription(reparation.getDescription());
	        r.setTarifHMO(reparation.getTarifHMO());
	        r.setTempsMO(reparation.getTempsMO());
	        
	        if (reparation.getDemandeReparation() != null) {
	            r.setDemandeReparation(reparation.getDemandeReparation());
	        } else {
	            throw new RuntimeException("DemandeReparation cannot be null.");
	        }

	        return this.addReparation(r);
	    } else {
	        return this.addReparation(reparation);
	    }
	}


	@Override
	public void deleteReparation(Reparation reparation) {
      	Reparation r=reparationRepo.getReferenceById(reparation.getId());
        if (r!=null) {
        	reparationRepo.deleteById(reparation.getId());
        }
	}

	
	
}