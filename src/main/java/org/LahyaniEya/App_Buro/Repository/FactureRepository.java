package org.LahyaniEya.App_Buro.Repository;

import org.LahyaniEya.App_Buro.Model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface FactureRepository extends JpaRepository<Facture, Long> {
	public Facture findByNumero(String numero);
}
