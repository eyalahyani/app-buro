package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.PieceRechange;
import org.LahyaniEya.App_Buro.Model.PieceRechangeReparation;
import org.LahyaniEya.App_Buro.Model.Reparation;
import org.LahyaniEya.App_Buro.Model.TypePiece;
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

	
	@Override
	public PieceRechangeReparation addPieceRechangeReparation(PieceRechangeReparation pRR) {
		PieceRechange pieceRechange = pieceRechangeSerImp.findById(pRR.getPieceRechange().getId());
		//TypePiece typePiece = pieceRechange.getTypePiece();
		//System.out.println(typePiece.toString());
		List<PieceRechangeReparation>  pieceRR = pieceRechangeReparationRepo.findByReparation(pRR.getReparation());
		for (PieceRechangeReparation pr : pieceRR){
			
			if (pRR.getPieceRechange().equals(pr.getPieceRechange()) && ((pieceRechange.getQteDisp() >= (pRR.getQte() - pr.getQte())))) {
				pr.setQte(pRR.getQte());
				pr.setPrixPieceRechangeReparationHTX(this.calculatePrixPieceRechangeReparationHTX(pRR)); 
				return pieceRechangeReparationRepo.save(pr);
			}
		}

	    if (pieceRechange.getQteDisp() >= pRR.getQte()) {
	        pieceRechange.setQteDisp(pieceRechange.getQteDisp() - pRR.getQte());
	        pieceRechangeSerImp.addPieceRechange(pieceRechange);
			pRR.setPrixPieceRechangeReparationHTX(this.calculatePrixPieceRechangeReparationHTX(pRR)); 
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
				existingPRR.setPrixPieceRechangeReparationHTX(this.calculatePrixPieceRechangeReparationHTX(pieceRechangeReparation)); 
				
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
	public List<PieceRechangeReparation> findByReparation(Reparation reparation) {
		return pieceRechangeReparationRepo.findByReparation(reparation);
	}


	public double calculatePrixPieceRechangeReparationHTX(PieceRechangeReparation  pieceRechangeReparation) {
		double prixPieceRechangeReparationHTX = 0.0;
		PieceRechange pieceRechange = pieceRechangeSerImp.findById(pieceRechangeReparation.getPieceRechange().getId());
		TypePiece typePiece = pieceRechange.getTypePiece();
        if (pieceRechangeReparation.getPieceRechange() != null && pieceRechangeReparation.getReparation() != null) {
            prixPieceRechangeReparationHTX = (pieceRechange.getPrixHT()  
                + typePiece.getTarifh())* pieceRechangeReparation.getQte();
        }
		return prixPieceRechangeReparationHTX;
    }

}