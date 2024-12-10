package org.LahyaniEya.App_Buro.Service;

import java.util.List;

import org.LahyaniEya.App_Buro.Model.TypePiece;
import org.LahyaniEya.App_Buro.Repository.TypePieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@NoArgsConstructor
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class TypePieceRechangeServiceImpl implements TypePieceRechangeService {
	@Autowired
	private TypePieceRepository typePieceRepo;

	@Override
	public List<TypePiece> findAllTypePiece() {
        return typePieceRepo.findAll();
	}

	@Override
	public TypePiece findTypePieceById(Long id) {
		TypePiece tp= typePieceRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Type Piece not found with ID: " + id));
				tp.setTarifh(tp.getTarifh());
				return tp;
	}

	@Override
	public TypePiece addTypePiece(TypePiece tP) {
    	 return typePieceRepo.save(tP);
	}

	@Override
	public TypePiece updateTypePiece(TypePiece tP) {
		TypePiece typePieceR = this.findTypePieceById(tP.getId());
		if (typePieceR!=null) {
        	typePieceR.setType(tP.getType());
			typePieceR.setTarifh(tP.getTarifh());
			return typePieceRepo.save(typePieceR);
        }
		else{
			return this.addTypePiece(tP);
		}
	}

	@Override
	public void deleteTypePiece(Long id) {
			TypePiece typePiece = this.findTypePieceById(id); // Recherche de l'objet
			if (typePiece != null) {
				typePieceRepo.delete(typePiece); // Suppression si l'objet existe
			} else {
				// Vous pouvez ajouter un traitement ici si l'objet n'existe pas
				throw new RuntimeException("TypePiece not found with id: " + id);
        }		
	}
	
	
}
