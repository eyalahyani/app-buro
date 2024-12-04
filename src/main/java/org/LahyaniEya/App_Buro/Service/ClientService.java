package org.LahyaniEya.App_Buro.Service;

import java.util.List;
import org.LahyaniEya.App_Buro.Model.Client;

public interface ClientService {
	public List<Client> findAll();
	public List<Client> findAllName(String Name);
	public Client getClientById(Long id);
	public Client addClient(Client c);
	public Client updateClient(Client c);
	public void deleteClient(Long id);
	
}
