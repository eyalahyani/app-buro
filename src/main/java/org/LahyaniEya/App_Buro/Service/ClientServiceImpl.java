package org.LahyaniEya.App_Buro.Service;

import org.LahyaniEya.App_Buro.Model.Client;
import org.LahyaniEya.App_Buro.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepo;

	@Override
	public List<Client> findAll() {
        return clientRepo.findAll();
	}

	@Override
	public Client getClientById(Long id) {
	    return clientRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
	}


	@Override
	public Client updateClient(Client c) {
		 Client client = this.getClientById(c.getId());
	        if (client != null) {
	        	client.setNom(c.getNom());
	        	client.setAdresse(c.getAdresse());
	        	client.setNumTel(c.getNumTel());
	            clientRepo.save(client);
	        } else {
	            this.addClient(client);
	        }
	        
	        return client;
	}

	@Override
	public void deleteClient(Long id) {
		 Client client = clientRepo.getReferenceById(id);
	        if (client != null) {
	            clientRepo.delete(client);
	        }		
	}

	@Override
	public List<Client> findAllName(String Name) {
         return clientRepo.findByNom(Name); 

	}

	@Override
	public Client addClient(Client c) {
        return clientRepo.save(c);
    }





   
}
