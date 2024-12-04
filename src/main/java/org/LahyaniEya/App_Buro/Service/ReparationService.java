package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.Reparation;

public interface ReparationService {
	
	public List<Reparation> findAllReparation();
	public Reparation findReparationById(Long id);
	public Reparation addReparation(Reparation r);
	public Reparation updateRepration(Reparation r);
	public void deleteReparation(Reparation r);

}
