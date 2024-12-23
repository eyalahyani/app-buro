package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.PieceRechange;
import org.LahyaniEya.App_Buro.Repository.PieceRechangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@NoArgsConstructor
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class PieceRechangeServiceImpl implements PiéceRechangeService {
	@Autowired
	private PieceRechangeRepository pieceRechangeRepo;

	@Override
	public List<PieceRechange> findAll() {
		return pieceRechangeRepo.findAll();
	}

	@Override
	public PieceRechange findById(Long id) {
		PieceRechange p= pieceRechangeRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Piece Rechange not found with ID: " + id));
		//  p.setPrixTTC(p.getPrixTTC());
		//	p.setTVA(p.getTVA());
		return p;
			
	}

	@Override
	public PieceRechange addPieceRechange(PieceRechange pR) {
	  pR.setPrixTTC(pR.getPrixTTC());
	//	pR.setTVA(pR.getTVA());
		return 	pieceRechangeRepo.save(pR);
	}

	@Override
	public PieceRechange updatePieceRechange(PieceRechange pR) {
		PieceRechange pieceRech =this.findById(pR.getId());
        pieceRech.setCode(pR.getCode());
        pieceRech.setNom(pR.getNom());
        pieceRech.setTVA(pR.getTVA());
		pieceRech.setQteDisp(pR.getQteDisp());
        pieceRech.setPrixAchat(pR.getPrixAchat());
        pieceRech.setPrixHT(pR.getPrixHT());
        pieceRech.setTypePiece(pR.getTypePiece());
    	return this.addPieceRechange(pieceRech);
		
	}

	@Override
	public void deletePieceRechange(Long id) {
		PieceRechange pieceRech = pieceRechangeRepo.getReferenceById(id); 
        if (pieceRech!=null) {
		pieceRechangeRepo.delete(pieceRech);
		}		
	}
	

}
