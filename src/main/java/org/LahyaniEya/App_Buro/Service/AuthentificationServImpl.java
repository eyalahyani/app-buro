package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.Authentification;
import org.LahyaniEya.App_Buro.Repository.AuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationServImpl implements AuthentificationService {
	@Autowired
	private AuthentificationRepository authentificationRepo;

	@Override
	public List<Authentification> findAllAuthentification() {
		return authentificationRepo.findAll();
	}

	@Override
	public Authentification addAuthentification(Authentification authentification) {
		return authentificationRepo.save(authentification);
	}

	@Override
	public Authentification updateAuthentification(Authentification authentification) {
		Authentification a=authentificationRepo.findById(authentification.getId())	        
				.orElseThrow(() -> new RuntimeException("Authentification not found with ID: " + authentification.getId()));
		if(a!=null) {
			a.setEmail(authentification.getEmail());
			a.setMdp(authentification.getMdp());
			a.setRole(authentification.getRole());
			return this.addAuthentification(a);
		}
		return this.addAuthentification(authentification);
	}

	@Override
	public void deleteAuthentification(Long id) {
		Authentification a=this.findById(id);
		 authentificationRepo.delete(a);
	}

	@Override
	public Authentification findById(Long id) {
		return authentificationRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Authentification not found with ID: " + id));
		
				
	}

	@Override
	public int findAuthentificationByRole(Authentification authentification) {
		Authentification a=this.findById(authentification.getId());
		return a.getRole();
	}
	
}
