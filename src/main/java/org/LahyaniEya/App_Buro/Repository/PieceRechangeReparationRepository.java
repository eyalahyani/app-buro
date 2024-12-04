package org.LahyaniEya.App_Buro.Repository;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.PieceRechangeReparation;
import org.LahyaniEya.App_Buro.Model.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PieceRechangeReparationRepository extends JpaRepository<PieceRechangeReparation, Long> {
	   List<PieceRechangeReparation> findByReparation(Reparation reparation);
}
