package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.PieceRechange;
import org.LahyaniEya.App_Buro.Model.PieceRechangeReparation;
import org.LahyaniEya.App_Buro.Model.Reparation;
import org.LahyaniEya.App_Buro.Repository.PieceRechangeReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@NoArgsConstructor
@Transactional(rollbackOn = Exception.class)
@Slf4j

public class PieceRechangeReparationSeviceImpl implements PieceRechangeReparationService {
	@Autowired
	private PieceRechangeReparationRepository pieceRechangeReparationRepo;
	@Autowired
	private PieceRechangeServiceImpl pieceRechangeSerImp;
	@Autowired 
	private ReparationServiceImpl reparationServImp;
	
	@Override
	public PieceRechangeReparation addPieceRechangeReparation(PieceRechangeReparation pRR) {
	    if (pRR.getQte() <= 0) {
	        throw new IllegalArgumentException("La quantité doit être supérieure à zéro.");
	    }
	    

	    PieceRechange pieceRechange = pieceRechangeSerImp.findById(pRR.getPieceRechange().getId());
	    List<PieceRechangeReparation> p=this.findAllPieceRechangeReparation();
	    if (pieceRechange.getQteDisp() >= pRR.getQte()) {
	        pieceRechange.setQteDisp(pieceRechange.getQteDisp() - pRR.getQte());
	        pieceRechangeSerImp.addPieceRechange(pieceRechange);
	        return pieceRechangeReparationRepo.save(pRR);
	    } else {
	        throw new IllegalArgumentException("Stock insuffisant pour cette pièce.");
	    }
	}


	@Override
	public int findQte(PieceRechange pR) {
	    PieceRechange piece = pieceRechangeSerImp.findById(pR.getId());
	    if (piece != null) {
	        return piece.getQteDisp();
	    }
	    throw new IllegalArgumentException("Pièce de rechange non trouvée.");
	}
	
	@Override
	public List<PieceRechangeReparation> findAllPieceRechangeReparation() {
        return pieceRechangeReparationRepo.findAll();
	}

	@Override
	public PieceRechangeReparation findPieceRechangeReparationById(Long id) {
		return pieceRechangeReparationRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Piece Rechange Reparation not found with ID: " + id));
	}



	@Override
	public PieceRechangeReparation updatePieceRechangeReparation(PieceRechangeReparation pieceRechangeReparation) {
	    PieceRechangeReparation existingPRR = this.findPieceRechangeReparationById(pieceRechangeReparation.getId());
	    if (existingPRR != null) {
	        int availableQty = existingPRR.getPieceRechange().getQteDisp() + existingPRR.getQte();
	     	        if (pieceRechangeReparation.getQte() <= availableQty) {
	            int newAvailableQty = availableQty - pieceRechangeReparation.getQte();
	            existingPRR.getPieceRechange().setQteDisp(newAvailableQty);

	            existingPRR.setPieceRechange(pieceRechangeReparation.getPieceRechange());
	            existingPRR.setQte(pieceRechangeReparation.getQte());
	            existingPRR.setReparation(pieceRechangeReparation.getReparation());

	            return pieceRechangeReparationRepo.save(existingPRR);
	        } else {
	            throw new IllegalArgumentException("Stock insuffisant pour cette pièce.");
	        }
	    } else {
	        return this.addPieceRechangeReparation(pieceRechangeReparation);
	    }
	}


	@Override
	public void deletePieceRechangeReparation(Long id) {
		PieceRechangeReparation pRR=pieceRechangeReparationRepo.getReferenceById(id);
        if (pRR!=null) {
        	pieceRechangeReparationRepo.delete(pRR);
        }		
	}

	@Override
	public double calculeMontantTotal(Reparation pRR) {
		Reparation r=reparationServImp.findReparationById(pRR.getId());
		List<PieceRechangeReparation>list = pieceRechangeReparationRepo.findByReparation(pRR);
		double prix = r.getTarifHMO()*r.getTempsMO();
		for (PieceRechangeReparation pieceRechangeReparation : list) {
		   prix = prix + pieceRechangeReparation.getPieceRechange().getPrixTTC()*pieceRechangeReparation.getQte();
		}
		
        return prix;
	}


	@Override
	public List<PieceRechangeReparation> findByReparation(Reparation reparation) {
		return pieceRechangeReparationRepo.findByReparation(reparation);
	}



	

}

