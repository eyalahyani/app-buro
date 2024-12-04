package org.LahyaniEya.App_Buro.Service;

import java.util.List;
import org.LahyaniEya.App_Buro.Model.DemandeReparation;

public interface DemandeReparationService {

	public List<DemandeReparation> findAllDemandeReparation();
	public List<DemandeReparation> findDemandeReparationByEtat(String etat);
	public DemandeReparation findDemandeReparationById(Long id);
	public DemandeReparation addDemandeRepration(DemandeReparation demandeRep);
	public DemandeReparation updateDemandeRepration(DemandeReparation demandeRep);
	public void deleteDemandeReparation(DemandeReparation demandeRep);
}
