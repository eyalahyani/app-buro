package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.PieceRechange;
import org.LahyaniEya.App_Buro.Model.PieceRechangeReparation;
import org.LahyaniEya.App_Buro.Model.Reparation;

public interface PieceRechangeReparationService {
	public List<PieceRechangeReparation> findAllPieceRechangeReparation();
	public PieceRechangeReparation findPieceRechangeReparationById(Long id);
	public PieceRechangeReparation addPieceRechangeReparation(PieceRechangeReparation pRR);
	public PieceRechangeReparation updatePieceRechangeReparation(PieceRechangeReparation pRR);
	public void deletePieceRechangeReparation(Long id);
	public int findQte(PieceRechange pR);
	public List<PieceRechangeReparation> findByReparation(Reparation reparation);

}