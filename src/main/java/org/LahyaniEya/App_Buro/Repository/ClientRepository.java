package org.LahyaniEya.App_Buro.Repository;

import org.LahyaniEya.App_Buro.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
   public List<Client> findByNom(String name);
   
}
