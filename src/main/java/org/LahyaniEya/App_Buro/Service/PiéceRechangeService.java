package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.PieceRechange;

public interface PiéceRechangeService {
	
	public List<PieceRechange> findAll();
	public PieceRechange findById(Long id);
	public PieceRechange addPieceRechange(PieceRechange pR);
	public PieceRechange updatePieceRechange(PieceRechange pR);
	public void deletePieceRechange(Long id);
}
