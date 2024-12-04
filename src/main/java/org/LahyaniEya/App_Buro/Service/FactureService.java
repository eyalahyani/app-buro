package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.Facture;

public interface FactureService {
	public List<Facture> findAllFacture();
	public Facture addFacture(Facture f);
	public Facture findByIdFacture(Long id);
	public Facture updateFacture(Facture f);
	public void deleteFacture(Long id);
	public Facture findByNumero(String numero);
	
}
