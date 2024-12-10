package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.Authentification;

public interface AuthentificationService {
	public List<Authentification> findAllAuthentification();
	public Authentification addAuthentification(Authentification authentification);
	public Authentification updateAuthentification(Authentification authentification);
	public Authentification findById(Long id);
	public int findAuthentificationByRole(Authentification authentification);
	public void deleteAuthentification(Long id);
	public Authentification findByEmailAndMdp(String email,String mdp);


}
